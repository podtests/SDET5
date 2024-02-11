package in.podtest;

public class DataTypeDemo {

    public static void main(String[] args) {
        /*
        int empId = 7;

        char myInitials = 'a';

        boolean isValid = true;

        float perc = 78.74f;

        String name = "Akhil Jain";
        System.out.println(empId);
        System.out.println(myInitials);
        System.out.println(isValid);
        System.out.println(perc);
        System.out.println(name);
        */
        //int d= sum(5,6);
        //System.out.println("Akhil");
        //String type = findEvenOdd(6);
        //System.out.println(type);

        findColor("green");
    }

    public static int  sum(int a , int b) {

        int c;
        c = a+b;
        return c;
        //return c;
        //logic
    }


    public static String findEvenOdd(int a) {

        String answer;
        if(a%2==0) {
            answer = "even";
        }
        else {
            answer = "odd";
        }

        return answer;
    }

    public static void findColor(String colorName) {

        switch (colorName.toLowerCase()) {
            case "black" : {
                System.out.println("Color is black");
                break;
            }
            case "green": {
                System.out.println("Color is Green");
                break;
            }
            case "blue": {
                System.out.println("Color is blue");
                break;
            }
            default: {
                System.out.println("Color is exceptional");
            }
        }

    }



    //5,6
}
