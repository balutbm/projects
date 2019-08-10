<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
        String fcountry,scountry;
        int amount;
        fcountry=request.getParameter("firstcountry");
        scountry=request.getParameter("secondcountry");
        amount=Integer.parseInt(request.getParameter("amount"));
        
    %>
    </body>
</html>
