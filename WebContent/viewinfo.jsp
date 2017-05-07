<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="menu.jsp"></jsp:include>
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
		dbconn db=new dbconn();
		
		String fn=db.firstname(netid);
		HttpSession s1=request.getSession();
		s1.setAttribute("editid", viewid);
		s1.setAttribute("firstname", fn);
		String sql3 = "select * from course where id='"+viewid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
		
	
<div class="col-md-4">
</div>
<div class="col-md-4">
     
 <div class="form-group">
    <label for="firstname">Course Number:</label>
   <br>
    <%=rs.getString("no")%>
 </div>
 
 <div class="form-group">
    <label for="firstname">Course Name:</label>
   <br>
    <%=rs.getString("name")%>
 </div>
 
  
     
 <div class="form-group">
    <label for="firstname">TA:</label>
   <br>
    <%=rs.getString("ta")%>
 </div>
 
 <div class="form-group">
    <label for="firstname">Faculty Office Hours and Location:</label>
   <br>
    <%=rs.getString("foh")%>
 </div>
 
 <div class="form-group">
    <label for="firstname">TA Office Hours and Location:</label>
   <br>
    <%=rs.getString("toh")%>
 </div>
 
 <div class="form-group">
    <label for="firstname">Course Syllabus:</label>
   <br>
    <%=rs.getString("info")%>
 </div>
 <%} %>
  
  
  
  
   
  
  </div>

</body>
</html>