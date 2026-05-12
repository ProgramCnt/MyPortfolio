<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.psj.project.util.DateValidityUtil" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Portfolio</title>
  <link rel="stylesheet" href="<c:url value='/css/test.css'/>">
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${mapAppKey}&autoload=false"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  <a class="skip-link" href="#main">본문으로 건너뛰기</a>
  <header class="site-header" role="banner">
    <div class="container">
      <div class="header-row">
        <h1 class="site-title">포트폴리오</h1>
        <nav class="site-nav" aria-label="주요 메뉴">
          <ul class="nav-list">
            <li><a href="#profile">프로필</a></li>
            <li><a href="#education">학력</a></li>
            <li><a href="#career">경력</a></li>
            <li><a href="#projects">프로젝트</a></li>
            <li><a href="#activities">활동</a></li>
            <li><a href="#qualifications">자격</a></li>
          </ul>
        </nav>
	  </div>
    </div>
  </header>

  <main id="main" class="site-main" role="main">
	
    <section id="viewPublic" class="view view-public">
      <div class="container">
        <!-- PersonalInfo -->
        <section id="profile" class="section">
          <header class="section-header">
            <h2 class="section-title">프로필</h2>
          </header>

          <article class="card profile-card">
            <div class="profile-media" aria-label="프로필 이미지">
              <!-- image_path/image_upload_name을 이용해 렌더링(서버/프론트 구현 시) -->
              <img class="profile-image" src="/image/oo.jpg" alt="프로필 이미지" />
