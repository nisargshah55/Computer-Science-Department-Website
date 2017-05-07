<jsp:include page="discussionboardsidebarstudent.jsp"></jsp:include>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="col-md-4">
<%-- <%
HttpSession session1 = request.getSession();
String hashtag = (String) session1.getAttribute("topic");
PrintWriter pw = response.getWriter();
%><h1><%=hashtag %></h1>  --%>
</div>


<div class="col-md-4">
  <%
HttpSession session1 = request.getSession();
String hashtag = (String) session1.getAttribute("topic");
PrintWriter pw = response.getWriter();
%><h1><%=hashtag %></h1>  


<form action="viewforumstudent">
<div class="form-group">



    <label for="firstname">Enter your query:</label>
    
    <textarea rows="2" cols="50" name="view" name="topic" placeholder="Enter your query"  class="form-control" required="required">
</textarea> 
  </div>
  
 

  
<input type="hidden" value=0 name="pid">
<button type="submit" class="btn btn-primary btn-lg active" name="submit">Submit</button>
<!-- <input type="submit" value="Submit"> -->
${error_specialcharacter}
</form>
<h2>
${viewallpost}

<br></h2>    
${replypost}
</div>
</div>
</body>
</html>