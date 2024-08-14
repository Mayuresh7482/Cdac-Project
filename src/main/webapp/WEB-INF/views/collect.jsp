<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
			<div class="col-sm-4 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center bg-success text-white">
						<h5>Agent Collection Form</h5>
					</div>
					<div class="card-body">
						<form method="post" action="/collectfood">
						<input type="hidden" name="donationid" value="${d.id }">
						<input type="hidden" name="donorid" value="${d.donor.id }">
						<div class="form-group">
						<label>Donar Name</label>
						<input type="text" value="${d.donor.name }" readonly class="form-control">
						</div>
						<div class="form-group">
						<label>Date of Collection</label>
						<input type="date" name="cdate" required class="form-control">
						</div>
						<div class="form-group">
						<label>Time of Collection</label>
						<input type="time" name="ctime" required class="form-control">
						</div>
						<div class="form-group">
						<label>Orphanage Name</label>
						<input type="text" name="orphan" required class="form-control">
						</div>
						<div class="form-group">
						<label>Orphanage Address</label>
						<input type="text" name="address" required class="form-control">
						</div>
						<input type="submit" value="Submit" class="btn btn-success float-right px-4">
					</form>
					<c:if test="${msg ne null }">
						<div class="alert text-success font-weight-bold">${msg }</div>
					</c:if>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>