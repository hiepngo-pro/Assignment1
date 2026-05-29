package entity;

// CREATE TABLE Favorites (
//     id INT IDENTITY(1,1) PRIMARY KEY,
//     user_id INT NOT NULL FOREIGN KEY REFERENCES Users(id) ON DELETE CASCADE,
//     video_id INT NOT NULL FOREIGN KEY REFERENCES Videos(id) ON DELETE CASCADE,
//     liked_date DATETIME DEFAULT GETDATE(),
//     CONSTRAINT UQ_Favorite UNIQUE (user_id, video_id)
// );

import java.util.Date;

public class Favorite {

    private int id;
    private int userId;
    private int videoId;
    private Date likeDate;

    public Favorite() {
    }

    public Favorite(int id, int userId,
                    int videoId, Date likeDate) {

        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.likeDate = likeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}