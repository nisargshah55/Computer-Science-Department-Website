<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</script>
</head>
<body>
<div class="col-md-4">
 <img src="img/logo_A1_pms124_269.png" class="img-responsive" alt="UALBANY" width="200" height="200"> 
 </div>
<div id="container">
<div class="col-md-4">
  <h3>Enter Registration Details</h3>
  <form action="<%=request.getContextPath()%>/register">
    <div class="form-group">
    <label for="firstname">First Name:</label>
    <input type="text" class="form-control" name="firstname"  placeholder="Enter your first name " required="required">
  </div>
 
  <div class="form-group">
    <label for="lastname">Last Name:</label>
    <input type="text" class="form-control" name="lastname" placeholder="Enter your last name" required="required">
  </div>
  
  <div class="form-group">
    <label for="netid">Net ID:</label>
    <input type="text" class="form-control" name="netid" placeholder="Enter your netid" required="required">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" name="password" placeholder="Enter your password" required="required">
  </div>
  <br>
  <div class="form-group">
    <label for="role">Role:</label>
    <br>
   <label class="radio-inline"> <input type="radio" name="role" placeholder="Enter your role" value="Faculty" onclick="javascript:yesnoCheck();" name="yesno" id="noCheck">Faculty</label>
    <label class="radio-inline"><input type="radio" name="role" placeholder="Enter your role" value="Staff" onclick="javascript:yesnoCheck();" name="yesno" id="noCheck">Staff</label>
	<label class="radio-inline"><input type="radio" name="role" placeholder="Enter your role" value="Student"  onclick="javascript:yesnoCheck();" name="yesno" id="yesCheck">Student</label>

  </div>
  
  
  <div id="ifYes" style="display:none">
  <div class="form-group" >
  <label for="year">Year joined the program:</label>
  <br>
    <input type='text' id='yes' name='year' class="form-control" >
    </div>
     
    <div class="form-group">
  <label for="sel1">Program:</label>
  <select class="form-control" name="program">
    
    <option value="select">Select</option>
    <%dbconn db=new dbconn();
    String sql="select program from program";
    ResultSet rs=db.execute(sql);
    while(rs.next()){%>
    <option value="<%=rs.getString("program") %>"><%=rs.getString("program") %></option>
    <%}%>
       </select>
      </div>
       <div class="form-group">
    <label for="major">Major:</label>
    <input type="text" class="form-control" name="major" placeholder="Enter your major" >
  </div>
  
</div>

<button type="submit" class="btn btn-primary btn-lg active" name="submit">Register</button>

  </form>
  
  <br>
 
  <h4>Click here to
 <a href="login.jsp">Login</a></h4>
  </div>
  </div>
  




${error_name }

</body>
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</html>