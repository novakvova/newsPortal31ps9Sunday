<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<jsp:include page="../../container/_link-css.jsp"></jsp:include>
<body>
	<jsp:include page="../../container/_header.jsp"></jsp:include>

	<main class="main">
	<div class="container">
		<h1 class="d-flex justify-content-center">Додати пост</h1>
		<form:form name="form" action="addPost" method="post"
			modelAttribute="categoryDTO">
			<div class="form-group">
				<label for="title">Назва категорії</label>
				<form:input path="name" type="text" class="form-control" id="title" />
			</div>
			<div class="form-group">
				<label for="urlSlug">Slug</label>
				<form:textarea path="urlSlug" name="content"
					class="editorFroala" id="urlSlug" />
			</div>
			<div class="form-group">
				<label for="description">Опис</label>
				<!-- 					<textarea id="edit" class="editorFroala" name="content"></textarea> -->
				<form:textarea path="description" name="content"
					class="editorFroala" id="description" />
			</div>
			
			<button type="submit" class="btn btn-primary">Додати</button>
		</form:form>
	</div>
	</main>

	<jsp:include page="../../container/_scripts.jsp"></jsp:include>
	<script
		src="${pageContext.request.contextPath}/resources/node_modules/froala-editor/js/froala_editor.pkgd.min.js"></script>
	<script>
		new FroalaEditor('.editorFroala', {
			// Set the image upload URL.
			imageUploadURL : 'http://localhost:8080/newsPortal/upload_image',
			imageUploadParams : {
				id : 'my_editor'
			}
		})
	</script>
</body>
</html>