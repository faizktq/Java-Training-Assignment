import java.util.*;
import java.util.regex.*;

class Student {
    int id;
    String name;
    String course;
    double marks;

    Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + course + " | " + marks;
    }
}

interface StudentOperations {
    void addStudent(Student s);
    void displayStudents();
    void removeStudent(int id);
    void searchStudent(int id);
    void sortByMarks();
}

class StudentManager implements StudentOperations {

    ArrayList<Student> students = new ArrayList<>();
    Set<Integer> studentIds = new HashSet<>();
    Set<String> courses = new HashSet<>();

    Map<Integer, Student> studentMap = new HashMap<>();
    Hashtable<Integer, Student> safeMap = new Hashtable<>();
    Stack<Student> history = new Stack<>();
    Vector<Student> legacyVector = new Vector<>();

    @Override
    public void addStudent(Student s) {
        if (studentIds.add(s.id)) {
            students.add(s);
            studentMap.put(s.id, s);
            safeMap.put(s.id, s);
            courses.add(s.course);
            history.push(s);
            legacyVector.add(s);
        } else {
            System.out.println("Duplicate Student ID not allowed!");
        }
    }

    @Override
    public void displayStudents() {
        students.forEach(System.out::println);
    }

    @Override
    public void removeStudent(int id) {
        students.removeIf(s -> s.id == id);
        studentMap.remove(id);
        safeMap.remove(id);
        studentIds.remove(id);
    }

    @Override
    public void searchStudent(int id) {
        Student s = studentMap.get(id);
        System.out.println(s != null ? s : "Student Not Found");
    }

    @Override
    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(s -> s.marks));
    }

    void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Student s : students) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("Course-wise Count:");
        countMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    void convertHashMapToTreeMap() {
        TreeMap<Integer, Student> treeMap = new TreeMap<>(studentMap);
        System.out.println("TreeMap (Sorted by ID):");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    void displayCourses() {
        System.out.println("Unique Courses:");
        courses.forEach(System.out::println);
    }
}


public class UniversityManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        Pattern namePattern = Pattern.compile("^[A-Za-z ]+$");

        while (true) {
            System.out.println("\n1.Add  2.Display  3.Remove  4.Search  5.Sort  6.Count  7.TreeMap  8.Courses  9.Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        Matcher m = namePattern.matcher(name);
                        if (!m.matches()) {
                            throw new Exception("Invalid Name Format");
                        }

                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();
                        sc.close();

                        manager.addStudent(new Student(id, name, course, marks));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        manager.sortByMarks();
                        System.out.println("Sorted Successfully");
                        break;

                    case 6:
                        manager.countCourseWise();
                        break;

                    case 7:
                        manager.convertHashMapToTreeMap();
                        break;

                    case 8:
                        manager.displayCourses();
                        break;

                    case 9:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
