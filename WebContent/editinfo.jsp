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
		String sql3 = "select * from course where id='"+editid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
		
	
<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/editinfo">
   
   
   <div class="form-group">
    <label for="firstname">Edit TA:</label>
   <br>
    <input type="text" class="form-control" name="ta"  placeholder="Edit TA" value="<%=rs.getString("ta")%>" required="required">
 </div>
 
     
 <div class="form-group">
    <label for="firstname">Edit faculty office hours and location:</label>
   <br>
    <input type="text" class="form-control" name="foh"  placeholder="Edit Faculty Office Hours" value="<%=rs.getString("foh")%>" required="required">
 </div>
 
 <div class="form-group">
    <label for="firstname">Edit TA office hours and location:</label>
   <br>
    <input type="text" class="form-control" name="toh"  placeholder="Edit TA Office Hours" value="<%=rs.getString("toh")%>" required="required">
 </div>
 
 <div class="form-group">
    <label for="firstname">Edit course syllabus:</label>
   <br>
    <input type="text" class="form-control" name="info"  placeholder="Edit Course Syllabus" value="<%=rs.getString("info")%>" required="required">
 </div>
 
 <%} %>
  
  
  
  <button type="submit" class="btn btn-primary btn-lg active" name="submit" onclick="myFunction()">Update</button>
  
  <script>
function myFunction() {
    alert("Thanks your info has been edited!");
}
</script>
   
  </form>
  </div>

</body>
</html>