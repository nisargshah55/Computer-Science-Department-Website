<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="alumnisidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

<div class="col-md-4">
</div>

<div class="col-md-4">
  <h2>Alumni Info</h2>
                                                                                        
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Year</th>
        <th>Member</th>
        <th>Link</th>
         <th>Action</th>
          <th>Action</th>
      </tr>
    </thead>
    
<%dbconn db=new dbconn();
String sql3 = "select * from alumni"; 
ResultSet rs=db.execute(sql3);    
while (rs.next()) {%>
    <tbody>
      <tr>
      <td><%=rs.getString("name") %></td>
      <td><%=rs.getString("year") %></td>
      <td><%=rs.getString("member") %></td>
      <td><a href=<%=rs.getString("link") %>><%=rs.getString("link") %></a></td>
        
        <td><a href="editalumni.jsp?editid=<%=rs.getString("id") %>">Edit</a></td>
        <td><a href=deletealumni?deleteid=<%=rs.getString("id") %>> Delete </a></td>
  <%}%>    </tr>
    </tbody>
  </table>
  </div>
  </div>




</body>
</html>