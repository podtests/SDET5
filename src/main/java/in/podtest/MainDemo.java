package in.podtest;

public class MainDemo {

    public static void main(String[] args) {

       Employee.name = "Akhil";

        System.out.println(Employee.name);

        Employee e1 = new Employee();

        Employee e2 = new Employee();
            e1.doWork();
        System.out.println(e1.name);
        System.out.println(e2.name);

        e1.name = "Jain";

        System.out.println(Employee.name);
        System.out.println(e1.name);
        System.out.println(e2.name);
        //age




    }
}
