<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<jsp:include page="profilesidebar.jsp"></jsp:include>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<form action="<%=request.getContextPath() %>/editprofile">
<div class="col-md-4">
</div>
<div class="col-md-4">
  <h3>View Profile</h3>
   
   <%HttpSession s=request.getSession();
		String netid=(String)s.getAttribute("netid");
		dbconn db=new dbconn();
		String profile="select * from login where netid='"+netid+"'";
		ResultSet rs=db.execute(profile);
		String fn=null;
		String ln=null;
		while(rs.next())
		{
		
		%>
    
 <div class="form-group">
    <label for="firstname">First Name:</label>
   <br>
   <%=rs.getString("firstname") %>
    
  </div>
 
  <div class="form-group">
    <label for="lastname">Last Name:</label>
    <br>
    <%=rs.getString("lastname") %>
    
  </div>
  <%} %>
  <!-- <button type="submit" class="btn btn-primary btn-lg active" name="submit">Edit</button> -->
  </div>
</form>
</body>
</html>