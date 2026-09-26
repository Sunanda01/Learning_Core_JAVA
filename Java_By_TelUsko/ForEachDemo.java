package Java_By_TelUsko;

import java.util.*;
import java.util.function.Consumer;
class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> nums=Arrays.asList(2,4,6,8,10);

        // Internal Step
        // Consumer<Integer> con=new Consumer<Integer>(){
        //     public void accept(Integer n){
        //         System.out.println(n);
        //     }
        // };

        // Internal Step with Lambda Exp
        //Consumer<Integer> con = n -> System.out.println(n);     
        // nums.forEach(con);

        // Final Step
        nums.forEach(n -> System.out.println(n));
    }
}