package in.advance;

public class JavaEngine {

    public static void main(String[] args) {

        Employee e1 = new Employee();

        //e1.name = "Raj";
        e1.setName("Raj");

        System.out.println(e1.getName());

        e1.printEmployeeData();
    }
}
