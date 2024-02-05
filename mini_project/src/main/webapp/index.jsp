<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.sql.*"%>
<%@page import="java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  header  -->
 
 <%@ include file ="navbar.jsp" %>
 

<div class="container mt-3">
          
  <table class="table table-dark">
    <thead>
      <tr>
        <th>ID</th>
        <th>name</th>
        <th>Demo Password</th>
        <th>Action</th>
        <th>Action</th>
        
      </tr>
    </thead>
    <tbody>
    <%
										try {
											Class.forName("com.mysql.cj.jdbc.Driver");

											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do_list", "root", "");

											String sql = "SELECT * FROM `today_work` WHERE 1  ";

											PreparedStatement pwst = conn.prepareStatement(sql);

											ResultSet rs = pwst.executeQuery(sql);

											/*	PrintWriter out = response.getWriter(); */

											while (rs.next()) {
										%>
    
      <tr>
        <td>                                   <%
												out.println(rs.getString("id"));
												%></td>
        <td><%
												out.println(rs.getString("name"));
												%></td>
        <td><%
												out.println(rs.getString("password"));
												%></td>
												
												<td><a href="update_record.jsp?u=<%=rs.getString("id") %>" >Edit</a></td>
												
												
												<td>
											
													<form action="delete?d=<%=rs.getString("id")%>  "
													method="post">
													<input type="submit" name="delete" value="Delete"
														id="delete?u=<%=rs.getString("id")%>">
														
														</form>
														
											
											</td>
														
												
										
												
												
												
      </tr>
      
     	<%
										}
										} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										}
										%>
    </tbody>
  </table>
  <br><br>
  <br>
  <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<br>
		<br>
		<br>
		
</div>


<!-- footer -->
<%@ include file = "footer.jsp" %>>
</body>
</html>