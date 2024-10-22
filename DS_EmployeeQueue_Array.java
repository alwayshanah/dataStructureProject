import java.util.Arrays;
public class DS_EmployeeQueue_Array {
   
   final int arraySize = 100;
   Employee[] employeeQueue;
   int front, rear, size;

   public DS_EmployeeQueue_Array() {
      makeEmpty();   
   }

   public void makeEmpty() {
      employeeQueue = new Employee[arraySize];
      front = 0;
      rear = -1;
      size = 0;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public boolean isFull() {
      return size == arraySize;
   }
   
   public Employee[] getList() {
      return Arrays.copyOf(employeeQueue, size);
   }
   
   public void enqueue(Employee E) {
      if (!isFull()) {
         rear = (rear + 1) % arraySize;  
         employeeQueue[rear] = E;
         size++;
      } else {
         System.out.println("Queue is full, cannot enqueue.");
      }
   }

   public Employee dequeue() {
      if (!isEmpty()) {
         Employee temp = employeeQueue[front];
         front = (front + 1) % arraySize;  
         size--;
         return temp;
      } else {
         System.out.println("Queue is empty, cannot dequeue.");
         return null;
      }
   }

   public Employee peek() {
      if (!isEmpty()) {
         return employeeQueue[front];
      } else {
         System.out.println("Queue is empty, cannot peek.");
         return null;
      }
   }
   
   public Employee peekAt(int index) {
      if (index >= 0 && index < size) {
         return employeeQueue[(front + index) % employeeQueue.length];
      }
      return null; 
   }
   
   public int getSize() {
      return size;
   }

   public int searchByName(String name) {
      for (int i = 0; i < size; i++) {
         int index = (front + i) % arraySize; 
         if (employeeQueue[index].getName().equals(name)) {
            return index;
         }
      }
      return -1;
   }

   public int searchByID(int id) {
      for (int i = 0; i < size; i++) {
         int index = (front + i) % arraySize;  
         if (employeeQueue[index].getID() == id) {
            return index;
         }
      }
      return -1; 
   }

   public boolean checkDuplicateID(int ID) {
      for (int i = 0; i < size; i++) {
         int index = (front + i) % arraySize;
         if (employeeQueue[index].getID() == ID) {
            return true; 
         }
      }
      return false; 
   }

   public String toString() {
      StringBuilder str = new StringBuilder();
      for (int i = 0; i < size; i++) {
         int index = (front + i) % arraySize;  
         str.append(employeeQueue[index].toString()).append("\n\n");
      }
      return str.toString();
   }
}
