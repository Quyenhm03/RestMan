<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>RestMan</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 50px auto;
        }
        .login-container h2 {
            text-align: center;
        }
        .login-container input[type=text], .login-container input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .login-container button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
    </style>
</head>
<body>
    <%
        if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("timeout")){
            %> <h4>Hết phiên làm việc. Làm ơn đăng nhập lại!</h4><%
        }else if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("fail")){
            %> <h4 color="red">Sai tên đăng nhập/mật khẩu!</h4><%
        }
    %>
    <div class="login-container">
        <h2>Đăng Nhập</h2>
        <form name ="dangnhap" action="doDangNhap639.jsp" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập" required>

            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>

            <button type="submit">Đăng Nhập</button>
        </form>
    </div>
</body>
</html>