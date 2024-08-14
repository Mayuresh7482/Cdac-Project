<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<h5 class="p-2">Donors List</h5>
<table class="table table-bordered">
<thead>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email Id</th>
		<th>Phone no</th>
		<th>Address</th>
		<th>Type</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${list }" var="l">
		<tr>
			<td>${l.id }</td>
			<td>${l.name }</td>
			<td>${l.email }</td>
			<td>${l.phone }</td>
			<td>${l.address }</td>
			<td>${l.type }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>