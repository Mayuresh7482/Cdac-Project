<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
			<div class="col-sm-4 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center bg-success text-white">
						<h5>Donation Form</h5>
					</div>
					<div class="card-body">
						<form method="post">
						<div class="form-group">
						<label>Food Type</label>
						<input type="text" name="foodtype" required class="form-control">
						</div>
						<div class="form-group">
						<label>Quantity</label>
						<input type="text" name="qty" required class="form-control">
						</div>
						<div class="form-group">
						<label>Date of Cooking</label>
						<input type="date" name="cookingdate" required class="form-control">
						</div>
						<div class="form-group">
						<label>Time of Cooking</label>
						<input type="time" name="cookingtime" required class="form-control">
						</div>
						<div class="form-group">
						<label>Address to Collect</label>
						<input type="text" name="address" required class="form-control">
						</div>
						<input type="submit" value="Donate Now" class="btn btn-success float-right px-4">
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