package common.JavaCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String args[]) {

        // Create a hash map
        HashMap hm = new HashMap();
        // Put elements to the map
        hm.put("Alex", new Double(3434.34));
        hm.put("Malena", new Double(123.22));
        hm.put("Tony", new Double(1378.00));
        hm.put("John", new Double(99.22));
        hm.put("Laura", new Double(-19.08));
        System.out.println(hm);

        // Get a set of the entries
        Set set = hm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        System.out.println("Pring using a SET");
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();
        // Deposit 1000 into Alex's account
        double balance = ((Double) hm.get("Alex")).doubleValue();
        hm.put("Alex", new Double(balance + 1000));
        System.out.println("Alex's new balance: " + hm.get("Alex"));
    }

}
