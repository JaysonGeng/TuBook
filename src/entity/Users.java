package entity;

public class Users {

    private int id;
    private String UserName;
    private String PassWord;
    private String Image;
    private int IsRemember;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getIsRemember() {
        return IsRemember;
    }

    public void setIsRemember(int isRemember) {
        IsRemember = isRemember;
    }
}
