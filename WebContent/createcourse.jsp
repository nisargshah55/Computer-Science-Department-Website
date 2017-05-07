<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="coursesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
 
<div class="col-md-4"></div>
<div class="col-md-4">
<div class="text-center">
<form action="<%=request.getContextPath()%>/createcourse">
<%HttpSession s=request.getSession();
String netid=(String)s.getAttribute("netid");%>

<div class="form-group">
    <label for="firstname">Course Number:</label>
    
    <input type="text" name="courseno" placeholder="Enter course no"  class="form-control" required="required">
  </div>

<div class="form-group">
    <label for="firstname">Course Name:</label>
    <input type="text" name="coursename" placeholder="Enter course name" class="form-control" required="required">
    
  </div>

<button type="submit" class="btn btn-primary btn-lg active" name="submit">Create</button>

${error_name }
</form>
</div>
</div>
<div class="col-md-4"></div>

</body>
</html>