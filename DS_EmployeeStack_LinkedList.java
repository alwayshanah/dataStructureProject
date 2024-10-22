package employee;

import java.util.LinkedList;

public class DS_EmployeeStack_LinkedList {
   
   private LinkedList<Employee> EmployeeStack;

   public DS_EmployeeStack_LinkedList() {
      makeEmpty();
   }

   public void makeEmpty() {
      EmployeeStack = new LinkedList<>();
   }

   public boolean isEmpty() {
      return EmployeeStack.isEmpty();
   }

   public void push(Employee E) {
      EmployeeStack.push(E);
   }

   public Employee pop() {
      if (!isEmpty()) {
         return EmployeeStack.pop();
      } else {
         System.out.println("Stack is empty, cannot pop.");
         return null;
      }
   }

   public Employee peek() {
      if (!isEmpty()) {
         return EmployeeStack.peek(); 
      } else {
         System.out.println("Stack is empty, cannot peek.");
         return null;
      }
   }

   public int getSize() {
      return EmployeeStack.size();
   }
   
   public Employee[] getList() {
      Employee[] empArray = new Employee[getSize()];
      int index = 0;
      for (Employee employee : EmployeeStack) {
         empArray[index] = employee;
         index++;
      }
      return empArray;
   }
   
   public int searchByName(String name) {
      int index = 0;
      for (Employee employee : EmployeeStack) {
         if (employee.getName().equals(name)) {
            return index; 
         }
         index++;
      }
      return -1; 
   }

   public int searchByID(int id) {
      int index = 0;
      for (Employee employee : EmployeeStack) {
         if (employee.getID() == id) {
            return index; 
         }
         index++;
      }
      return -1; 
   }

   public boolean checkDuplicateID(int ID) {
      for (Employee employee : EmployeeStack) {
         if (employee.getID() == ID) {
            return true; 
         }
      }
      return false; 
   }

   public String toString() {
      StringBuilder str = new StringBuilder();
      for (Employee employee : EmployeeStack) {
         str.append(employee.toString()).append("\n\n");
      }
      return str.toString();
   }
}
