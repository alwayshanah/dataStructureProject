package employee;

import java.util.ArrayList;

public class DS_EmployeeList_DoublyLinkedList {
   
   class Node {
      Employee employee;
      Node next;
      Node prev;
   
      public Node(Employee employee) {
         this.employee = employee;
         this.next = null;
         this.prev = null;
      }
   }

   private Node head;  
   private Node tail;  
   private int size;

   DS_EmployeeList_DoublyLinkedList() {
      makeEmpty();
   }

   public void makeEmpty() {
      head = null;
      tail = null;
      size = 0;
   }

   public Employee getItem(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Invalid index");
      }
   
      Node current = head;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current.employee;
   }
   
   public int getSize() {
      return size;
   }
   
   public ArrayList<Employee> getList() {
      ArrayList<Employee> list = new ArrayList<>();
      Node current = head;
      while (current != null) {
         list.add(current.employee); 
         current = current.next;
      }
      return list;  
   }

   public void addItem(Employee E) {
      Node newNode = new Node(E);
      if (head == null) {
         head = newNode;
         tail = newNode;
      } else {
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
      }
      size++;
   }

   public void addItem(int index, Employee E) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException("Invalid index");
      }
   
      Node newNode = new Node(E);
   
      if (index == 0) {
         if (head == null) {
            head = newNode;
            tail = newNode;
         } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
         }
      } else if (index == size) {
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
      } else {
         Node current = head;
         for (int i = 0; i < index; i++) {
            current = current.next;
         }
         newNode.next = current;
         newNode.prev = current.prev;
         current.prev.next = newNode;
         current.prev = newNode;
      }
      size++;
   }

   public int searchByName(String name) {
      Node current = head;
      int index = 0;
      while (current != null) {
         if (current.employee.getName().equals(name)) {
            return index;
         }
         current = current.next;
         index++;
      }
      return -1;  
   }

   public int searchByID(int id) {
      Node current = head;
      int index = 0;
      while (current != null) {
         if (current.employee.getID() == id) {
            return index;
         }
         current = current.next;
         index++;
      }
      return -1; 
   }

   public void remove() {
      if (tail == null) {
         return;  
      }
   
      if (tail == head) {
         head = null;
         tail = null;
      } else {
         tail = tail.prev;
         tail.next = null;
      }
      size--;
   }

   public void removeByIndex(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Invalid index");
      }
   
      if (index == 0) {
         if (head == tail) {
            head = null;
            tail = null;
         } else {
            head = head.next;
            head.prev = null;
         }
      } else if (index == size - 1) {
         tail = tail.prev;
         tail.next = null;
      } else {
         Node current = head;
         for (int i = 0; i < index; i++) {
            current = current.next;
         }
         current.prev.next = current.next;
         current.next.prev = current.prev;
      }
      size--;
   }
   
   public void removeByName(String name) {
      Node current = head;
      while (current != null) {
         if (current.employee.getName().equalsIgnoreCase(name)) {
            if (current.prev != null) {
               current.prev.next = current.next;
            } else {
               head = current.next; 
            }
            if (current.next != null) {
               current.next.prev = current.prev;
            }
            size--;
            break; 
         }
         current = current.next;
      }
   }
   
   public boolean checkDuplicateID(int ID) {
      Node current = head;
      while (current != null) {
         if (current.employee.getID() == ID) {
            return true;  
         }
         current = current.next;
      }
      return false;  
   }
   
   public String toString() {
      StringBuilder str = new StringBuilder();
      Node current = head;
      while (current != null) {
         str.append(current.employee.toString()).append("\n\n");
         current = current.next;
      }
      return str.toString();
   }
}
