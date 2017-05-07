<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="stexamsidebar.jsp"></jsp:include>
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
  <h2>Result</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Exam Name</th>
        <!-- <th>Student ID</th> -->
        <th>Result</th>
       
      </tr>
    </thead>
    
<%
HttpSession s=request.getSession();
String a=(String)s.getAttribute("netid");
System.out.println(a);

dbconn db=new dbconn();
String sql3 = "select * from result where studentid='"+a+"' "; 
ResultSet rs=db.execute(sql3);    
while (rs.next()) {%>
    <tbody>
      <tr>
        <td><%=rs.getString("regexam") %></td>
        <td><%=rs.getString("result")%> </td>
        
  <%}%>    </tr>
    </tbody>
  </table>
  </div>
  </div>



</body>
</html>