package in.collections;

import in.advance.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionDemo {

    public static void main(String[] args) {
        CollectionDemo d1 = new CollectionDemo();
        d1.mapDemo();
    }

    public void mapDemo() {

        HashMap<Integer, String> m1 = new HashMap<Integer, String> ();

        //add items
        m1.put(1, "AJ");
        m1.put(5, "SK");
        m1.put(8, "PI");

        //remove an item
        m1.remove(5);

        //check the existance
        m1.containsKey(10); //false
        m1.containsValue("AJ1");//false

        //fetch items based on key
        m1.get(10); // PI

        //iterate
        Iterator<Integer> i1 =  m1.keySet().iterator();
        while(i1.hasNext()) {

            System.out.println(m1.get(i1.next()));
        }


    }

    public void setDemo() {

        HashSet<String> s1 = new HashSet<String>();

        s1.add("Akhil");
        s1.add("Pankaj");

        //s1.add("Akhil");

        s1.remove("Akhil");
        //s1.remove(0);

        Iterator<String> st = s1.iterator();
        while(st.hasNext()) {
            System.out.println(st.next());
        }


        for(String s: s1) {

            System.out.println(s);

        }


    }

    public void listDemo() {
        Employee e1 = new Employee();
        e1.setName("Akhil");

        Employee e2 = new Employee();
        e2.setName("Jain");


        ArrayList<Employee>  el = new ArrayList<Employee>();

        el.add(e1);
        el.add(e2);

        for(Employee e : el) {
            System.out.println(e.getName());
        }


/*
        //ArrayList guestList = new ArrayList () ; //Name: String

        ArrayList<String> guestList = new ArrayList<String> (); //Name: String

        String s = "Akhil";
        guestList.add(s);
        guestList.add("Pankaj");
        guestList.add("Shruti");
        //guestList.add(e1);

        guestList.remove("Pankaj");
        //System.out.println(        guestList.size());



       // boolean isExist = guestList.contains("Abhinav");

        //System.out.println(isExist);

        Iterator<> i1 = guestList.iterator();

        System.out.println("checking item: "+i1);

*/
    }
}
