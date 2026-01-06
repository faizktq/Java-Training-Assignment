package Assignment3;

import java.util.*;

public class HashMapDemo {

		public static void main(String[] args) {

				// Constructor 1: Default constructor
				HashMap<Integer, String> map1 = new HashMap<>();
				System.out.println("map1 (default constructor): " + map1);

				// Constructor 2: Initial capacity
				HashMap<Integer, String> map2 = new HashMap<>(5);
				map2.put(1, "Java");
				map2.put(2, "Python");
				System.out.println("map2 (initial capacity): " + map2);

				// Constructor 3: Initial capacity and load factor
				HashMap<Integer, String> map3 = new HashMap<>(5, 0.75f);
				map3.put(3, "C");
				map3.put(4, "C++");
				System.out.println("map3 (capacity + load factor): " + map3);

				// Constructor 4: Map-based constructor
				HashMap<Integer, String> map4 = new HashMap<>(map2);
				System.out.println("map4 (from another map): " + map4);

				// 1. put()
				map1.put(1, "HTML");
				map1.put(2, "CSS");
				System.out.println("After put(): " + map1);

				// 2. putIfAbsent()
				map1.putIfAbsent(2, "JavaScript");
				map1.putIfAbsent(3, "JavaScript");
				System.out.println("After putIfAbsent(): " + map1);

				// 3. putAll()
				map1.putAll(map3);
				System.out.println("After putAll(): " + map1);

				// 4. get()
				System.out.println("Value for key 1 using get(): " + map1.get(1));

				// 5. getOrDefault()
				System.out.println("getOrDefault(10): " + map1.getOrDefault(10, "Not Found"));

				// 6. remove()
				map1.remove(4);
				System.out.println("After remove(key): " + map1);

				// 7. containsKey()
				System.out.println("Contains key 3? " + map1.containsKey(3));

				// 8. containsValue()
				System.out.println("Contains value Java? " + map1.containsValue("Java"));

				// 9. size()
				System.out.println("Size using size(): " + map1.size());

				// 10. isEmpty()
				System.out.println("Is map empty? " + map1.isEmpty());

				// 11. keySet()
				System.out.println("Keys using keySet(): " + map1.keySet());

				// 12. values()
				System.out.println("Values using values(): " + map1.values());

				// 13. entrySet()
				System.out.println("Entries using entrySet(): " + map1.entrySet());

				// 14. replace()
				map1.replace(3, "Advanced Java");
				System.out.println("After replace(): " + map1);

				// 15. clear()
				map1.clear();
				System.out.println("After clear(): " + map1);
		}
}

