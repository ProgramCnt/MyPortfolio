package com.psj.project.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 날짜 유효성 체크 유틸(간단 버전).
 * - 기본 타임존: Asia/Seoul
 * - 연/월/일 개별 체크 함수
 * - 연/월/일을 한 번에 LocalDate로 치환 + 미래 금지 체크
 */
public final class DateValidityUtil {

    /** 기본 시간대(서울) */
    public static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Seoul");
    /** 연도 하한(프로젝트 정책에 맞게 조정 가능) */
    public static final int DEFAULT_MIN_YEAR = 1900;

    private DateValidityUtil() {}

    /** 기본(서울) 기준으로 검증: 유효하면 LocalDate 반환, 아니면 IllegalArgumentException */
    public static LocalDate requireValid(int year, int month, int day) {
        return requireValid(year, month, day, DEFAULT_ZONE);
    }

    /** 커스텀 Zone 기준으로 검증: 유효하면 LocalDate 반환, 아니면 IllegalArgumentException */
    public static LocalDate requireValid(int year, int month, int day, ZoneId zone) {
        requireValidYear(year, zone);
        requireValidMonth(month);
        requireValidDayOfMonth(year, month, day);

        LocalDate date = LocalDate.of(year, month, day);

        LocalDate today = LocalDate.now(zone);
        if (date.isAfter(today)) {
            throw new IllegalArgumentException("생년월일은 미래일 수 없습니다.");
        }
        return date;
    }

    /** 연도: [DEFAULT_MIN_YEAR, 현재년도(해당 Zone 기준)] */
    public static void requireValidYear(int year) {
        requireValidYear(year, DEFAULT_ZONE);
    }

    public static void requireValidYear(int year, ZoneId zone) {
        int currentYear = ZonedDateTime.now(zone).getYear();
        if (year < DEFAULT_MIN_YEAR || year > currentYear) {
            throw new IllegalArgumentException("연도 범위가 유효하지 않습니다: " + year);
        }
    }

    /** 월: 1~12 */
    public static void requireValidMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("월 범위가 유효하지 않습니다: " + month);
        }
    }

    /** 일: 1~해당 연/월의 최대 일수(윤년 자동 반영) */
    public static void requireValidDayOfMonth(int year, int month, int day) {
        requireValidMonth(month); // 월 선체크
        int maxDay = YearMonth.of(year, month).lengthOfMonth();
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException(
                "일 범위가 유효하지 않습니다: " + year + "-" + month + "-" + day + " (최대 " + maxDay + ")"
            );
        }
    }
    
    public static boolean isValid(int y, int m, int d) {
        try { requireValid(y, m, d); return true; }
        catch (IllegalArgumentException e) { return false; }
    }
}
