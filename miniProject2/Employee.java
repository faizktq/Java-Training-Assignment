package miniProject2;

import java.io.Serializable;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }

    public static Employee fromString(String data) {
        String[] arr = data.split(",");
        return new Employee(
                Integer.parseInt(arr[0]),
                arr[1],
                arr[2],
                Double.parseDouble(arr[3])
        );
    }
}
