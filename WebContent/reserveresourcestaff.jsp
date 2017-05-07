<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
    
    <jsp:include page="staffresourcesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/datepicker.css">
  <!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script>
$(function() {
    $( "#datepicker" ).datepicker();
  });

</script>


</head>
<body>
<div class="col-md-4">
</div>
<div id="container">
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/reserveresourcestaff">
<%HttpSession s=request.getSession();
String a=(String)s.getAttribute("netid");
System.out.println("Resereve Resource:------"+a);
%>


<div class="form-group">
  <label for="sel1">Select Resource:</label>

<select class="form-control" name="resource" >
<option value="">Select...</option>


 <%dbconn db=new dbconn();
String sql3 = "select name from resource"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>

<%-- <p:forEach items="${sessionScope.resourcelist }" var="i" >
<option value="${i.select }">${i.select}</option>

</p:forEach> --%>
<option value="<%=rs.getString("name")%>"><%=rs.getString("name")%></option>
<%}%>
</select>
</div>

<div class="form-group">
<label for="sel1">Select Date:</label>
            <div class="hero-unit">
                <input  type="text" placeholder="click to show datepicker"  id="example1" name="date" required="required">
            </div>
        </div>
        
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
           
            $(document).ready(function () {
                
                $('#example1').datepicker({
                    format: "dd/mm/yyyy"
                });  
            
            });
        </script>

<!-- Select Date:
<input type="text" id="datepicker" name="date">
<br>
<br> -->


<div class="form-group">
  <label for="sel1">Select Schedule:</label>

<select class="form-control" name="schedule" >
<option value="">Select...</option>

<%dbconn db1=new dbconn();
String sql = "select time from schedule"; 
ResultSet rs1=db1.execute(sql);

while (rs1.next()) {%>

<option value="<%=rs1.getString("time")%>"><%=rs1.getString("time")%></option>
<%}%>
</select>

</div>

<button type="submit" class="btn btn-primary btn-lg active" name="submit">Reserve</button>
<!-- <input type="submit" value="Reserve"> -->

${error_name }
</form>
</div>
</div>
</body>
</html>