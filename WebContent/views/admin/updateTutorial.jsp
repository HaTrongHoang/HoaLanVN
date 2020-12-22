<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>
</head>

<body>
	<div class="page-wrapper">
		<!-- HEADER -->
		<jsp:include page="/views/admin/common/header.jsp"></jsp:include>
		<!-- MAIN CONTENT-->
		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-11">
							<div class="card">
								<div class="card-header">
									<strong>Chỉnh sử bài viết</strong>
								</div>
								<div class="card-body card-block">
									<form
										action="/HoaLanVN/admin/tutorial/update?id_tutorial=${tutorialUpdate.id_tutorial }"
										method="post" class="form-horizontal"
										enctype="multipart/form-data">
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="file-input" class=" form-control-label">Danh
													mục</label>
											</div>
											<div class="col-12 col-md-9">
												<select name="category_id" id="select" class="form-control"
													required>
													<c:forEach items="${categoryList }" var="listCategory">
														<option value="${listCategory.id_category }"
															<c:if test="${listCategory.id_category eq tutorialUpdate.category_id.id_category }">selected</c:if>>${listCategory.name }</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="row form-group">
											<div class="col col-md-3">
												<label for="file-input" class=" form-control-label">Thumbnail</label>
											</div>
											<div class="col-12 col-md-9">
												<img style="width: 200px" height="300px"
													src="${pageContext.request.contextPath }/upload/content/_thumbs/${tutorialUpdate.thumbnail }"
													name="img" alt="..." class="img-thumbnail"> <input
													type="file" id="file-input" name="thumb"
													class="form-control-file">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Tiêu đề</label>
											</div>
											<div class="col-12 col-md-9">
												<textarea name="title" id="textarea-input" rows="6"
													placeholder="Title..." class="form-control " value="">${tutorialUpdate.title }</textarea>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Mô tả</label>
											</div>
											<div class="col-12 col-md-9">
												<textarea name="describe" id="textarea-input" rows="6"
													placeholder="Describe..." class="form-control" value="">${tutorialUpdate.describe }</textarea>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Nội dung</label>
											</div>
											<div class="col-12 col-md-9">
												<textarea name="content" placeholder="Content..."
													class="form-control ckeditor">${tutorialUpdate.content }</textarea>
											</div>
										</div>
										<div class="card-footer">
											<button type="submit" class="btn btn-primary btn-sm">
												<i class="fa fa-dot-circle-o"></i> Submit
											</button>
											<button type="reset" class="btn btn-danger btn-sm">
												<i class="fa fa-ban"></i> Reset
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/admin/common/scriptJS.jsp"></jsp:include>
	<script>
		var value = request.getAttribute(newsUpdate);
		var editor = CKEDITOR.replace('editor');
		CKFinder.setupCKEditor(editor, '/HoaLanVN/library/ckfinder/');
	</script>
</body>
</html>