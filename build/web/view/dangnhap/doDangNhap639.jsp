<%@page import="dao.NguoiDungDAO639"%>
<%@page import="model.NguoiDung639"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username = (String)request.getParameter("username");
    String password = (String)request.getParameter("password");
    NguoiDung639 nd = new NguoiDung639();
    
    nd.setTenDangNhap(username);
    nd.setMatKhau(password);
    
    NguoiDungDAO639 ndDAO = new NguoiDungDAO639();
    boolean kq = ndDAO.ktraDangNhap(nd);
    if(kq && (nd.getVaiTro() == 0)){
        session.setAttribute("khachhang", nd);
        response.sendRedirect(request.getContextPath() + "/view/khachhang/gdChinhKH639.jsp");
    }else if(kq && (nd.getVaiTro() == 1)){
        session.setAttribute("nvbanhang", nd);
        response.sendRedirect(request.getContextPath() + "/view/nvbanhang/gdChinhNVBanHang639.jsp");
    }else{
        response.sendRedirect(request.getContextPath() + "/view/dangnhap/gdDangNhap639.jsp?err=fail");
    }
%>
