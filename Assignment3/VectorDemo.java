package Assignment3;

import java.util.*;

public class VectorDemo {

		public static void main(String[] args) {

				// Constructor 1: Default constructor
				Vector<String> v1 = new Vector<>();
				System.out.println("Vector v1 (default): " + v1);

				// Constructor 2: Initial capacity
				Vector<String> v2 = new Vector<>(5);
				v2.add("Java");
				v2.add("Python");
				System.out.println("Vector v2 (initial capacity): " + v2);

				// Constructor 3: Initial capacity and capacity increment
				Vector<String> v3 = new Vector<>(3, 2);
				v3.add("C");
				v3.add("C++");
				System.out.println("Vector v3 (capacity + increment): " + v3);

				// Constructor 4: Collection constructor
				Vector<String> v4 = new Vector<>(v2);
				System.out.println("Vector v4 (from collection): " + v4);

				// 1. add(E)
				v1.add("HTML");
				System.out.println("After add(E): " + v1);

				// 2. add(int, E)
				v1.add(0, "CSS");
				System.out.println("After add(index, E): " + v1);

				// 3. addAll(Collection)
				v1.addAll(v3);
				System.out.println("After addAll(Collection): " + v1);

				// 4. get(int)
				System.out.println("Element at index 1 using get(): " + v1.get(1));

				// 5. set(int, E)
				v1.set(1, "JavaScript");
				System.out.println("After set(index, E): " + v1);

				// 6. size()
				System.out.println("Size using size(): " + v1.size());

				// 7. isEmpty()
				System.out.println("Is vector empty? " + v1.isEmpty());

				// 8. contains(Object)
				System.out.println("Contains Java? " + v1.contains("Java"));

				// 9. indexOf(Object)
				System.out.println("Index of C: " + v1.indexOf("C"));

				// 10. lastIndexOf(Object)
				v1.add("C");
				System.out.println("Last index of C: " + v1.lastIndexOf("C"));

				// 11. remove(int)
				v1.remove(0);
				System.out.println("After remove(index): " + v1);

				// 12. remove(Object)
				v1.remove("C++");
				System.out.println("After remove(Object): " + v1);

				// 13. toArray()
				Object[] arr = v1.toArray();
				System.out.println("Array using toArray(): " + Arrays.toString(arr));

				// 14. iterator()
				System.out.print("Traversal using iterator(): ");
				Iterator<String> it = v1.iterator();
				while (it.hasNext()) {
						System.out.print(it.next() + " ");
				}
				System.out.println();

				// 15. clear()
				v1.clear();
				System.out.println("After clear(): " + v1);
		}
}
