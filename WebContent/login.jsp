<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>


    <!DOCTYPE html>

    <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
       <body>
<%-- <%HttpSession s=request.getSession();
 String user=(String) s.getAttribute("user");
 PrintWriter pw = response.getWriter();
pw.println("<h1>"+user+"</h1>");
 %> --%>
 
 <div class="col-md-4">
  <img src="img/logo_A1_pms124_269.png" class="img-responsive" alt="UALBANY" width="200" height="200"> 
  
 </div>
 
 <div id="container">
<div class="col-md-4">
      
<h3>Enter Login Details</h3>
<form action="<%=request.getContextPath()%>/login">
	 <div class="form-group">
    <label for="firstname">Net ID:</label>
    <input type="text" class="form-control" name="netid" placeholder="Enter your netid" required="required">
  </div>


 <div class="form-group">
    <label for="firstname">Password:</label>
   <input type="password" class="form-control" name="password" placeholder="Enter your password" required="required">
  </div>



<button type="submit" class="btn btn-primary btn-lg active" name="submit">Login</button>
<!-- <input type="submit" name="submit" value="Login"> -->
${error_name }

</form>
<br>

<h4>Click here to 
 <a href="register.jsp">Register</a></h4>
</div>
</div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

    </html>