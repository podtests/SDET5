package in.collections;

public class Wrapperdemo {

    public static void main(String[] args) {
        int a=5;


        Integer a1 = new Integer(a);  //Boxing : convert primitive data type into Object

        Integer a2 = a;  //AutoBoxing : automaticcaly  convert primitive data type into Object

       int b=  a2.intValue();       //UnBoxing:  convert object into primitive data type


    }
}
