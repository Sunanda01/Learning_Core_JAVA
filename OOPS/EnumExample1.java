package OOPS;
enum Status {                           //enum is class
    Running,Pending,Failed,Completed;   //this are objects => constants
}
public class EnumExample1 {
    public static void main(String[] args) {
        Status e=Status.Running;
        System.out.println(e+" : "+e.ordinal());

        Status[] ee=Status.values();
        for (Status s:ee){
            System.out.println(s+" : "+s.ordinal());        //ordinal => index value
        } 
    }
}
