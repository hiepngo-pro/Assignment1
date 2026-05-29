package controller;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import utils.DBConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute("user");

        if(user == null) {

            response.sendRedirect("login");
            return;
        }

        try {

            Connection conn =
                    DBConnect.getConnection();

            String sql =
                    "SELECT v.* " +
                    "FROM favorites f " +
                    "JOIN videos v " +
                    "ON f.video_id = v.id " +
                    "WHERE f.user_id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, user.getId());

            ResultSet rs = ps.executeQuery();

            request.setAttribute(
                    "favorites",
                    rs
            );

            request.getRequestDispatcher(
                    "/views/favorite.jsp"
            ).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}