package controller;

import dao.VideoDAO;
import entity.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        VideoDAO dao = new VideoDAO();

        List<Video> list = dao.findAll();

        request.setAttribute("videos", list);

        request.getRequestDispatcher("/views/home.jsp")
                .forward(request, response);
    }
}