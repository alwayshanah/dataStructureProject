package employee;
import java.io.*;
import java.util.*;

public class EmployeeListHandler {
    File list;
    int lines;
    Employee employee;
    String[] array;
    Scanner s;

    public EmployeeListHandler() {
        list = new File("EmployeeList.txt");
        read();  // Initializes the Scanner
        if (s != null) {
            toArray();  // Only process if Scanner is initialized
        } else {
            System.out.println("Scanner not initialized. File may not have been found.");
        }
        lines = array != null ? array.length / 4 : 0;
    }

    public Employee[] getEmployees() {
        int j = 0;
        Employee[] e = new Employee[lines];
        for (int i = 0; i < lines; i++) {
            Employee node = new Employee(array[j], array[j + 1], (byte) Integer.parseInt(array[j + 2]), Integer.parseInt(array[j + 3]));
            e[i] = node;
            j += 4;
        }
        return e;
    }

    public String[] getArray() {
        return array;
    }

    public int getLines() {
        return lines;
    }

    public void toArray() {
        int n = 0;
        StringBuilder fileContent = new StringBuilder();  // Use StringBuilder for efficiency
        while (s.hasNextLine()) {
            fileContent.append(s.nextLine()).append(" ");
            n++;
        }
        array = fileContent.toString().split(", ");  // Split by ", " to create an array
    }

    public Employee arrayToEmployee(String n, String p, byte i, int id) {
        return employee = new Employee(n, p, i, id);
    }

    public void read() {
        try {
            s = new Scanner(list);  // Initialize the Scanner with the file
        } catch (FileNotFoundException e) {
            System.out.println("No File Detected!");
        }
    }

    public String encode(Employee[] eList) {
        StringBuilder encoded = new StringBuilder();
        for (Employee employee : eList) {
            if (employee == null) break;
            encoded.append(employee.getName()).append(", ")
                    .append(employee.getPosition()).append(", ")
                    .append(employee.getAge()).append(", ")
                    .append(employee.getID()).append(", \n");
        }
        return encoded.toString();
    }

    public void saveEmployees(Employee[] employeeList) {
        try {
            FileWriter writer = new FileWriter("EmployeeList.txt");
            writer.write(encode(employeeList));
            writer.close();
            System.out.println("Saved Successfully");
        } catch (IOException e) {
            System.out.println("An Error Has Occurred.");
        }
    }
}
