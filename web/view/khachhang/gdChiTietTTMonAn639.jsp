<%@page import="dao.MonAnDAO639"%>
<%@page import="model.MonAn639"%>
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
            max-width: 800px;
            margin: 50px auto;
        }
        .container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .details {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-left: 20px; /* Khoảng cách lề trái */
        }
        .image-container {
            flex: 0 0 auto;
            max-width: 50%;
        }
        .image-container img {
            max-width: 100%;
            height: auto;
        }
        .description {
            flex: 1 1 auto;
            margin-left: 20px; /* Khoảng cách giữa ảnh và mô tả */
        }
        .description p {
            margin: 0;
        }
        .actions {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .actions button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%
        String idMonAn = request.getParameter("id");
        MonAn639 monAn = (new MonAnDAO639()).getMonAn(Integer.parseInt(idMonAn));
    %>
    <div class="container">
        <h2>Chi tiết thông tin món ăn</h2>
        <div class="details">
            <div class="image-container">
                <img src="<%= request.getContextPath() %><%= monAn.getAnh() %>" alt="Ảnh món ăn">
            </div>
            <div class="description">
                <p>ID món ăn: <%= monAn.getId() %></p>
                <br/>
                <p>Tên món ăn: <%= monAn.getTen() %></p>
                <br/>
                <p>Đơn giá: <%= monAn.getDonGia() %></p>
                <br/>
                <p>Mô tả: <%= monAn.getMoTa() %></p>
            </div>
        </div>
        <div class="actions">
            <button onclick="window.history.back();">Quay lại</button>
        </div>
    </div>
</body>
</html>