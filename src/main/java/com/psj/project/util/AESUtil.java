package com.psj.project.util;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES 유틸 (문자열 전용)
 * - 모드: AES/GCM/NoPadding
 * - 키 문자열이 32바이트보다 짧으면 '.'로 패딩해 32바이트로 맞춤(AES-256)
 * - 키 문자열이 32바이트를 초과하면 예외
 * - 결과 포맷: "ivBase64:cipherBase64"
 */
public final class AESUtil {

    private AESUtil() {}

    // ===== 키 문자열(ASCII 권장) =====
    // 예: 20글자면 나머지 12바이트를 '.'로 채워 32바이트로 맞춥니다.
    private static final String KEY_STRING = "ProgramCnt"; // 예시

    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int IV_LEN = 12;     // GCM 권장 12바이트
    private static final int TAG_BITS = 128;  // 인증 태그 128비트
    private static final SecureRandom RNG = new SecureRandom();

    /** 문자열 암호화 → "ivBase64:cipherBase64" 반환 */
    public static String encryptString(String plain) throws Exception {
        if (plain == null) throw new IllegalArgumentException("plain이 비었습니다.");

        byte[] key = key32BytesPaddedWithDot(KEY_STRING);
        byte[] iv  = new byte[IV_LEN];
        RNG.nextBytes(iv);

        Cipher enc = Cipher.getInstance(TRANSFORMATION);
        enc.init(
            Cipher.ENCRYPT_MODE,
            new SecretKeySpec(key, "AES"),
            new GCMParameterSpec(TAG_BITS, iv)
        );

        byte[] ct = enc.doFinal(plain.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(iv) + ":" +
               Base64.getEncoder().encodeToString(ct);
    }

    /** "ivBase64:cipherBase64" → 문자열 복호화 */
    public static String decryptToString(String payload) throws Exception {
        if (payload == null) throw new IllegalArgumentException("payload가 비었습니다.");

        String[] parts = payload.split(":", 2);
        if (parts.length != 2) throw new IllegalArgumentException("잘못된 payload 형식(기대: iv:cipher)");

        byte[] key = key32BytesPaddedWithDot(KEY_STRING);
        byte[] iv  = Base64.getDecoder().decode(parts[0]);
        byte[] ct  = Base64.getDecoder().decode(parts[1]);

        Cipher dec = Cipher.getInstance(TRANSFORMATION);
        dec.init(
            Cipher.DECRYPT_MODE,
            new SecretKeySpec(key, "AES"),
            new GCMParameterSpec(TAG_BITS, iv)
        );

        byte[] pt = dec.doFinal(ct);
        return new String(pt, StandardCharsets.UTF_8);
    }

    // ===== 내부: 키 문자열을 32바이트로 패딩(ASCII 권장) =====
    private static byte[] key32BytesPaddedWithDot(String keyStr) {
        // UTF-8 바이트 기준으로 32바이트 맞춤 (ASCII 사용 권장)
        byte[] raw = keyStr.getBytes(StandardCharsets.UTF_8);
        if (raw.length > 32) {
            throw new IllegalStateException("KEY_STRING의 UTF-8 바이트 길이가 32를 초과합니다: " + raw.length);
        }
        if (raw.length == 32) return raw;

        // '.'(0x2E)로 채우기
        byte[] out = new byte[32];
        System.arraycopy(raw, 0, out, 0, raw.length);
        for (int i = raw.length; i < 32; i++) out[i] = 0x2E; // '.'
        return out;
    }
}