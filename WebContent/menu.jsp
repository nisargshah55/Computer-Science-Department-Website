<%@page import="DAO.dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<title>Menu</title>
</head>
<body>
<%HttpSession s=request.getSession();
String netid=(String)s.getAttribute("netid");
System.out.println("Netid is "+netid);
dbconn db=new dbconn();
String fn=(String)db.firstname(netid);
System.out.println("Firstname is "+fn);%>

				
<div id="sitename">
			<div class="width">
				<!-- <h1><a href="#"> afflatus </a></h1> -->

				<nav>
					<ul>
					<!-- <li class=""><a href="facultyhome.jsp">Home</a></li> -->
        					<li class=""><a href="coursesidebar.jsp">Course</a></li>
        	    				<li class=""><a href="resourcesidebar.jsp">Resource</a></li>
         	   				<li><a href="discussionboardsidebar.jsp">Discussion Board</a></li>
         	   				<li><a href="announcementsidebar.jsp">Announcement</a></li>
          	  				<li><a href="examsidebar.jsp">Exam</a></li>
          	 				<li class="end"><a href="alumnisidebar.jsp">Alumni</a></li>
          	 				<!-- <li class="end"><a href="phdstatussidebar.jsp">Phd</a></li> -->
          	 				<li><a href="profilesidebar.jsp">Profile</a></li>
          	 				<li><a href="logout">Logout</a></li>
        				</ul>
				</nav>

				<div class="clear"></div>
			</div>
			
		</div>
<div align="left" ><strong><%out.println("Welcome "+fn); %></strong></div>
  <jsp:include page="footer.jsp"></jsp:include>  
</body>
</html>