<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">
<head>

<!-- Mobile Specific Metas -->
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Basic Page Needs -->
<title>My Account | Login</title>
<body class="single single-post postid-224 single-format-standard">

	<div class="entire-site-wrap">
		<div class="site-margin">
			<div class="site-wrap-shadow">

				<!-- end of menu and logo section -->

				<!--slider for pages area-->
				<section class="section-wrap">
					<div class="container">
						<div class="row">

							<div class="col-md-9">
								<h1 class="nomargin lh-40">로그인/회원가입</h1>
							</div>
							<!--end 9 col-->

							<div class="col-md-3">
								<form method="get" id="searchForm"
									action="http://aonethemes.com/infinitygrid/">
									<div class="search-wrapper">
										<div class="search-icon"></div>
										<input type="text" maxlength="30" name="s" id="s"
											class="search_input" /> <input type="submit"
											id="searchSubmit" />
									</div>
								</form>
							</div>
							<!--end 3col-->

						</div>
						<!--end row-->
					</div>
					<!--end container-->
				</section>

				<!--section-->

				<section class="section-wrap nopads">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="hrrule"></div>
							</div>
						</div>
					</div>
				</section>

				<section class="section-wrap">
					<div class="container">
						<div class="row">

							<div class="col-md-9 bumpnorm">
								<div class="singlewrap colored">


									<!-- You can start editing here. -->
									<!-- If comments are open, but there are no comments. -->


									<div id="respond" class="comment-respond">
										<!-- <h3 id="reply-title" class="comment-reply-title">로 그 인</h3> -->
										<form action="<c:url value='/admin/adminLoginProcess'/>"
											method="POST" class="comment-form">
											<p class="comment-notes"></p>
											<p class="comment-form-author">
												<label for="nttSj">아이디 <span class="required">*</span>
												</label> <input id="j_username" name="j_username" value="" size="50"
													class="textbar" aria-required="true" type="text"
													placeholder="아이디를 입력해 주세요" />
											</p>
											<p class="comment-form-comment">
												<label for="nttSj">비밀번호 <span class="required">*</span>
												</label> <input id="j_password" name="j_password" value="" size="50"
													class="textbar" aria-required="true" type="password"
													placeholder="비밀번호를 입력해 주세요" />
											</p>

											<p class="form-submit" style="margin-right: 3px;">
												<input name="submit" type="submit" id="goPut" class="cmnbtn"
													value="들어가기" />
											</p>
											<p class="form-submit" style="margin-right: 3px;">
												<a href="/"><input class="cmnbtn" value="취소"
													type="button" /></a>
											</p>
											<p class="form-submit">
												<a href="/register/registerUser"><input class="cmnbtn"
													value="회원가입" type="button" /></a>
											</p>
										</form>
									</div>
									<!-- #respond -->
								</div>
							</div>
							<!--end col8-->

						</div>
						<!--end row-->
					</div>
					<!-- ending container-->
				</section>

				<!--end section-->
			</div>
			<!--shadow-->
		</div>
		<!--margin-->
	</div>
	<!--end entiresite wrap-->

	<c:if test="${'1' eq fail}">
		<script type="text/javascript">
			$(function() {
				alert("비밀번호를 확인해주세요.");
			});
		</script>
	</c:if>
</body>
</html>