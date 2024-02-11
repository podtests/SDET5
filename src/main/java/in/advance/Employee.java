package in.advance;

public class Employee {

    private String name = "Akhil";

    //getters
    public String getName() {
        return name;
    }

    //setters
    public void setName(String localName) {
        name = localName;
    }

    public void printEmployeeData() {
        System.out.println("Name is:"+name);
    }
}
