<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Current Account</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<div class="d-flex flex-column justify-content-center w-100">
		<div class="d-flex flex-column justify-content-center align-items-center w-80 mt-4">
			<h1 class="display-3 my-5">Create Current Account</h1>
			<form method="POST" style="display: flex; justify-content: center; flex-direction: column; width:60vw; align-items:center;">
				<div class="d-flex justify-content-between"> 
					£<input type="text" id="amount" name="amount" placeholder="Enter opening balance amount"
					style="margin: 5px; width:30vw" required>
				</div>
				<input type="range" id="overdraft" name="overdraft" min="0" max="1000" step="50" onchange="updateOutputVal(this.value);" style="width:30vw">
	  			<label for="volume" style="margin-right:5px;">Overdraft Limit </label>
	  			<input type="text" name="overdraft" id="overdraft-val" value="" style="width:30vw" readonly>
				<br> 

				<button type="submit" class="btn btn-secondary my-2" name="Create" value="Create"
					style="margin: 5px; width:30vw">Create</button>
			</form>
		</div>
	</div>

	<script>
	function updateOutputVal(val) {
        document.getElementById('overdraft-val').value=val; 
    }
	</script>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>