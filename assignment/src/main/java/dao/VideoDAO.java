package dao;

import entity.Video;
import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    public List<Video> findAll() {

        List<Video> list = new ArrayList<>();

        try {

            Connection conn = DBConnect.getConnection();

            String sql = "SELECT * FROM videos";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Video video = new Video();

                video.setId(rs.getInt("id"));
                video.setTitle(rs.getString("title"));
                video.setPoster(rs.getString("poster"));
                video.setViews(rs.getInt("views"));
                video.setDescription(rs.getString("description"));
                video.setActive(rs.getBoolean("active"));

                list.add(video);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}