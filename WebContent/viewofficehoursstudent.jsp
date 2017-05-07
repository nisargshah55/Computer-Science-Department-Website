
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
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> --> 
 <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:include page="coursesidebarstudent.jsp"></jsp:include>
<%HttpSession s=request.getSession();
String s1=(String)s.getAttribute("netid");
/* PrintWriter pw = response.getWriter();
pw.println("<h1>"+s1+"</h1>"); */%>
<div class="col-md-4"></div>
<form action="<%=request.getContextPath() %>/viewcourse">

<div class="col-md-4">

  <h2>Office Hours</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
       <!--  <th>ID</th> -->
        <th>Course Number</th>
        <th>Course Name</th>
        <th>Faculty</th>
        <th>TA</th>
        <th>Faculty Office Hours/Location</th>
        <th>TA Office Hours/Location</th>
        <!-- <th>Action</th> -->
      </tr>
    </thead>

<%
String netid=(String)s.getAttribute("netid");
System.out.println("Netid is-------"+netid);
dbconn db=new dbconn();
String sql3 = "select * from course"; 
ResultSet rs=db.execute(sql3);

while (rs.next()) {%>
  <tr>
  <%-- <td><%=rs.getString("id")%></td> --%>
   <td><%=rs.getString("no")%></td>
    <td ><%=rs.getString("name") %></td>
    <td ><%=rs.getString("faculty") %></td>
    <td ><%=rs.getString("ta") %></td>
    <td ><%=rs.getString("foh") %></td>
    
    <td ><%=rs.getString("toh") %></td>
     <%HttpSession s2=request.getSession();
     s2.setAttribute("no", rs.getString(2));
     s2.setAttribute("name", rs.getString(3)); 
     %>
    <%-- <td><a href=addfac?selectid=<%=rs.getString("id") %>> Add</a> </td> --%>
     
    
    </tr>
 <%}%>

</tbody>
  </table>
  ${checkfac }
  </div>
  </div>

</form>

</body>
</html>