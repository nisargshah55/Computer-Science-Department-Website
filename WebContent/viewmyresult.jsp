<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="examsidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
  <h2>Result</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Exam Name</th>
        <th>Student ID</th>
        <th>Result</th>
        <th>Action</th>
        <th>Action</th>
      </tr>
    </thead>
    
<%dbconn db1=new dbconn();
String sql3 = "select * from result"; 
ResultSet rs=db1.execute(sql3);    
while (rs.next()) {%>
    <tbody>
      <tr>
        <td><%=rs.getString("regexam") %></td>
        
        <td><%=rs.getString("studentid")%> </td>
        
        <td><%=rs.getString("result")%> </td>
        <td><a href=editresult.jsp?editid=<%=rs.getString("id") %>> Edit </a> </td>
        <td><a href=deleteresult?deleteid=<%=rs.getString("id") %>> Delete </a> </td>
  <%}%>    </tr>
    </tbody>
  </table>
  </div>
  </div>



</body>
</html>