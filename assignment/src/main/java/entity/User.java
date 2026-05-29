package entity;

// CREATE TABLE Users (
//     id INT IDENTITY(1,1) PRIMARY KEY,
//     username NVARCHAR(50) UNIQUE NOT NULL,
//     password NVARCHAR(255) NOT NULL,
//     fullname NVARCHAR(100) NOT NULL,
//     email NVARCHAR(100) UNIQUE NOT NULL,
//     role NVARCHAR(20) DEFAULT 'user',   -- 'user' hoặc 'admin'
//     created_at DATETIME DEFAULT GETDATE()
// );

public class User {

    private int id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private boolean admin;

    public User() {
    }

    public User(int id, String username, String password,
                String fullname, String email, boolean admin) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}