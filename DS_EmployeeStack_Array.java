import java.util.Arrays;

public class DS_EmployeeStack_Array {
   
   final int arraySize = 100; 
   Employee EmployeeList[]; 
   int size;

   DS_EmployeeStack_Array() {
      makeEmpty();
   }

   public void makeEmpty() {
      EmployeeList = new Employee[arraySize];
      size = 0;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public boolean isFull() {
      return size == arraySize;
   }
   
   public Employee[] getList() {
      return Arrays.copyOf(EmployeeList, size);
   }

   
   public void push(Employee E) {
      if (!isFull()) {
         EmployeeList[size] = E;
         size++;
      } else {
         System.out.println("Stack is full, cannot push new Employee.");
      }
   }

   public Employee pop() {
      if (!isEmpty()) {
         Employee E = EmployeeList[size - 1];
         EmployeeList[size - 1] = null; 
         size--;
         return E;
      } else {
         System.out.println("Stack is empty, cannot pop.");
         return null;
      }
   }
   
   public Employee peekAt(int index) {
      if (index >= 0 && index < size) {
         return EmployeeList[index];
      }
      return null;
   }

   public Employee peek() {
      if (!isEmpty()) {
         return EmployeeList[size - 1];
      } else {
         System.out.println("Stack is empty, cannot peek.");
         return null;
      }
   }

   public int getSize() {
      return size;
   }

   public int searchByName(String name) {
      for (int i = size - 1; i >= 0; i--) {
         if (EmployeeList[i].getName().equals(name)) {
            return i; 
         }
      }
      return -1; 
   }

   public int searchByID(int id) {
      for (int i = size - 1; i >= 0; i--) {
         if (EmployeeList[i].getID() == id) {
            return i; 
         }
      }
      return -1; 
   }

   public boolean checkDuplicateID(int ID) {
      for (int i = 0; i < size; i++) {
         if (EmployeeList[i].getID() == ID) {
            return true; 
         }
      }
      return false; 
   }

   public String toString() {
      StringBuilder str = new StringBuilder();
      for (int i = size - 1; i >= 0; i--) {
         str.append(EmployeeList[i].toString()).append("\n\n");
      }
      return str.toString();
   }
}
