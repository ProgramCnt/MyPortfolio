# 박성주 포트폴리오 프로젝트 (ProgramCnt)

개인 이력/프로젝트/기술 역량을 웹으로 정리한 **포트폴리오 아카이브**입니다.

## 프로젝트 한 줄 소개

Spring Boot + MyBatis + JSP 기반으로 경력, 프로젝트, 기술 스택, 학력/활동 이력을 구조화해 보여주는 포트폴리오 웹 애플리케이션입니다.

## 포트폴리오에서 보여주고 싶은 점

- **백엔드 구조화 역량**
  - Controller → Service → DAO 계층 분리
  - 모델 기반 데이터 매핑 및 조회 구조 설계
- **데이터 중심 포트폴리오 구성**
  - 기술/학력/활동/자격증/회사/프로젝트 데이터를 DB 중심으로 통합 관리
- **실무형 스택 경험**
  - Spring Boot, MyBatis, SQL Server, JSP/JSTL 기반의 전통적인 웹 서비스 구조 구현

## 주요 화면/콘텐츠

- `test.jsp` (메인 포트폴리오)
  - 개인 정보
  - 기술 스택
  - 학력 및 대외활동
  - 자격증
  - 경력/회사 정보
  - 프로젝트 및 상세 설명

## 기술 스택

- **Language / Runtime**: Java 21
- **Framework**: Spring Boot 3.5.x
- **Persistence**: MyBatis
- **Database**: Microsoft SQL Server
- **View**: JSP, JSTL
- **Build**: Maven

## 코드 구조

```text
src/main/java/com/psj/project
├─ controller        # 화면 요청/응답 제어
├─ service           # 도메인 데이터 조합
├─ dao               # DB 접근
├─ model             # 포트폴리오 데이터 모델
└─ util              # 공통 유틸

src/main/resources
├─ mappers           # MyBatis SQL 매퍼
└─ application.properties

src/main/webapp/WEB-INF/views/jsp
└─ test.jsp          # 포트폴리오 메인
