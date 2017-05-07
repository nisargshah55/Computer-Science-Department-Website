<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
    <jsp:include page="announcementsidebarstaff.jsp"></jsp:include>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript">

function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifYes').style.display = 'block';
    } else {
        document.getElementById('ifYes').style.display = 'none';
    }
}


function Check() {
    if (document.getElementById('Check').checked) {
        document.getElementById('Yes').style.display = 'block';
    } else {
        document.getElementById('Yes').style.display = 'none';
    }
}

</script>


</head>
<body> 

<div class="col-md-4">
</div>
 
 
<div class="col-md-4">

<form action="<%=request.getContextPath() %>/postannouncementstaff">
<%HttpSession s=request.getSession();
String a=(String)s.getAttribute("netid");
System.out.println("Post Announcement:------"+a);
%>

<div class="form-group">
    <label for="firstname">Announcement Type:</label>
    
    
   <label class="radio-inline"> <input type="radio" name="type" placeholder="Enter your role" value="job" onclick="javascript:yesnoCheck();" name="yesno" id="yesCheck">Job</label>
   
    <label class="radio-inline"><input type="radio" name="type" placeholder="Enter your role" value="event"  onclick="javascript:yesnoCheck();" name="yesno" id="noCheck">Event</label>
	<label class="radio-inline"><input type="radio" name="type" placeholder="Enter your role" value="news"  onclick="javascript:yesnoCheck();" name="yesno" id="noCheck">News</label>
  
</div>


<div id="ifYes" style="display:none">
  <div class="form-group" >
  
  On/Off Campus:
  <input type="text" name="on" placeholder="On/Off Campus"  class="form-control" >
  <br>
    
    E-mail/Link:
    <input type="text" name="email" placeholder="Enter e-mail or link"  class="form-control" >
  
  
    </div>
    
        
    

</div>
<div class="form-group">
    <label for="firstname">Announcement Title:</label>
    
    <input type="text" name="title" placeholder="Enter announcement title"  class="form-control" required="required">
  </div>

<div class="form-group">
    <label for="firstname">Announcement Description:</label>
    
    <textarea rows="2" cols="50" name="description" placeholder="Enter announcement description"  class="form-control" required="required"></textarea>
  </div>
<button type="submit" class="btn btn-primary btn-lg active" name="submit">Post</button>

</form>
</div>

</body>
</html>