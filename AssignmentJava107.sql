CREATE DATABASE VideoManagement;
GO

USE VideoManagement;
GO

-- Bảng Users (lưu khách hàng và admin)
CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) UNIQUE NOT NULL,
    password NVARCHAR(255) NOT NULL,
    fullname NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) UNIQUE NOT NULL,
    role NVARCHAR(20) DEFAULT 'user',   -- 'user' hoặc 'admin'
    created_at DATETIME DEFAULT GETDATE()
);

-- Bảng Videos (tiểu phẩm)
CREATE TABLE Videos (
    id INT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(200) NOT NULL,
    poster NVARCHAR(500),               -- URL hình ảnh đại diện
    video_url NVARCHAR(200) NOT NULL,   -- YouTube ID hoặc URL embed
    description NVARCHAR(MAX),
    view_count INT DEFAULT 0,
    status BIT DEFAULT 1,               -- 1: active, 0: inactive
    created_at DATETIME DEFAULT GETDATE()
);

-- Bảng Favorites (yêu thích)
CREATE TABLE Favorites (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES Users(id) ON DELETE CASCADE,
    video_id INT NOT NULL FOREIGN KEY REFERENCES Videos(id) ON DELETE CASCADE,
    liked_date DATETIME DEFAULT GETDATE(),
    CONSTRAINT UQ_Favorite UNIQUE (user_id, video_id)
);

-- Bảng Shares (chia sẻ qua email)
CREATE TABLE Shares (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES Users(id) ON DELETE CASCADE,
    video_id INT NOT NULL FOREIGN KEY REFERENCES Videos(id) ON DELETE CASCADE,
    receiver_email NVARCHAR(100) NOT NULL,
    share_date DATETIME DEFAULT GETDATE()
);

-- Bảng History (lịch sử xem)
CREATE TABLE History (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES Users(id) ON DELETE CASCADE,
    video_id INT NOT NULL FOREIGN KEY REFERENCES Videos(id) ON DELETE CASCADE,
    view_date DATETIME DEFAULT GETDATE(),
    CONSTRAINT UQ_History UNIQUE (user_id, video_id)  -- mỗi user chỉ xem 1 lần/video (hoặc có thể bỏ)
);

-- Insert dữ liệu mẫu (1 admin + 2 user + 3 video)
INSERT INTO Users (username, password, fullname, email, role) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', N'Quản trị viên', 'admin@oe.com', 'admin'), -- pwd: admin (MD5)
('user1', 'e10adc3949ba59abbe56e057f20f883e', N'Nguyễn Văn A', 'user1@example.com', 'user'), -- pwd: 123456
('user2', 'e10adc3949ba59abbe56e057f20f883e', N'Trần Thị B', 'user2@example.com', 'user');

INSERT INTO Videos (title, poster, video_url, description, view_count) VALUES
(N'Tiểu phẩm: Lâu ghê mới gặp', 'https://img.youtube.com/vi/Ytet_bPiRCU/hqdefault.jpg', 'Ytet_bPiRCU', N'Hài hước về cuộc gặp gỡ bất ngờ', 150),
(N'Tiểu phẩm: Bệnh sĩ', 'https://img.youtube.com/vi/abc123/hqdefault.jpg', 'abc123', N'Chuyện về ông chồng sĩ diện', 98),
(N'Tiểu phẩm: Chuyến xe định mệnh', 'https://img.youtube.com/vi/xyz789/hqdefault.jpg', 'xyz789', N'Trên chiếc xe buýt đầy tiếng cười', 210);

-- Gán yêu thích mẫu
INSERT INTO Favorites (user_id, video_id) VALUES (2, 1), (2, 3), (3, 2);

-- Gán lịch sử xem mẫu
INSERT INTO History (user_id, video_id) VALUES (2, 1), (2, 2), (3, 1);

ALTER TABLE Favorites ADD CONSTRAINT FK_Favorites_Videos FOREIGN KEY (video_id) REFERENCES Videos(id) ON DELETE CASCADE;
ALTER TABLE Shares ADD CONSTRAINT FK_Shares_Videos FOREIGN KEY (video_id) REFERENCES Videos(id) ON DELETE CASCADE;
ALTER TABLE History ADD CONSTRAINT FK_History_Videos FOREIGN KEY (video_id) REFERENCES Videos(id) ON DELETE CASCADE;