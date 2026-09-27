public class ArraysDemo {
    public static void main(String[] args) {
        int marks[]={10,20,30,40,50};
        System.out.println(marks.length);
        int marks1[]=new int[3];
        marks1[0]=20;
        marks1[1]=30;
        marks1[2]=10;
        System.out.println(marks1.length);
        int marks2[]=new int[]{10,20,30,40,50,60}; 
        System.out.println(marks2.length);
        for(int m:marks)
            System.out.print(m+"\t");
        System.out.println("\nCopying Array");
        int copy_marks[]=new int[marks.length];
        for(int i=0;i<marks.length;i++)
            copy_marks[i]=marks[i];
        for(int m:copy_marks)
            System.out.print(m+"\t");
    }
}
