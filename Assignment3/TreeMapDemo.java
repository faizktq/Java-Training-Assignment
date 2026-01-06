package Assignment3;

import java.util.*;

public class TreeMapDemo {

        public static void main(String[] args) {

                // Constructor 1: Default constructor
                TreeMap<Integer, String> tm1 = new TreeMap<>();
                System.out.println("tm1 (default): " + tm1);

                // Constructor 2: Custom comparator
                TreeMap<Integer, String> tm2 = new TreeMap<>(Comparator.reverseOrder());
                tm2.put(1, "Java");
                tm2.put(2, "Python");
                tm2.put(3, "C++");
                System.out.println("tm2 (reverse order comparator): " + tm2);

                // Constructor 3: Map-based constructor
                TreeMap<Integer, String> tm3 = new TreeMap<>(tm2);
                System.out.println("tm3 (from map): " + tm3);

                // Constructor 4: SortedMap constructor
                SortedMap<Integer, String> sm = new TreeMap<>();
                sm.put(10, "HTML");
                sm.put(20, "CSS");
                TreeMap<Integer, String> tm4 = new TreeMap<>(sm);
                System.out.println("tm4 (from SortedMap): " + tm4);

                // 1. put()
                tm1.put(100, "A");
                tm1.put(50, "B");
                tm1.put(75, "C");
                System.out.println("After put(): " + tm1);

                // 2. putIfAbsent()
                tm1.putIfAbsent(75, "X");
                tm1.putIfAbsent(200, "D");
                System.out.println("After putIfAbsent(): " + tm1);

                // 3. putAll()
                tm1.putAll(tm4);
                System.out.println("After putAll(): " + tm1);

                // 4. get()
                System.out.println("get(50): " + tm1.get(50));

                // 5. getOrDefault()
                System.out.println("getOrDefault(999): " + tm1.getOrDefault(999, "Not Found"));

                // 6. remove()
                tm1.remove(75);
                System.out.println("After remove(key): " + tm1);

                // 7. containsKey()
                System.out.println("containsKey(100): " + tm1.containsKey(100));

                // 8. containsValue()
                System.out.println("containsValue(\"CSS\"): " + tm1.containsValue("CSS"));

                // 9. size()
                System.out.println("Size: " + tm1.size());

                // 10. isEmpty()
                System.out.println("isEmpty(): " + tm1.isEmpty());

                // 11. firstKey()
                System.out.println("firstKey(): " + tm1.firstKey());

                // 12. lastKey()
                System.out.println("lastKey(): " + tm1.lastKey());

                // 13. keySet()
                System.out.println("keySet(): " + tm1.keySet());

                // 14. entrySet()
                System.out.println("entrySet(): " + tm1.entrySet());

                // 15. clear()
                tm1.clear();
                System.out.println("After clear(): " + tm1);
        }
}
