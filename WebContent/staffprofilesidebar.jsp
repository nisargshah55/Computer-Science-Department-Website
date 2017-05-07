<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
</head>
<body>

<jsp:include page="staffmenu.jsp" />
<section id="body" class="width clear">
			<aside id="sidebar">
				<ul>
                	<li>
						<h4>Profile</h4>
                        <ul class="blocklist">
                            
                            <li><a href="profile">Edit Profile</a></li>
                            <li><a href="viewstaffprofile.jsp">View Profile</a></li>
                            <li><a href="checkphdstaff">View Phd Status</a></li>
                        </ul>
                        </li>
                        </ul>
                        </aside>
                        </section>
${error}