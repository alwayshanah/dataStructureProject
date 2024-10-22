package employee;

import java.util.LinkedList;

public class DS_EmployeeQueue_LinkedList {
   
   private LinkedList<Employee> employeeList;

   public DS_EmployeeQueue_LinkedList() {
      employeeList = new LinkedList<>(); 
   }

   public boolean checkDuplicateID(int ID) {
      for (Employee employee : employeeList) {
         if (employee.getID() == ID) {
            return false; 
         }
      }
      return true; 
   }

   public void enqueue(Employee employee) {
      if (checkDuplicateID(employee.getID())) { 
         employeeList.add(employee); 
      } else {
         System.out.println("Duplicate ID! Employee not added.");
      }
   }
   
   public void remove() {
      if (!employeeList.isEmpty()) {
         employeeList.removeFirst();
      } else {
         System.out.println("List is empty, nothing to remove.");
      }
   }

   public void removeByIndex(int index) {
      if (index >= 0 && index < employeeList.size()) {
         employeeList.remove(index); 
      } else {
         System.out.println("Index out of bounds.");
      }
   }

   public Employee getItem(int index) {
      if (index >= 0 && index < employeeList.size()) {
         return employeeList.get(index); 
      }
      return null; 
   }

   public int getSize() {
      return employeeList.size(); 
   }

   public LinkedList<Employee> getList() {
      return employeeList; 
   }

   public int searchByName(String name) {
      for (int i = 0; i < employeeList.size(); i++) {
         if (employeeList.get(i).getName().equals(name)) {
            return i; 
         }
      }
      return -1; 
   }

   public int searchByID(int id) {
      for (int i = 0; i < employeeList.size(); i++) {
         if (employeeList.get(i).getID() == id) {
            return i; 
         }
      }
      return -1; 
   }

   @Override
   public String toString() {
      StringBuilder str = new StringBuilder();
      for (Employee employee : employeeList) {
         str.append(employee.toString()).append("\n\n");
      }
      return str.toString(); 
   }
}
