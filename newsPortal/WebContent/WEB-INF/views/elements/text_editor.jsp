<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../container/_link-css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../container/_header.jsp"></jsp:include>

	<main class="main">

		<div class="container">
			<div class="sample">
				<h4>Введіть текст:</h4>
				<form>
					<textarea id="edit" name="content"></textarea>
				</form>
			</div>
		</div>
	</main>
	
	<jsp:include page="../container/_scripts.jsp"></jsp:include>
	<script
		src="${pageContext.request.contextPath}/resources/node_modules/froala-editor/js/froala_editor.pkgd.min.js"></script>
	<script>
		new FroalaEditor('#edit', {
			// Set the image upload URL.
			imageUploadURL : 'http://localhost:8080/newsPortal/upload_image',
			imageUploadParams : {
				id : 'my_editor'
			}
		})
	</script>
</body>
</html>