<!--               <img class="profile-image" src="" alt="프로필 이미지" /> -->
            </div>
            <div class="profile-body">
              <dl class="kv">
                <div class="kv-row"><dt>생년월일</dt><dd data-field="birthday">2002-03-26</dd></div>
                <div class="kv-row"><dt>전화번호</dt><dd data-field="phone_number">010-9776-2504</dd></div>
              </dl>

              <p class="profile-intro" data-field="profile_intro">(API 개발 직무 희망자입니다.)</p>
              <ul class="chip-list" aria-label="프로필 키워드" data-list="profile_keywords">
              	<c:forEach var="skill" items="${skillList}">
                	<li class="chip">${skill }</li>
               	</c:forEach>
              </ul>
            </div>
          </article>
        </section>

        <!-- Education -->
        <section id="education" class="section">
          <header class="section-header">
            <h2 class="section-title">학력</h2>
          </header>

          <ul class="timeline" aria-label="학력 목록" data-list="education">
            <c:forEach var="school" items="${educationList}">
	            <li class="timeline-item card">
	              <div class="timeline-head">
	                <h3 class="item-title" data-field="major">${school.schoolName }(${school.major})</h3>
	                <p class="item-sub" data-field="school_type">학교 유형: ${school.schoolType }</p>
	              </div>
	              <dl class="kv">
	                <div class="kv-row"><dt>입학/졸업</dt><dd><span data-field="admit_graduate">${school.admitGraduate}</span></dd></div>
	                <div class="kv-row"><dt>입학일</dt><dd><span data-field="entrance_ceremony">${school.entranceCeremony}</span></dd></div>
	                <div class="kv-row"><dt>학습 과목</dt><dd data-field="learned_subject">${school.learnedSubject}</dd></div>
	              </dl>
	              <div class="item-desc" data-field="description">
	                ${school.description}
	              </div>
	            </li>
            </c:forEach>
          </ul>
        </section>

        <!-- Company / CompanyManaged -->
        <section id="career" class="section">
          <header class="section-header">
            <h2 class="section-title">경력</h2>
          </header>

          <div class="grid" data-list="company">
          	<c:forEach var="company" items="${companyList}">
	            <!-- 반복 카드 예시 -->
	            <article class="card company-card">
	              <header class="card-header">
	                <h3 class="item-title" data-field="company_name">${company.companyName}</h3>
	                <p class="item-sub">
	                  <span data-field="belonging">${company.belonging }</span> · <span data-field="position">${company.position}</span>
	                </p>
	              </header>
	
	              <p class="date-range">
	                <time data-field="work_start_date">${company.workStartDate}</time>
	                <span aria-hidden="true">~</span>
	                <c:if test="${!company.workEndDate.isEmpty()}">
	                	<time data-field="work_end_date">${company.workEndDate}</time>
	                </c:if>
	              </p>
              	  <section class="subsection" aria-label="담당/관리 업무">
	                <h4 class="subsection-title">담당/관리</h4>
	                <ul class="bullet-list" data-list="company_managed_for_company">
		                <c:forEach var="CompanyManaged" items="${companyManagedList}">
		              	  	<c:if test="${company.seq == CompanyManaged.companySeq}">
			                  <li>
			                    <details>
			                      <summary><span data-field="title">${CompanyManaged.title}</span></summary>
			                      <div class="detail-body" data-field="description">${CompanyManaged.description}</div>
			                    </details>
			                  </li>
			                </c:if>
			            </c:forEach>
	                </ul>
	              </section>
	            </article>
            </c:forEach>
          </div>
        </section>

        <!-- Project / ProjectDescription -->
        <section id="projects" class="section">
          <header class="section-header">
            <h2 class="section-title">프로젝트</h2>
          </header>

          <div class="grid" data-list="project">
          	<c:forEach var="project" items="${projectList}">
	            <!-- 반복 카드 예시 -->
	            <article class="card project-card">
	              <header class="card-header">
	                <h3 class="item-title" data-field="title">${project.title}</h3>
	                <p class="date-range">
	                  <time data-field="project_start_date">${DateValidityUtil.getYearMonth(project.projectStartDate)}</time>
	                  <span aria-hidden="true">~</span>
	                  <c:if test="${!project.projectEndDate.isEmpty()}">
	                  	<time data-field="project_end_date">${DateValidityUtil.getYearMonth(project.projectEndDate)}</time>
	                  </c:if>
	                </p>
	              </header>
	              <p class="item-desc" data-field="description">${project.description}</p>
					<c:forEach var="ProjectDescription" items="${projectDescriptionList}">
	              		<c:if test="${project.seq == ProjectDescription.projectSeq}">
			              <section class="subsection" aria-label="프로젝트 상세 설명">
			                <h4 class="subsection-title">상세</h4>
			                <ul class="bullet-list" data-list="project_descriptions_for_project">
			                  <!-- ProjectDescription은 FK가 없으므로, 구현에서 매핑 규칙 필요 -->
			                  <li>
			                    <details>
			                      <summary><span data-field="title">${ProjectDescription.title }</span></summary>
			                      <div class="detail-body" data-field="description">${ProjectDescription.description }</div>
			                    </details>
			                  </li>
			                </ul>
			              </section>
			            </c:if>
		            </c:forEach>
	            </article>
            </c:forEach>
          </div>
        </section>

        <!-- Activities -->
        <section id="activities" class="section">
          <header class="section-header">
            <h2 class="section-title">활동</h2>
          </header>
          <ul class="timeline" aria-label="활동 목록" data-list="activities">
          	<c:forEach var="acitvity" items="${activityList }">
	            <li class="timeline-item card">
	              <div class="timeline-head">
	                <h3 class="item-title" data-field="title">${acitvity.title }</h3>
	                <p class="date-range">
	                  <time data-field="activity_start_date">${DateValidityUtil.getYearMonth(acitvity.activityStartDate) }</time>
	                  <span aria-hidden="true">~</span>
	                  <time data-field="activity_end_date">${DateValidityUtil.getYearMonth(acitvity.activityEndDate) }</time>
	                </p>
	              </div>
	              <div class="item-desc" data-field="description">${acitvity.description }</div>
	            </li>
            </c:forEach>
          </ul>
        </section>

        <!-- Qualifications -->
        <section id="qualifications" class="section">
          <header class="section-header">
            <h2 class="section-title">자격</h2>
          </header>
          <div class="table-wrap" role="region" aria-label="자격 목록 (테이블)">
            <table class="data-table">
              <thead>
                <tr>
                  <th scope="col">자격명</th>
                  <th scope="col">단계/등급</th>
                  <th scope="col">취득일</th>
                </tr>
              </thead>
              <tbody data-list="qualifications">
              	<c:forEach var="qualification" items="${qualifications}">
	              	<tr>
	                  <td data-field="name">${qualification.name }</td>
	                  <td data-field="step">${qualification.step }</td>
	                  <td><time data-field="acquired_date">${qualification.acquiredDate}</time></td>
	                </tr>
              	</c:forEach>
              </tbody>
            </table>
          </div>
        </section>
        <footer class="site-footer">
          <div class="container">
            <div class="footer-info" aria-label="하단 정보">
              <p class="footer-line">
                <span class="footer-item"><strong>주소</strong>: <span data-field="address">서울특별시 강남구 자곡로 11길 28</span></span>
              </p>
              <p class="footer-line">
                <span class="footer-item"><strong>본 페이지의 퍼블리싱은 Chat GPT 사용하여 개발된 페이지입니다.</strong></span></span>
              </p>
            </div>
            <div id="map" style="width:1000px;height:400px;"></div>
            <p class="muted">© Portfolio</p>
          </div>
        </footer>
      </div>
    </section>
  </main>
</body>
</html>

<script>
var latitude = 37.478683518401375; //위도 좌표
var longitude = 127.10797271272384; //경도 좌표

kakao.maps.load(function () {
    var container = document.getElementById('map');

    var options = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 3
    };

    var map = new kakao.maps.Map(container, options);

    var markerPosition = new kakao.maps.LatLng(latitude, longitude);

    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

    marker.setMap(map);
});

</script>
