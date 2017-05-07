<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="staffresourcesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="container">
<div class="col-md-4"></div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/createresource">
<div class="form-group">
    <label for="firstname">Resource Name:</label>
    
    <input type="text" name="name" placeholder="Enter resource name"  class="form-control" required="required">
  </div>
<div class="form-group">
    <label for="firstname">Resource Type:</label>
    
    <input type="text" name="type" placeholder="Enter resource type"  class="form-control" required="required">
  </div>
<div class="form-group">
    <label for="firstname">Resource Information:</label>
    <textarea rows="5" cols="50" name="info" placeholder="Enter resource information"  class="form-control" required="required"></textarea>
    
  </div>

<!-- Resource Name:
<input type="text" name="name" >
<br>
<br>
Resource Type:
<input type="text" name="type">
<br>
<br>
Resource Information:<br>
<textarea rows="5" cols="50" name="info"></textarea>
<br>
<br> 
<input type="submit" value="Create"> -->
<button type="submit" class="btn btn-primary btn-lg active" name="submit">Create</button>
</form>
</div>
</div>
</body>
</html>