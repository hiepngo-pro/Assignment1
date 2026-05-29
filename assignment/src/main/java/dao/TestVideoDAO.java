package dao;

import entity.Video;

import java.util.List;

public class TestVideoDAO {

    public static void main(String[] args) {

        VideoDAO dao = new VideoDAO();

        List<Video> list = dao.findAll();

        for(Video v : list) {

            System.out.println(v.getTitle());
        }
    }
}