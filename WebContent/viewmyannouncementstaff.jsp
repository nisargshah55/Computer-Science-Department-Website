
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="announcementsidebarstaff.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%HttpSession s=request.getSession();
String s1=(String)s.getAttribute("netid");
dbconn db=new dbconn();
String fn=db.firstname(s1);
%>
<div class="col-md-4">
</div>
 

<div class="col-md-4">
  <h2>My Announcements</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Type</th>
        <th>Title </th>
        <th>Description</th>
        <th>Action</th>
        <th>Action</th>
      </tr>
    </thead>
    
<%dbconn db1=new dbconn();
String sql3 = "select * from postannouncement where faculty='"+fn+"'"; 
System.out.println("first name is----"+fn);
ResultSet rs=db1.execute(sql3);    
while (rs.next()) {%>
    <tbody>
      <tr>
        <td><%=rs.getString("type") %></td>
        
        <td><%=rs.getString("title")%> </td>
        <td><%=rs.getString("description")%> </td>
        <td><a href="editannouncementstaff.jsp?editid=<%=rs.getString("id") %>"> Edit </a></td>
       <td><a href=deleteannstaff?deleteid=<%=rs.getString("id") %>> Delete </a></td>
  <%}%>    </tr>
    </tbody>
  </table>
  </div>
  </div>


</body>
</html>