<%@page import="kr.co.saramin.emaillist.vo.EmailListVo"%>
<%@page import="kr.co.saramin.emaillist.dao.EmailListDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    request.setCharacterEncoding("utf-8");
    String firstName = request.getParameter("fn");
    String lastName = request.getParameter("ln");
    String email = request.getParameter("email");
    
    EmailListVo vo = new EmailListVo();
    vo.setFirstName(firstName);
    vo.setLastName(lastName);
    vo.setEmail(email);
    
    EmailListDao dao = new EmailListDao();
    dao.insert(vo);
    
    response.sendRedirect("/emaillist/list.jsp");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>