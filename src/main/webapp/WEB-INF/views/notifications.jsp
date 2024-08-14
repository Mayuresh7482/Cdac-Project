<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<h5 class="p-2">Agent Notifications</h5>
<table class="table table-bordered">
<thead>
	<tr>
		<th>Id</th>
		<th>Donor Name</th>
		<th>Donor Phone</th>
		<th>Food Type</th>
		<th>Cooking Date Time</th>
		<th>Quantity</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${list }" var="l">
		<tr>
			<td>${l.id }</td>
			<td>${l.donor.name }</td>
			<td>${l.donor.phone }</td>
			<td>${l.foodtype }</td>
			<td>${l.cookdate } ${l.cooktime}</td>
			<td>${l.qty }</td>
			<td>${l.status }
			<c:if test="${l.status eq 'In Process' }">
			<br><b>Admin Remarks : </b><br>${l.adminremarks }
			</c:if>
			</td>
			<td><a href="collect/${l.id }" class="btn btn-success btn-sm">Collect</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>