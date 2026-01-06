package Assignment3;

import java.util.*;

public class HashtableDemo {

        public static void main(String[] args) {

                // Constructor 1: Default
                Hashtable<Integer, String> ht1 = new Hashtable<>();
                System.out.println("ht1 (default): " + ht1);

                // Constructor 2: Initial capacity
                Hashtable<Integer, String> ht2 = new Hashtable<>(5);
                ht2.put(1, "Java");
                ht2.put(2, "Python");
                System.out.println("ht2 (initial capacity): " + ht2);

                // Constructor 3: Initial capacity + load factor
                Hashtable<Integer, String> ht3 = new Hashtable<>(5, 0.75f);
                ht3.put(3, "C");
                ht3.put(4, "C++");
                System.out.println("ht3 (capacity + load factor): " + ht3);

                // Constructor 4: Copy constructor
                Hashtable<Integer, String> ht4 = new Hashtable<>(ht2);
                System.out.println("ht4 (from map): " + ht4);

                // 1. put()
                ht1.put(10, "HTML");
                ht1.put(20, "CSS");
                System.out.println("After put(): " + ht1);

                // 2. putIfAbsent()
                ht1.putIfAbsent(20, "JavaScript");
                ht1.putIfAbsent(30, "JavaScript");
                System.out.println("After putIfAbsent(): " + ht1);

                // 3. get()
                System.out.println("get(10): " + ht1.get(10));

                // 4. getOrDefault()
                System.out.println("getOrDefault(100): " + ht1.getOrDefault(100, "Not Found"));

                // 5. remove(key)
                ht1.remove(20);
                System.out.println("After remove(key): " + ht1);

                // 6. containsKey()
                System.out.println("containsKey(30): " + ht1.containsKey(30));

                // 7. containsValue()
                System.out.println("containsValue(JavaScript): " + ht1.containsValue("JavaScript"));

                // 8. size()
                System.out.println("Size: " + ht1.size());

                // 9. isEmpty()
                System.out.println("isEmpty(): " + ht1.isEmpty());

                // 10. keys() – Enumeration
                System.out.print("Keys using keys(): ");
                Enumeration<Integer> enKeys = ht1.keys();
                while (enKeys.hasMoreElements()) {
                        System.out.print(enKeys.nextElement() + " ");
                }
                System.out.println();

                // 11. elements()
                System.out.print("Elements using elements(): ");
                Enumeration<String> enValues = ht1.elements();
                while (enValues.hasMoreElements()) {
                        System.out.print(enValues.nextElement() + " ");
                }
                System.out.println();

                // 12. entrySet()
                System.out.println("entrySet(): " + ht1.entrySet());

                // 13. keySet()
                System.out.println("keySet(): " + ht1.keySet());

                // 14. replace()
                ht1.replace(30, "Advanced JS");
                System.out.println("After replace(): " + ht1);

                // 15. clear()
                ht1.clear();
                System.out.println("After clear(): " + ht1);
        }
}

