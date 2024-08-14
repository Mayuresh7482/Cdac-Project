<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container">
	<div class="row">
			<div class="col-sm-5 mt-2">
				<div class="card shadow">
					<div class="card-header text-center bg-success text-white">
						<h5>Process Donation</h5>
					</div>
					<div class="card-body">
					<input type="hidden" name="id" value="${d.id }">
					<div class="form-group">
					<label>Donor Name</label>
					<input type="text" readonly value="${d.donor.name }" required class="form-control">
					</div>
					<div class="form-group">
					<label>Food Type</label>
					<input type="text" readonly value="${d.foodtype }" required class="form-control">
					</div>
					<div class="form-group">
					<label>Quantity</label>
					<input type="text" readonly value="${d.qty }" required class="form-control">
					</div>
					<div class="form-group">
					<label>Cooking Date and Time</label>
					<input type="text" readonly value="${d.cookdate } ${d.cooktime}" required class="form-control">
					</div>
					<div class="form-group">
					<label>Status</label>
					<input type="text" readonly value="${d.status }" required class="form-control">
					</div>
					<c:if test="${d.status eq 'Pending' }">
						<a href="/updatestatus?id=${d.id }&status=Accepted" class="btn btn-success float-right px-4">Accept</a>
						<a href="/updatestatus?id=${d.id }&status=Rejected" class="btn btn-danger float-right px-4 mr-2">Reject</a>
					</c:if>
					<c:if test="${msg ne null }">
						<div class="alert text-success font-weight-bold">${msg }</div>
					</c:if>
					</div>
				</div>
			</div>
			<div class="col-sm-5 offset-1 mt-2">
			<c:if test="${d.status eq 'Accepted' }">
			<form method="post" action="/movetoagent">
				<div class="card shadow">
					<div class="card-header text-center bg-success text-white">
						<h5>Agent Process</h5>
					</div>
					<div class="card-body">
						<input type="hidden" name="id" value="${d.id }">
						<div class="form-group">
						<label>Select Agent</label>
						<select name="agentid" required class="form-control">
						<option value="">Select Agent</option>
						<c:forEach items="${list }" var="a">
							<option value="${a.id }">${a.name } - ${a.address }</option>
						</c:forEach>
						</select>
						</div>
						<div class="form-group">
						<label>Remarks</label>
						<textarea name="remarks" required class="form-control" rows="3"></textarea>
						</div>
						<button class="btn btn-success float-right">Submit</button>
					</div>
				</div>
				</form>
			</c:if>
			</div>
		</div>
</div>
</body>
</html>