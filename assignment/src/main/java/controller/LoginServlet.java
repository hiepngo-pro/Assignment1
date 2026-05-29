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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.getRequestDispatcher(
                "/views/login.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Connection conn = DBConnect.getConnection();

            String sql =
                    "SELECT * FROM users " +
                    "WHERE username=? AND password=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setAdmin(rs.getBoolean("admin"));

                HttpSession session =
                        request.getSession();

                session.setAttribute("user", user);

                response.sendRedirect("home");

            } else {

                request.setAttribute(
                        "message",
                        "Sai tài khoản hoặc mật khẩu!"
                );

                request.getRequestDispatcher(
                        "/views/login.jsp"
                ).forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}