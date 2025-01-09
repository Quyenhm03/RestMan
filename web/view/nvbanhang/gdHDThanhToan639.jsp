<%@page import="java.util.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
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
            margin-bottom: 10px;
        }
        .date {
            text-align: center;
            margin-bottom: 20px;
            font-size: 16px;
            color: #555;
        }
        .details {
            display: flex; 
            justify-content: space-between; 
            margin-bottom: 20px; 
        }
        .details p {
            margin: 10px 0; 
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
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
            justify-content: space-between;
            margin-top: 20px;
            margin-left: 150px;
            margin-right: 150px
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

//        NguoiDung639 tmp = (new NguoiDungDAO639()).getNguoiDung(nd.getId());
//        NVBanHang639 nvbh = new NVBanHang639(nd.getId(), nd.getHoTen());
        String idBanDat = request.getParameter("id");
        
        List<MonAnDat639> listMonAnDat = null;
        MonAnDatDAO639 monAnDatDAO = new MonAnDatDAO639();
        listMonAnDat = monAnDatDAO.getDSMonAnDat(Integer.parseInt(idBanDat));
        
        List<ComboDat639> listComboDat = null;
        ComboDatDAO639 comboDatDAO = new ComboDatDAO639();
        listComboDat = comboDatDAO.getDSComboDat(Integer.parseInt(idBanDat));

        BanDat639 banDat = (new BanDatDAO639()).getBanDat(Integer.parseInt(idBanDat));  

        HDThanhToan639 hoaDon = (new HDThanhToanDAO639()).taoHDThanhToan(monAnDatDAO.getTongTien() + comboDatDAO.getTongTien(), nvbh, banDat);
        Date ngayTao = hoaDon.getNgayTao();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Ngày' dd 'tháng' MM 'năm' yyyy");
        LocalDate localDate = LocalDate.parse(new java.text.SimpleDateFormat("yyyy-MM-dd").format(ngayTao));
        String formattedDate = localDate.format(formatter);
        
        session.setAttribute("hoaDon", hoaDon);
    %>
    <div class="container">
        <h2>Hóa đơn thanh toán</h2>
        <p class="date"><%= formattedDate %></p>
        <div class="details">
            <div>
                <h3>Thông tin bàn đặt</h3>
                <p>ID bàn đặt: <%= banDat.getId() %></p>
                <p>Tên bàn: <%= banDat.getBan().getTen() %></p>
                <p>Ngày đặt: <%= banDat.getNgayDat() %></p>
                <p>Giờ bắt đầu: <%= banDat.getGioBatDau() %></p>
                <p>Giờ kết thúc: <%= banDat.getGioKetThuc() %></p>
            </div>
            <div>
                <h3>Thông tin nhân viên</h3>
                <p>ID nhân viên: <%= nvbh.getId() %></p>
                <p>Tên nhân viên: <%= nvbh.getHoTen() %></p>
            </div>
            <div>
                <h3>Thông tin khách hàng</h3>
                <p>ID khách hàng: <%= banDat.getKhachHang().getId() %></p>
                <p>Tên khách hàng: <%= banDat.getKhachHang().getHoTen() %></p>
                <p>Số điện thoại: <%= banDat.getKhachHang().getSdt() %></p>
            </div>
        </div>
        <table>
            <thead>
                <tr>
                    <th>STT</th>
                    <th>ID món ăn</th>
                    <th>Tên món ăn</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (listMonAnDat != null || listComboDat != null) {
                        int stt = 1;
                        if(!listMonAnDat.isEmpty()){
                            for (MonAnDat639 monAnDat : listMonAnDat) {
                %>
                            <tr>
                                <td><%= stt++ %></td>
                                <td><%= monAnDat.getId() %></td>
                                <td><%= monAnDat.getMonAn().getTen() %></td>
                                <td><%= monAnDat.getMonAn().getDonGia() %></td>
                                <td><%= monAnDat.getSoLuong() %></td>
                                <td><%= monAnDat.getThanhTien() %></td>
                            </tr>
                <%
                            }
                        }
                        if(!listComboDat.isEmpty()){
                            for (ComboDat639 comboDat : listComboDat) {
                %>
                             <tr>
                                <td><%= stt++ %></td>
                                <td><%= comboDat.getId() %></td>
                                <td><%= comboDat.getCombo().getTen() %></td>
                                <td><%= comboDat.getCombo().getDonGia() %></td>
                                <td><%= comboDat.getSoLuong() %></td>
                                <td><%= comboDat.getThanhTien() %></td>
                            </tr>
                <%
                            }
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6" style="text-align:center;">Không món ăn nào được đặt.</td>
                </tr>
                <%
                    }
                %>    
                <tr>
                    <td>Tổng tiền</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><%= hoaDon.getTongTien() %></td>
                </tr>
            </tbody>           
        </table>
        <div class="actions">
            <form name ="luuHDThanhToan" action="doLuuHDThanhToan639.jsp" method="post">
                <button>Xác nhận</button>              
            </form>          
            <button onclick="window.history.back();">Quay lại</button>
        </div>
    </div>
</body>
</html>