package JavaConceptExample.Collections;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers=new ArrayList<Integer>();
        listOfNumbers.add(20);
        listOfNumbers.add(10);
        listOfNumbers.add(60);
        listOfNumbers.add(80);
        listOfNumbers.add(30);
        System.out.println(listOfNumbers);
        for(int i=0;i<listOfNumbers.size();i++)
            listOfNumbers.set(i, listOfNumbers.get(i)*2);
        System.out.println(listOfNumbers);
    }
}
