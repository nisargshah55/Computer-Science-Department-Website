
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <jsp:include page="coursesidebarstudent.jsp"></jsp:include> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/styles.css" type="text/css" /> -->

</head>
<body>

<div class="col-md-4">
</div>


 
<div id="container">
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/viewcourseconcentration.jsp">
<%HttpSession s=request.getSession();
String s1=(String)s.getAttribute("netid");
dbconn db=new dbconn();
String fn=db.firstname(s1);
%>
  <h2>Concentration</h2>
       
<div class="form-group">
  <label for="sel1">Select Program:</label>                 
                 
<select class="form-control" name="concentration" >
<option value="">Select...</option>


 <%dbconn db1=new dbconn();
String sql3 = "select distinct concentration from concentration"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>

<%-- <p:forEach items="${sessionScope.resourcelist }" var="i" >
<option value="${i.select }">${i.select}</option>

</p:forEach> --%>
<option value="<%=rs.getString("concentration")%>"><%=rs.getString("concentration")%></option>
<%}%>
</select>
                 
                
    <button type="submit" class="btn btn-primary btn-lg active" name="submit">Submit</button>
    </div>                                                                                    
</form>  
  </div>
</div>

</body>
</html>