<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="coursesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%
   
   		HttpSession s=request.getSession();
   		String addid=request.getParameter("addid");
   		System.out.println("adddddid isss========="+addid);
		String netid=(String)s.getAttribute("netid");
		dbconn db=new dbconn();
		
		String fn=db.firstname(netid);
		HttpSession s1=request.getSession();
	
		s1.setAttribute("addid",addid);
		%>
	
<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/addinfo">
     
     <div class="form-group">
    <label for="firstname">TA:</label>
   <br>
    <input type="text" class="form-control" name="ta"  placeholder="Add Faculty Office Hours" required="required">
 </div>
 
     
     
 <div class="form-group">
    <label for="firstname">Faculty Office Hours and Location:</label>
   <br>
    <input type="text" class="form-control" name="foh"  placeholder="Add Faculty Office Hours" required="required">
 </div>
 
  <div class="form-group">
    <label for="firstname">TA Office Hours and Location:</label>
   <br>
    <input type="text" class="form-control" name="toh"  placeholder="Add TA Office Hours" required="required">
 </div>
 
 <div class="form-group">
    <label for="firstname">Course Syllabus:</label>
   <br>
    <input type="text" class="form-control" name="info"  placeholder="Add Office Hours and Course Syllabus" required="required">
 </div>
  
  
  <button type="submit" class="btn btn-primary btn-lg active" name="submit" onclick="myFunction()">Add</button>
  
  <script>
function myFunction() {
    alert("Thanks your info has been posted!");
}
</script>
   
  </form>
  </div>

</body>
</html>