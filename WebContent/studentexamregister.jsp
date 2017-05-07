<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="stexamsidebar.jsp"></jsp:include>

    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script type="text/javascript">
function myFunction() {
    document.getElementById("mySelect").disabled = true;
}

function myFunction1() {
    document.getElementById("mySelect").disabled = false;
}
</script>
</head>
<body>
<div class="col-md-4">
</div>
<div id="container">
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/studentexamregister">
<%HttpSession s=request.getSession();
String a=(String)s.getAttribute("netid");
System.out.println("Exam register:------"+a);
%>


<div class="form-group">
  <label for="sel1" >Select Exam:</label>

<select class="form-control" name="regexam"  >
<option value="select" onclick="myFunction()">Select...</option>


 <%dbconn db=new dbconn();
String sql3 = "select * from exam"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>
<option value="<%=rs.getString("exam")%>" onclick="myFunction1()"><%=rs.getString("exam")%></option>
<%}%>
</select>
</div>



<div id="yes">
<button type="submit" class="btn btn-primary btn-lg active" name="submit" disabled id="mySelect">Register</button>
</div>


${error}
${msg }
</form>
</div>
</div>
</body>
</html>