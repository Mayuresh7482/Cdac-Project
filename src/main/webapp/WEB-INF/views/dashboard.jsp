<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container">
<h5 class="p-2">Dashboard</h5>
	<div class="row">
		<div class="col-sm-3">
			<div class="card shadow">
				<div class="card-body bg-primary text-white text-right">
					<h4>Agents</h4>
					<h5>${agents }</h5>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="card shadow">
				<div class="card-body bg-danger text-white text-right">
					<h4>Donors</h4>
					<h5>${donors }</h5>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="card shadow">
				<div class="card-body bg-success text-white text-right">
					<h4>Food Collected</h4>
					<h5>${collects }</h5>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>