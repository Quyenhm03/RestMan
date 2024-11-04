<%@page import="dao.MonAnDAO639"%>
<%@page import="model.MonAn639"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        .search-container {
            display: flex;
            align-items: center; 
            margin-bottom: 20px;
        }
        .search-container p {
            margin-right: 10px;
        }
        .search-container input[type=text] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 50%; 
            height: 30px;
        }
        .search-container button {
            background-color: #4CAF50;
            color: white;
            padding: 5px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 170px; 
            height: 40px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table th, table td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        table th {
            background-color: #f2f2f2;
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
        String tenMonAn = request.getParameter("tenMonAn");
        boolean isStart = true;
        List<MonAn639> list = null;

        if (tenMonAn != null && !tenMonAn.isEmpty()) {
            list = (new MonAnDAO639()).getDSMonAn(tenMonAn);
            isStart = false;
        }
    %>
    <div class="container">
        <h2>Tìm món ăn</h2>
        <div class="search-container">
            <form action="gdTimMonAn639.jsp" method="get" style="display: flex; width: 100%;">
                <p>Tên món ăn:</p>
                <input type="text" name="tenMonAn" placeholder="Nhập tên món ăn" value="<%= tenMonAn != null ? tenMonAn : "" %>">
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Tên món ăn</th>
                    <th>Đơn giá</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (list != null && !list.isEmpty()) {
                        int stt = 1;
                        for (MonAn639 monAn : list) {
                %>
                <tr>
                    <td><%= stt++ %></td>
                    <td><%= monAn.getId() %></td>
                    <td><%= monAn.getTen() %></td>
                    <td><%= monAn.getDonGia() %></td>
                    <td>
                        <a href="gdChiTietTTMonAn639.jsp?id=<%= monAn.getId() %>" class="btn-detail">Xem chi tiết</a>
                    </td>
                </tr>
                <%
                        }
                    } else if(!isStart){
                %>
                <tr>
                    <td colspan="5" style="text-align:center;">Không có món ăn nào được tìm thấy.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <div class="actions">
            <button onclick="window.history.back();">Quay lại</button>
        </div>
    </div>
</body>
</html>