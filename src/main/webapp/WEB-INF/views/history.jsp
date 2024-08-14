<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<h5 class="p-2">Agent Collection History</h5>
<table class="table table-bordered">
<thead>
	<tr>
		<th>Id</th>
		<th>Donor Name</th>
		<th>Collect Date</th>
		<th>Collect Time</th>
		<th>Orphanage Name</th>
		<th>Address</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${list }" var="l">
		<tr>
			<td>${l.id }</td>
			<td>${l.donor.name }</td>
			<td>${l.collectdate }</td>
			<td>${l.collecttime }</td>
			<td>${l.orphan }</td>
			<td>${l.address }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>