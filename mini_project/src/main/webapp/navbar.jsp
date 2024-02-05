
<% String username = (String) session.getAttribute("username");
 boolean isLoggedIn = (username != null);
%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.js">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-white bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="about_us.jsp">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="contact.jsp">Contact</a>
        </li>
        
        <%
        if(isLoggedIn){ %>
        	
        	  <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="logout.jsp">Logout</a>
            </li>
        
         <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="logout.jsp">
              
              Welcome <%= session.getAttribute("username") %>
              </a>
            </li>
            <%}  else { %>
         <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="login.jsp">login</a>
            </li>
             <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="registration.jsp">Registration</a>
            </li>
        
        <% }%>
        
       
       
       
       
       
      
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>


</body>
</html>