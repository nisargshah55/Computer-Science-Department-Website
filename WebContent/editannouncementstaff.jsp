 <jsp:include page="announcementsidebarstaff.jsp"></jsp:include>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	
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
		dbconn db=new dbconn();
		
		String fn=db.firstname(netid);
		HttpSession s1=request.getSession();
		s1.setAttribute("editid", editid);
		String sql3 = "select * from postannouncement where id='"+editid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
	
<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/editannstaff">
  <h3>Edit Announcement</h3>
   
   			
	
    
 <div class="form-group">
    <label for="firstname">Type:</label>
   <br>
    <input type="text" class="form-control" name="type"  placeholder="Edit type" value="<%=rs.getString("type") %>" required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Title:</label>
    <br>
    <input type="text" class="form-control" name="title" placeholder="Edit title" value="<%=rs.getString("title") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="lastname">Description:</label>
    <br>
    <input type="text" class="form-control" name="desc" placeholder="Edit description" value="<%=rs.getString("description") %>" required="required">
    
  </div>
  <%} %>
  <button type="submit" class="btn btn-primary btn-lg active" name="submit">Update</button>
  </form>
  </div>

</body>
</html>