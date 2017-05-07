<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="alumnisidebarstaff.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	
<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/postalumnistaff">
  <h3>Post Alumni Info</h3>
   
   			
	
    
 <div class="form-group">
    <label for="firstname">Name:</label>
   <br>
    <input type="text" class="form-control" name="name"  placeholder="Name" required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Foundation year:</label>
    <br>
    <input type="text" class="form-control" name="year" placeholder="Enter year" required="required">
  </div>
  
  <div class="form-group">
    <label for="lastname">Members:</label>
    <br>
    <input type="text" class="form-control" name="member" placeholder="Enter members" required="required">
    
  </div>
  
  <div class="form-group">
    <label for="lastname">Link:</label>
    <br>
    <input type="text" class="form-control" name="link" placeholder="Enter link" required="required">
    
  </div>
  
  <button type="submit" class="btn btn-primary btn-lg active" name="submit">Post</button>
  </form>
  </div>

</body>
</html>