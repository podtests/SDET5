package in.inheritance;

public class Animal {

    protected String animalName;

    public void eat() {
        System.out.println(animalName + " is eating" );
    }

//overloaded mode
    public void eat(String foodName) { //overloaded
        System.out.println(animalName +"is eating food: "+ foodName);
    }

    public void walk() {
        System.out.println(animalName + " is walking" );
    }
}
