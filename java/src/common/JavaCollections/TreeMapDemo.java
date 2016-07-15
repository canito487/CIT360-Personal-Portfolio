package common.JavaCollections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String args[]) {
        // Create a hash map
        TreeMap tm = new TreeMap();
        // Put elements to the map
        tm.put("Alex", new Double(3434.34));
        tm.put("Malena", new Double(123.22));
        tm.put("Tony", new Double(1378.00));
        tm.put("John", new Double(99.22));
        tm.put("Laura", new Double(-19.08));

        System.out.println(tm);

        // Get a set of the entries
        Set set = tm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        // Deposit 1000 into Zara's account
        double balance = ((Double) tm.get("Alex")).doubleValue();
        tm.put("Alex", new Double(balance + 1000));
        System.out.println("Alex's new balance: " +
                tm.get("Alex"));
    }

}
