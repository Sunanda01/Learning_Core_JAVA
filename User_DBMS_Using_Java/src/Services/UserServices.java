package Services;

import Model.User;
import Utils.Database_Connection;
import Utils.Query_Util;

import java.sql.*;

public class UserServices {
    Database_Connection databaseConnection=new Database_Connection();

    public void totalUser() throws SQLException{
        try(Connection connection= databaseConnection.getDBConnection();
            Statement statement=connection.createStatement()){
            ResultSet resultSet=statement.executeQuery(Query_Util.getCountOfUser());
            int total=0;
            if(resultSet.next())
                total=resultSet.getInt("TOTAL_USER");
            System.out.println("Total User => "+total);
        }
    }

    public void addUser(User user) throws SQLException {
        try(Connection connection=databaseConnection.getDBConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(Query_Util.insertUserQuery())
        ){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserEmail());
            int rows=preparedStatement.executeUpdate();
            if(rows>0)
                System.out.println("Data Inserted Successfully");
            else
                System.out.println("Failed to Insert Data");
        }
    }

    public void getAllUser() throws SQLException{
        try(Connection connection=databaseConnection.getDBConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(Query_Util.getAllUserQuery());
        ){
            while (resultSet.next()){
                displayUser(new User(
                        resultSet.getInt("USER_ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("USER_EMAIL")));
            }
        }
    }

    public boolean getUserById(int user_id) throws SQLException{
        boolean isFound=false;
        try(Connection connection=databaseConnection.getDBConnection();
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery(Query_Util.getUserByIdQuery(user_id))
            ){
            if (resultSet.next()){
                isFound=true;
                displayUser(new User(
                        resultSet.getInt("USER_ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("USER_EMAIL")));
            }
            else
                System.out.println("No User Found With ID => "+user_id);
        }
        return isFound;
    }

    public void updateUserNameById(String user_name, int user_id) throws SQLException{
        try(Connection connection=databaseConnection.getDBConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(Query_Util.updateUserNameById())){
            preparedStatement.setString(1,user_name);
            preparedStatement.setInt(2,user_id);
            int rowsUpdated=preparedStatement.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("Username Updated");
            }
            else
                System.out.println("Failed to Update Username");
        }
    }

    public void deleteUserById(int user_id) throws SQLException{
        try(Connection connection=databaseConnection.getDBConnection();
            Statement statement=connection.createStatement();
            ){
            int rows=statement.executeUpdate(Query_Util.deleteUserById(user_id));
            if(rows>0)
                System.out.println("UserId => "+user_id+" Deleted Successfully");
            else
                System.out.println("Failed To Delete UserId => "+user_id);
        }
    }

    public void displayUser(User user){
        System.out.println("User ID => "+user.getUserId());
        System.out.println("User Name => "+user.getUserName());
        System.out.println("User EmailId => "+user.getUserEmail());
        System.out.println();
    }
}
