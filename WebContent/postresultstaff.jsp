<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="examsidebarstaff.jsp"></jsp:include>  

    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script type="text/javascript">

</script>
</head>
<body>
<div class="col-md-4">
</div>
<div id="container">
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/postresultstaff">
<%HttpSession s=request.getSession();
String a=(String)s.getAttribute("netid");
s.setAttribute("netid", a);
%>


<div class="form-group">
  <label for="sel1" >Select Exam:</label>

<select class="form-control" name="regexam">
<option value="select" >Select...</option>


 <%dbconn db=new dbconn();
String sql3 = "select * from exam"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>
<option value="<%=rs.getString("exam")%>" ><%=rs.getString("exam")%></option>
<%}%>
</select>
</div>

<div class="form-group">
    <label for="firstname">Student ID:</label>
    
    <input type="text" name="studentid" placeholder="Enter student id"  class="form-control" required="required">
  </div>

<div class="form-group">
    <label for="firstname">Result:</label>
    <input type="text" name="result" placeholder="Enter result" class="form-control" required="required">
    
  </div>



<button type="submit" class="btn btn-primary btn-lg active" name="submit" >Register</button>
${error_name }
</form>
</div>
</div>
</body>
</html>