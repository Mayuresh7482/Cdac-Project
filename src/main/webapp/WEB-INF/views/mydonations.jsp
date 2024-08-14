<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<h5 class="p-2">My Donations</h5>
<table class="table table-bordered">
<thead>
	<tr>
		<th>Id</th>
		<th>Food Type</th>
		<th>Cooking Date</th>
		<th>Cooking Time</th>
		<th>Quantity</th>
		<th>Status</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${list }" var="l">
		<tr>
			<td>${l.id }</td>
			<td>${l.foodtype }</td>
			<td>${l.cookdate }</td>
			<td>${l.cooktime}</td>
			<td>${l.qty }</td>
			<td>${l.status }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>