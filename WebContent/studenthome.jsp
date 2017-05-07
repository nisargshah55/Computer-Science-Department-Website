<%@page import="DAO.dbconn"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HttpSession s=request.getSession();
String a=(String)s.getAttribute("netid");
dbconn db=new dbconn();
String b="select firstname from login where netid='"+a+"'";
db.execute(b);
System.out.println(a);
%>
<jsp:include page="stmenu.jsp"></jsp:include>

</body>
</html>
 
