<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="examsidebar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/datepicker.css">
</head>
<body>
 
<div class="col-md-4"></div>
<div class="col-md-4">
<div class="text-center">
<form action="<%=request.getContextPath()%>/createexam">
<%HttpSession s=request.getSession();
String netid=(String)s.getAttribute("netid");%>

<div class="form-group">
    <label for="firstname">Exam Name:</label>
    
    <input type="text" name="examname" placeholder="Enter exam name"  class="form-control" required="required">
  </div>

<div class="form-group">
<label for="sel1">Select Date:</label>
            <div class="hero-unit">
                <input  type="text" placeholder="click to show datepicker"  id="example1" name="date" required="required">
            </div>
        </div>
        <!-- Load jQuery and bootstrap datepicker scripts -->
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
                $('#example1').datepicker({
                    format: "dd/mm/yyyy"
                });  
            
            });
        </script>


<button type="submit" class="btn btn-primary btn-lg active" name="submit">Create</button>

${error_name }
</form>
</div>
</div>
<div class="col-md-4"></div>

</body>
</html>