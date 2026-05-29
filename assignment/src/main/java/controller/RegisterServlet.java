package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import utils.DBConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.getRequestDispatcher(
                "/views/register.jsp"
        ).forward(request, response);
    }

    @Override
   protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        String fullname =
                request.getParameter("fullname");

        String email =
                request.getParameter("email");

        try {

            Connection conn =
                    DBConnect.getConnection();

            String sql =
                    "INSERT INTO users " +
                    "(username,password,fullname,email,admin) " +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setBoolean(5, false);

            int result = ps.executeUpdate();

            if(result > 0) {

                request.setAttribute(
                        "message",
                        "Đăng ký thành công!"
                );

            } else {

                request.setAttribute(
                        "message",
                        "Đăng ký thất bại!"
                );
            }

            request.getRequestDispatcher(
                    "/views/register.jsp"
            ).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}