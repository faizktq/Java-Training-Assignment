package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        //Demonstration of all constructor of Arraylist
        // 1. Default Constructor -- It creates arrayList with initial capacity 10
        ArrayList <String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");

        System.out.println("1. Default Constructor:");
        System.out.println(list1);

        //2. ArrayList with specified initial capacity

        ArrayList <Integer> list2 = new ArrayList<>(20);
        list2.add(10);
        list2.add(20);
        list2.add(30);

        System.out.println("\n2. Constructor with Initial Capacity:");
        System.out.println(list2);

        //3. Constructor with collection -- here it creates arraylist of elements of spicified collection
        // signature -- ArrayList(Collection<? extends E> c) -- here it will creates only arrayList of only E or childs of E
        
        // collection whose we will create arrayList
        List <String> source = new LinkedList<>();
        source.add("Apple");
        source.add("Mango");
        source.add("Banana");

        // Creating arrayList of source LinkedList collection
        ArrayList <String> list3 = new ArrayList<>(source);

        System.out.println("\n3. Constructor with Collection:");
        System.out.println(list3);
 
        // Demonstration of methods of ArrayList
        
        ArrayList<String> list = new ArrayList<>();

        // 1. add
		list.add("Java");
		list.add("Python");
		System.out.println("After add(E): " + list);

		list.add(1, "C++");
		System.out.println("After add(index, E): " + list);

		ArrayList<String> extra = new ArrayList<>();
		extra.add("C");
		extra.add("HTML");

		list.addAll(extra);
		System.out.println("After addAll(Collection): " + list);

		list.addAll(1, extra);
		System.out.println("After addAll(index, Collection): " + list);

		// 2. get
		String e1 = list.get(0);
		System.out.println("Element at index 0 using get(): " + e1);

		// 3. set
		list.set(0, "Core Java");
		System.out.println("After set(index, E): " + list);

		// 4. size
		int size = list.size();
		System.out.println("Size using size(): " + size);

		// 5. isEmpty
		boolean empty = list.isEmpty();
		System.out.println("Is list empty? " + empty);

		// 6. contains
		boolean found = list.contains("Python");
		System.out.println("Contains Python? " + found);

		// 7. indexOf
		int firstIndex = list.indexOf("C");
		System.out.println("Index of C using indexOf(): " + firstIndex);

		// 8. lastIndexOf
		int lastIndex = list.lastIndexOf("C");
		System.out.println("Last index of C using lastIndexOf(): " + lastIndex);

		// 9. remove
		list.remove(0);
		System.out.println("After remove(index): " + list);

		list.remove("HTML");
		System.out.println("After remove(Object): " + list);

		list.removeAll(extra);
		System.out.println("After removeAll(Collection): " + list);

		// 10. toArray
		Object[] arr1 = list.toArray();
		System.out.println("toArray(): " + Arrays.toString(arr1));

		String[] arr2 = list.toArray(new String[0]);
		System.out.println("toArray(T[]): " + Arrays.toString(arr2));

		// 11. iterator
		System.out.print("Traversal using iterator(): ");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
				System.out.print(it.next() + " ");
		}
		System.out.println();

		// 12. listIterator
		System.out.print("Traversal using listIterator(): ");
		ListIterator<String> lit1 = list.listIterator();
		while (lit1.hasNext()) {
				System.out.print(lit1.next() + " ");
		}
		System.out.println();

		// 13. ensureCapacity
		list.ensureCapacity(20);
		System.out.println("ensureCapacity(20) called");

		// 14. trimToSize
		list.trimToSize();
		System.out.println("trimToSize() called");

		// 15. clear
		list.clear();
		System.out.println("After clear(): " + list);
    }
}
