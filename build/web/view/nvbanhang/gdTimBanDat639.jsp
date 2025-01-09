<%@page import="model.NVBanHang639"%>
<%@page import="model.NguoiDung639"%>
<%@page import="dao.BanDatDAO639"%>
<%@page import="model.BanDat639"%>
<%@page import="java.util.List"%>
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
        NVBanHang639 nvbh = (NVBanHang639) session.getAttribute("nvbanhang");
        if(nvbh == null) {
            response.sendRedirect(request.getContextPath() + "/view/dangnhap/gdDangNhap639.jsp?err=timeout");
        }
        
        String tenBanDat = request.getParameter("tenBanDat");
        boolean isStart = true;
        
        List<BanDat639> list = null;

        if (tenBanDat != null && !tenBanDat.isEmpty()) {
            list = (new BanDatDAO639()).getDSBanDat(tenBanDat);
            isStart = false;
        }
    %>
    <div class="container">
        <h2>Tìm bàn đặt</h2>
        <div class="search-container">
            <form action="gdTimBanDat639.jsp" method="get" style="display: flex; width: 100%;">
                <p>Tên bàn đặt:</p>
                <input type="text" name="tenBanDat" placeholder="Nhập tên bàn đặt" value="<%= tenBanDat != null ? tenBanDat : "" %>">
                <button type="submit">Tìm kiếm</button>
            </form>               
        </div>
        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>ID Bàn đặt</th>
                    <th>Tên bàn</th>
                    <th>Ngày đặt</th>
                    <th>Giờ bắt đầu</th>
                    <th>Giờ kết thúc</th>
                    <th> </th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (list != null && !list.isEmpty()) {
                        int stt = 1;
                        for (BanDat639 banDat : list) {
                %>
                <tr>
                    <td><%= stt++ %></td>
                    <td><%= banDat.getId() %></td>
                    <td><%= banDat.getBan().getTen() %></td>
                    <td><%= banDat.getNgayDat() %></td>
                    <td><%= banDat.getGioBatDau() %></td>
                    <td><%= banDat.getGioKetThuc() %></td>
                    <td>
                        <a href="gdHDThanhToan639.jsp?id=<%= banDat.getId() %>" class="btn-detail">Thanh toán</a>
                    </td>
                </tr>
                <%
                        }
                    } else if(!isStart){
                %>
                <tr>
                    <td colspan="5" style="text-align:center;">Không có bàn đặt nào được tìm thấy.</td>
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