package Model;

public class User{
    private int userId;
    private String userName;
    private final String userEmail;

    public User(int userId, String userName, String userEmail) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userId = userId;
    }

    public User(String userName, String userEmail){
        this.userName=userName;
        this.userEmail=userEmail;
    }

    public int getUserId(){
        return this.userId;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getUserEmail(){
        return this.userEmail;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

}
