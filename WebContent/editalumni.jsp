<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="alumnisidebar.jsp"></jsp:include>
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
		String sql3 = "select * from alumni where id='"+editid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
	
<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/editalumni">
  <h3>Edit Alumni</h3>
   
   			
	
    
 <div class="form-group">
    <label for="firstname">Name:</label>
   <br>
    <input type="text" class="form-control" name="name"  placeholder="Edit name" value="<%=rs.getString("name") %>" required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Year:</label>
    <br>
    <input type="text" class="form-control" name="year" placeholder="Edit year" value="<%=rs.getString("year") %>" required="required">
  </div>
  
  <div class="form-group">
    <label for="lastname">Members:</label>
    <br>
    <input type="text" class="form-control" name="member" placeholder="Edit members" value="<%=rs.getString("member") %>" required="required">
    
  </div>
  
  <div class="form-group">
    <label for="lastname">Link:</label>
    <br>
    <input type="text" class="form-control" name="link" placeholder="Edit link" value="<%=rs.getString("link") %>" required="required">
    
  </div>
  
  <%} %>
  <button type="submit" class="btn btn-primary btn-lg active" name="submit">Update</button>
  </form>
  </div>

</body>
</html>