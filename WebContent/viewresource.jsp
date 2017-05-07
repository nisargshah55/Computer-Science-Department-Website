<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="resourcesidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="col-md-4">
</div>
<div class="col-md-4">
  <h2>Topics</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Resource Name</th>
        <th>Date</th>
        <th>Time</th>
        <th>Action</th>
      </tr>
    </thead>

<!-- <table border="2">
<tr>

<td>Resource Name</td>
<td>Date</td>
<td>Time</td>
<td>Action</td>
</tr> -->
<%dbconn db=new dbconn();
HttpSession s=request.getSession();
String netid=(String)s.getAttribute("netid");
System.out.println("NetID is===="+netid);
String sql3 = "select * from reserveresource where netid='"+netid+"'"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>

<tbody>
      <tr>
        <td><%= rs.getString("name")%></td>
        <td><%= rs.getString("date")%></td>
    	<td><%= rs.getString("time")%></td>
        <td><a href=deleteresource?deleteid=<%=rs.getString("id") %>> Delete </a></td>
  <%}%>    </tr>
    </tbody>
  </table>
  </div>
  </div>




  <%-- <tr>
  <%HttpSession s2=request.getSession();
  s2.setAttribute("topic", rs.getString(2));
  %>
   <td><a href=viewtopics?selectid=<%=rs.getString("id") %>	><%=rs.getString("topic") %></a></td>
    <td><a href=deletetopic?deleteid=<%=rs.getString("id") %>> Delete </a></td>
    <td><%= rs.getString("name")%></td>
    <td><%= rs.getString("date")%></td>
    <td><%= rs.getString("time")%></td>
    <td><a href=deleteresource?deleteid=<%=rs.getString("id") %>> Delete </a></td>
<%}%></tr>
</table> --%>
</body>
</html>