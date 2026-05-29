package entity;

// CREATE TABLE Shares (
//     id INT IDENTITY(1,1) PRIMARY KEY,
//     user_id INT NOT NULL FOREIGN KEY REFERENCES Users(id) ON DELETE CASCADE,
//     video_id INT NOT NULL FOREIGN KEY REFERENCES Videos(id) ON DELETE CASCADE,
//     receiver_email NVARCHAR(100) NOT NULL,
//     share_date DATETIME DEFAULT GETDATE()
// );

import java.util.Date;

public class Share {

    private int id;
    private int userId;
    private int videoId;
    private String emails;
    private Date shareDate;

    public Share() {
    }

    public Share(int id, int userId,
                 int videoId, String emails,
                 Date shareDate) {

        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.emails = emails;
        this.shareDate = shareDate;
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

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }
}