
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--  <link rel="stylesheet" href="css/bootstrap.min.css"> -->
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:include page="coursesidebar.jsp"></jsp:include>
<%HttpSession s=request.getSession();
String s1=(String)s.getAttribute("netid");
/* PrintWriter pw = response.getWriter();
pw.println("<h1>"+s1+"</h1>"); */%>
<div class="col-md-4"></div>
<div class="col-md-4">
<form action="<%=request.getContextPath() %>/viewcourse">

<h2>My Courses</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
       <!--  <th>ID</th> -->
        <th>Course Number</th>
        <th>Course Name</th>
        <!-- <th>Faculty</th> -->
        <th>Action</th>
         <th>Action</th>
          <th>Action</th>
          <th>Action</th>
      </tr>
    </thead>


<%
String netid=(String)s.getAttribute("netid");
System.out.println("Netid is-------"+netid);
dbconn db=new dbconn();
String name=db.firstname(netid);
String sql3 = "select * from course where faculty='"+name+"'"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>
  <tr>
  <%-- <td><%=rs.getString("id")%></td> --%>
   <td><%=rs.getString("no")%></td>
    <td ><%=rs.getString("name") %></td>
    <%-- <td ><%=rs.getString("faculty") %></td> --%>
     <%HttpSession s2=request.getSession();
     s2.setAttribute("no", rs.getString(2));
     s2.setAttribute("name", rs.getString(3)); 
     %>
    <td><a href=addinfo.jsp?addid=<%=rs.getString("id") %>> Add Info </a></td>
    <td><a href=viewinfo.jsp?viewid=<%=rs.getString("id") %>> View Info </a></td>
    <td><a href=editinfo.jsp?editid=<%=rs.getString("id") %>> Edit Info </a></td>
    <td><a href=viewcourse?deleteid=<%=rs.getString("id") %>> Delete </a></td> 
    
    </tr>
 <%}%>


</table>
</form>

</body>
</html>