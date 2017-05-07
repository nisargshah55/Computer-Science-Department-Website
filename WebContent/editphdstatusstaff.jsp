<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="staffprofilesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%String editid=request.getParameter("editid");
   
   		HttpSession s=request.getSession();
		String netid=(String)s.getAttribute("netid");
		String cno=(String)s.getAttribute("no");
		dbconn db=new dbconn();
		
		String fn=db.firstname(netid);
		HttpSession s1=request.getSession();
		s1.setAttribute("editid", editid);
		s1.setAttribute("firstname", fn);
		s1.setAttribute("cno", cno);
		String sql3 = "select * from login where id='"+editid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
		
	
<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/editphdstatusstaff">
     
 <div class="form-group">
    <label for="firstname">First Name:</label>
   
    <input type="text" class="form-control" name="fn"  placeholder="Edit your first name" value="<%=rs.getString("firstname") %>" required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Last Name:</label>
    <input type="text" class="form-control" name="ln" placeholder="Edit your last name" value="<%=rs.getString("lastname") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Year:</label>
   
    <input type="text" class="form-control" name="year"  placeholder="Edit year" value="<%=rs.getString("year") %>" required="required">
  </div>

<div class="form-group">
    <label for="firstname">Major:</label>
   
    <input type="text" class="form-control" name="major"  placeholder="Edit major" value="<%=rs.getString("major") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Status:</label>
   
    <input type="text" class="form-control" name="status"  placeholder="Edit status" value="<%=rs.getString("status") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="firstname">Semester:</label>
   
    <input type="text" class="form-control" name="semester"  placeholder="Edit semester" value="<%=rs.getString("semester") %>" required="required">
  </div>
  
 <%} %>
 
  <button type="submit" class="btn btn-primary btn-lg active" name="submit">Update</button>
  </form>
  </div>

</body>
</html>