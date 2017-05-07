
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <jsp:include page="coursesidebarstudent.jsp"></jsp:include> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/styles.css" type="text/css" /> -->

</head>
<body>

<div class="col-md-4">
</div>


 

<div class="col-md-4">
<form action="<%=request.getContextPath() %>/viewcourserequirementstudent.jsp">
<%HttpSession s=request.getSession();
String s1=(String)s.getAttribute("netid");
dbconn db=new dbconn();
String fn=db.firstname(s1);
%><h2>Program</h2>
<div class="form-group">
  <label for="sel1">Select Program:</label>


<select class="form-control" name="program" >
<option value="">Select...</option>
<option value="MS">MS</option>
<option value="Phd">Phd</option>
<option value="BS">BS</option>
<option value="BA">BA</option>
</select>
   </div>              
    <button type="submit" class="btn btn-primary btn-lg active" name="submit">Submit</button>                                                                                    
</form>  

  </div>


</body>
</html>