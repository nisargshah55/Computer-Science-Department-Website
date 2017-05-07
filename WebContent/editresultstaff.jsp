 <jsp:include page="examsidebar.jsp"></jsp:include>
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

<div class="col-md-4">
</div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/editresultstaff">

  <h3>Edit Result</h3>
   
   			
<div class="form-group">
  <label for="sel1" >Select Exam:</label>

<select class="form-control" name="regexam">
<option value="select" >Select...</option>


 <%dbconn db1=new dbconn();
String sql4 = "select * from exam"; 
ResultSet rs1=db1.execute(sql4);

while (rs1.next()) {%>
<option value="<%=rs1.getString("exam")%>" ><%=rs1.getString("exam")%></option>
<%}%>
</select>
</div>
 
 <%String editid=request.getParameter("editid");
   
   		HttpSession s=request.getSession();
		String netid=(String)s.getAttribute("netid");
		dbconn db=new dbconn();
		
		String fn=db.firstname(netid);
		HttpSession s1=request.getSession();
		s1.setAttribute("editid", editid);
		String sql3 = "select * from result where id='"+editid+"'"; 
		System.out.println("first name is----"+fn);
		ResultSet rs=db.execute(sql3);    
		while (rs.next()) {%>
	
    
 <div class="form-group">
    <label for="firstname">Student ID:</label>
   <br>
    <input type="text" class="form-control" name="sid"  placeholder="Edit student id" value="<%=rs.getString("studentid") %>" required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Result:</label>
    <br>
    <input type="text" class="form-control" name="result" placeholder="Edit result" value="<%=rs.getString("result") %>" required="required">
  </div>
  
  
  <%} %>
  <button type="submit" class="btn btn-primary btn-lg active" name="submit">Update</button>
  </form>
  </div>

</body>
</html>