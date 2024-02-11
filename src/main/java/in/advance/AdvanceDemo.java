package in.advance;

public class AdvanceDemo {

    public String name; //instance variable
    boolean isValid;
    int empId2;

    public  void getData() {
        int empId; //local variable
        System.out.println("Name is: "+empId2 );
    }


    public void calculate() {

        int c = 5 +6;
        System.out.println(c); //11
    }

    public void calculate(int a) {

        int c = a +6;
        System.out.println(c);
    }

    public void calculate(String b) {

        int c = 5 +6;
        System.out.println(c + b);
    }


    public AdvanceDemo() {
        System.out.println("name is:"+name);
    }



}
