package controllers;

import entities.Ban;
import entities.MoiQuanHe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.FriendRepo;
import repositories.RelationshipRepo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FriendManager", value = {
       "/hienThi",
       "/remove",
       "/update"
})
public class FriendManager extends HttpServlet {
        FriendRepo friendRepo = new FriendRepo();
        RelationshipRepo repo = new RelationshipRepo();
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if (uri.equals("/hienThi")) {
                home(request, response);
            } else if (uri.contains("remove")) {
                   delete(request, response);
            }
       }

       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if (uri.equals("/update")) {
                   try {
                          update(request, response);
                   } catch (ParseException e) {
                          throw new RuntimeException(e);
                   }
            }
       }

        protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String id = request.getParameter("id");
                if (id != null && !id.trim().isEmpty()){
                       Ban ban = friendRepo.findById(Integer.parseInt(id));
                       request.setAttribute("ban", ban);
                }
                request.setAttribute("listMqh",repo.getRelationships());
                request.setAttribute("list", friendRepo.getBanList());
                request.getRequestDispatcher("/ban/list.jsp").forward(request, response);
        }

        protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
              String id = request.getParameter("id");
              if (id != null && !id.trim().isEmpty()){
                     int idF = Integer.parseInt(id);
                     String ma = request.getParameter("ma");
                     String ten = request.getParameter("ten");
                     String _ngaySinh = request.getParameter("ngaySinh");
                     // Parse the ngaySinh parameter from the date
                     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                     Date date = format.parse(_ngaySinh);
                     java.sql.Date ngaySinh = new java.sql.Date(date.getTime());
                     String soThich = request.getParameter("soThich");
                     int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
                     int idMqh = Integer.parseInt(request.getParameter("idMqh"));
                     MoiQuanHe moiQuanHe = repo.findById(idMqh);
                     int trangThai = Integer.parseInt(request.getParameter("trangThai"));
                     Ban ban = friendRepo.findById(idF);
                     ban.setMa(ma);
                     ban.setTen(ten);
                     ban.setNgaySinh(ngaySinh);
                     ban.setSoThich(soThich);
                     ban.setGioiTinh(gioiTinh);
                     ban.setIdMqh(moiQuanHe);
                     ban.setTrangThai(trangThai);
                     friendRepo.update(ban);
              }
                     response.sendRedirect("/hienThi?id=");

        }

        protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              int id = Integer.parseInt(request.getParameter("id"));
              friendRepo.delete(friendRepo.findById(id));
              response.sendRedirect("/hienThi?id=");
        }
}
