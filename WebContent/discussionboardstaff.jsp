<jsp:include page="discussionboardsidebarstaff.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="col-md-4">
</div>
<div id="container">
<div class="col-md-4">
<form action="<%=request.getContextPath()%>/discussiontopicstaff">
<div class="form-group">
    <label for="firstname">Enter Discussion Topic:</label>
    
    <input type="text" name="topic" placeholder="Enter discussion topic"  class="form-control" required="required">
  </div>

<button type="submit" class="btn btn-primary btn-lg active" name="submit">Submit</button>
</form>
</div>
</div>   
</body>
</html>