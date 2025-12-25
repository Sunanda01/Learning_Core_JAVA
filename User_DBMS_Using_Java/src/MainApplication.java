import Model.User;
import Services.UserServices;

import java.util.Scanner;

public class MainApplication{
    public static void main(String[] args){
        UserServices user=new UserServices();
        try(Scanner scanner=new Scanner(System.in);){
            boolean isRunnable=true;
            while(isRunnable) {
                System.out.println("Enter Your Choice");
                System.out.println("1. Total User");
                System.out.println("2. Insert User");
                System.out.println("3. Get All User");
                System.out.println("4. Select User By ID");
                System.out.println("5. Update User By ID");
                System.out.println("6. Delete User By ID");
                System.out.println("7. Exit");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        user.totalUser();
                        break;
                    case 2:
                        System.out.println("Enter User_Name, User_Email");
                        user.addUser(new User(scanner.nextLine(), scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("List Of All Users");
                        System.out.println("=====================");
                        user.getAllUser();
                        System.out.println("=====================");
                        break;
                    case 4:
                        System.out.println("Enter User_Id to View Data => ");
                        user.getUserById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Enter User_Id to Update Name => ");
                        int existId=Integer.parseInt(scanner.nextLine());
                        boolean isFound=user.getUserById(existId);
                        if(isFound){
                            System.out.println("Enter User_Name => ");
                            user.updateUserNameById(scanner.nextLine(),existId);
                            System.out.println("Updated User Details");
                            user.getUserById(existId);
                        }
                        break;
                    case 6:
                        System.out.println("Enter User_Id to Delete Data => ");
                        user.deleteUserById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 7:
                        System.out.println("PROGRAM ENDS!!!!!!");
                        isRunnable = false;
                        break;
                    default:
                        System.out.println("INVALID CHOICE!!!!!!!!");
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went Wrong\n"+e);
        }
    }
}
