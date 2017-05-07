<jsp:include page="studentprofilesidebar.jsp"></jsp:include>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
    
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
  <h3>Edit Profile</h3>
   
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
   
    <input type="text" class="form-control" name="fn"  placeholder="Edit your first name" value="<%=rs.getString("firstname") %>" required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Last Name:</label>
    <input type="text" class="form-control" name="ln" placeholder="Edit your last name" value="<%=rs.getString("lastname") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Password:</label>
   
    <input type="password" class="form-control" name="password"  placeholder="Edit password" value="<%=rs.getString("password") %>" required="required">
  </div>
  
  
  <div class="form-group">
    <label for="firstname">Year :</label>
   
    <input type="text" class="form-control" name="year"  placeholder="Edit year" value="<%=rs.getString("year") %>" required="required">
  </div>

  
  <div class="form-group">
    <label for="firstname">Advisor Info:</label>
   
    <input type="text" class="form-control" name="advisorinfo"  placeholder="Edit advisor info" value="<%=rs.getString("advisorinfo") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Phone:</label>
   
    <input type="text" class="form-control" name="phone"  placeholder="Edit phone" value="<%=rs.getString("phone") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Email:</label>
   
    <input type="text" class="form-control" name="email"  placeholder="Edit email" value="<%=rs.getString("email") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Status:</label>
   
    <input type="text" class="form-control" name="status"  placeholder="Edit email" value="<%=rs.getString("status") %>" required="required">
  </div>
  
  
  <%} %>
  <button type="submit" class="btn btn-primary btn-lg active" name="submit">Update</button>
  </div>
</form>
</body>
</html>