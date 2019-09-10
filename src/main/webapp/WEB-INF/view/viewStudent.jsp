<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="resource.jsp" %>
<%@ include file="nav.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
<style>
#imageholder{
		width: auto;
    max-height: 10%;
    width: 10px;
    margin: 0;
    padding: 0;
    border: 1px;
    line-height: normal;
    vertical-align: middle;
    }
</style>
</head>
<body>
<div class="container">
<h2 align="center">All Students</h2>
<table class="table table-primary table-striped table-hover table-boardered" id="tab">
<thead id="the">
<tr>
<th>Id</th>
<th>Name</th>
<th>Father's Name</th>
<th>Address</th>
<th>Mobile</th>
<th><span class="fa fa-eye"></span>View</th>		
<th><span class="fa fa-edit"></span>Edit</th>
<th><span class="fa fa-remove"></span>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach var="stud" items="${allStudent}">
<tr>
<td>${stud.id}</td>
<td>${stud.name}</td>
<td>${stud.father}</td>
<td>${stud.address}</td>
<td>${stud.mobile}</td>
<td align="center"><button type="button" id="view${stud.id}" onclick="view('${stud.id}')" class="view btn btn-primary"><i class="fa fa-eye"></i></button></td>
<td align="center"><button type="button" id="edit${stud.id}" onclick="edit('${stud.id}')" class="btn btn-warning"><i class="fa fa-edit"></i></button></td>
<td align="center"><button type="button" id="delete${stud.id}" onclick="delet('${stud.id}')" class="btn btn-danger"><i class="fa fa-remove"></i></button></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div  class="container" id="dialog" title="View Students">
<div class="form-group">
<div class="row">
<div class="col-md-6">
	<label for="name">Name:</label>
  <input type="text" class="form-control" id="name" >
  </div>
  <div class="col-md-6">
  <label for="father">Father:</label>
  <input type="text" class="form-control" id="father" >
  </div>
  <div class="col-md-6">
  <label for="address">Address:</label>
  <input type="text" class="form-control" id="address" >
  </div>
  <div class="col-md-6">
  <label for="mobile">Mobile:</label>
  <input type="text" class="form-control" id="mobile" >
  </div>
  <div id="imageholder" class="col-md-6" >
  <img alt="Image" id="img">
  </div>
  </div>
</div>
</div>
 <div>
 </div>

<div class="container">
<c:forEach items="${allStudent}" var="img">
<img src="${img.image}">
</c:forEach>
</div>







<script src="layout/styles/fonts/myScript.js"></script>

<script>


	


</script>

</body>

</html>