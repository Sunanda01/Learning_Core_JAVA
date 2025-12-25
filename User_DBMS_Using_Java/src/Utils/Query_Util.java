package Utils;

public class Query_Util {
    public static String insertUserQuery(){
        return "INSERT INTO USER (USER_NAME,USER_EMAIL) VALUES(?,?)";
    }
    public static String getAllUserQuery(){
        return "SELECT * FROM USER";
    }
    public static String getUserByIdQuery(int user_id){
        return "SELECT USER_ID, USER_NAME, USER_EMAIL FROM USER WHERE USER_ID = "+user_id;
    }
    public static String updateUserNameById(){
        return("UPDATE USER SET USER_NAME= ? WHERE USER_ID=?");
    }
    public static String deleteUserById(int user_id){
        return ("DELETE FROM USER WHERE USER_ID="+user_id);
    }
    public static String getCountOfUser(){
        return("SELECT COUNT(*) AS TOTAL_USER FROM USER");
    }

}
