<%@page import="model.NguoiDung639"%>
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
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 50px auto;
        }
        .container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .container button {
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
        NguoiDung639 nvbh = (NguoiDung639) session.getAttribute("nvbanhang");
        if(nvbh == null) {
            response.sendRedirect(request.getContextPath() + "/view/dangnhap/gdDangNhap639.jsp?err=timeout");
        }
    %>
    <div class="container">
        <h2>Trang chủ nhân viên bán hàng</h2>
        <form action="gdTimBanDat639.jsp" method="get">
            <button type="submit">Thanh toán</button>
        </form>
    </div>
</body>
</html>