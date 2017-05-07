
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="coursesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/viewcourse">

<table border="2">
<tr>
<td>ID</td>
<td>Course Number</td>
<td>Course Name</td>
<td>Professor</td>

</tr>
<%dbconn db=new dbconn();
String sql3 = "select * from addfac"; 
ResultSet rs=db.execute(sql3);
HttpSession session2=request.getSession();
while (rs.next()) {%>
  <tr>
  <td><%=rs.getString("id")%></td>
   <td><%=rs.getString("no")%></td>
    <td ><%=rs.getString("name") %></td>
   <td><%=rs.getString("faculty") %>
    
    <!-- <td><form action="remove"><button type="button" >Remove </button></form>  </td> -->
    </tr>
 <%}%>


</table>
</form>

</body>
</html>