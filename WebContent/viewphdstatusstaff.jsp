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
<%String viewid=request.getParameter("viewid");
   
   		HttpSession s=request.getSession();
		String netid=(String)s.getAttribute("netid");
		String cno=(String)s.getAttribute("no");
		dbconn db=new dbconn();
		
		String fn=db.firstname(netid);
		HttpSession s1=request.getSession();
		s1.setAttribute("editid", viewid);
		s1.setAttribute("firstname", fn);
		s1.setAttribute("cno", cno);
		String sql3 = "select * from login where id='"+viewid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
		
	
<div class="col-md-4">
</div>
<div class="col-md-4">

<h2>Phd Status</h2>     
 <div class="form-group">
    <label for="firstname">First Name:</label>
   
    <%=rs.getString("firstname") %>
  </div>
 
  <div class="form-group">
    <label for="lastname">Last Name:</label>
    <%=rs.getString("lastname") %>
  </div>
  
  <div class="form-group">
    <label for="firstname">Year:</label>
   
    <%=rs.getString("year") %>
  </div>

<div class="form-group">
    <label for="firstname">Major:</label>
   
   <%=rs.getString("major") %>
  </div>
 
 
 <div class="form-group">
    <label for="firstname">Semester:</label>
   <br>
   <%=rs.getString("semester")%>
 </div>
 
 <div class="form-group">
    <label for="firstname">Status:</label>
   <br>
   <%=rs.getString("status")%>
 </div>
 
 

  
  
  
  
   
  
  </div>
 <%} %>
</body>
</html>