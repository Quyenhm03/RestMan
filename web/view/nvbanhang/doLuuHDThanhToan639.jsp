<%@page import="dao.HDThanhToanDAO639"%>
<%@page import="model.HDThanhToan639"%>
<%@page import="model.NguoiDung639"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    NguoiDung639 nd = (NguoiDung639) session.getAttribute("nvbanhang");
    if(nd == null) {
        response.sendRedirect(request.getContextPath() + "/view/dangnhap/gdDangNhap639.jsp?err=timeout");
        return; // Ngăn chặn thực hiện mã tiếp theo
    }
    HDThanhToan639 hoaDon = (HDThanhToan639) session.getAttribute("hoaDon");
    
    if((new HDThanhToanDAO639()).luuHDThanhToan(hoaDon)){       
        %>
        <script type="text/javascript">
            alert("Đăng kí thành công!");
            window.location.href = "<%= request.getContextPath() %>/view/nvbanhang/gdChinhNVBanHang639.jsp";
        </script>
        <%
    } else {
        %>
        <script type="text/javascript">
            alert("Lỗi đăng kí!");
            history.back();
        </script>
        <%
    }    
%>