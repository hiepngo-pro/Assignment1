package entity;

// CREATE TABLE Videos (
//     id INT IDENTITY(1,1) PRIMARY KEY,
//     title NVARCHAR(200) NOT NULL,
//     poster NVARCHAR(500),               -- URL hình ảnh đại diện
//     video_url NVARCHAR(200) NOT NULL,   -- YouTube ID hoặc URL embed
//     description NVARCHAR(MAX),
//     view_count INT DEFAULT 0,
//     status BIT DEFAULT 1,               -- 1: active, 0: inactive
//     created_at DATETIME DEFAULT GETDATE()
// );

public class Video {

    private int id;
    private String title;
    private String poster;
    private int views;
    private String description;
    private boolean active;

    public Video() {
    }

    public Video(int id, String title, String poster,
                 int views, String description, boolean active) {

        this.id = id;
        this.title = title;
        this.poster = poster;
        this.views = views;
        this.description = description;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}