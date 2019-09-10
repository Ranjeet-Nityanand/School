<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ include file="resource.jsp"%>
   <%@ include file="nav.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission</title>
</head>
<body>

<h1 class="pt-3" align="center">Add Student Information</h1><br>
	<%-- <h1 class="pt-3" align="center">${success}</h1> --%>
	
	<spring:form action="/add" method="post" enctype="multipart/form-data">
		<div class="container">
		
	<c:if test="${success!=null && success!= ''}">
	 <div id="alrt" class="alert alert-success alert-dismissible">
 	 <button type="button" class="close" data-dismiss="alert">&times;</button>
 	 <strong>Success!</strong> ${success}
   </div>
	</c:if>
	
	
  <c:if test="${fail!=null && fail!= ''}">
	  <div id="alrt1" class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>Error!</strong> ${fail}
	  </div>
   
  </c:if>
		
			<div class="row">
			<div class="col-md-5">
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
					<label for="name"><strong>Name:</strong></label> <input type="text" name="name"id="name"
						class="form-control">
				</div>
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
					<label for="fname"><strong>Father's Name:</strong></label> <input type="text" name="father"id="fname"
						class="form-control">
				</div>
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
					<label for="mobile"><strong>Mobile:</strong></label> <input type="text" name="mobile" id="mobile"
						class="form-control">
				</div>
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
					<label for="address"><strong>Address:</strong></label> <input type="text" name="address" id="address"
						class="form-control">
				</div>
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
					<label for="photo"><strong>Photo:</strong></label> <input type="file" name="file" id="photo"
						class="form-control">
				</div>
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
					<label for="class"><strong>Choose Class</strong></label>
					<select  name="classes" id="class" class="form-control align-items-center" >
					  <option value="">Select....</option>
					  <option value="n">Nursery</option>
					  <option value="l">LKG</option>
					  <option value="u">UKG</option>
					  <option value="1">1ST</option>
					</select>
				</div>
				<div class="co-sm-12 col-md-12 col-lg-12 col-xl-12 form-group" align="center">
					<button type="submit" class="btn btn-primary">Add <span class="fa fa-plus"></span></button>
				</div>
			</div>
			<div id="img" class="col-md-7">
			<img alt="students" src="images/demo/backgrounds/school4.jpg">
			</div>
			</div>
		</div>
	</spring:form>
	
				
<script src="layout/styles/fonts/myScript.js"></script>
</body>
</html>