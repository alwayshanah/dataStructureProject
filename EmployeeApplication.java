package employee;\

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class EmployeeApplication {

   public static void main(String args[]) {
      EmployeeListHandler handler = new EmployeeListHandler();
      Employee[] employees = handler.getEmployees();
      int lines = handler.getLines();

      DS_EmployeeList_Array arrayList = new DS_EmployeeList_Array();
      DS_EmployeeList_DoublyLinkedList doublyLinkedList = new DS_EmployeeList_DoublyLinkedList();
      DS_EmployeeStack_Array stackArray = new DS_EmployeeStack_Array();
      DS_EmployeeStack_LinkedList stackLinkedList = new DS_EmployeeStack_LinkedList();
      DS_EmployeeQueue_Array queueArray = new DS_EmployeeQueue_Array();
      DS_EmployeeQueue_LinkedList queueLinkedList = new DS_EmployeeQueue_LinkedList();
      ArrayList<Employee> javaArrayList = new ArrayList<>();
      LinkedList<Employee> javaLinkedList = new LinkedList<>();
      Stack<Employee> javaStack = new Stack<>();
      Queue<Employee> javaQueue = new LinkedList<>();

      for (Employee emp : employees) {
         arrayList.addItem(emp);
         doublyLinkedList.addItem(emp);
         stackArray.push(emp);
         stackLinkedList.push(emp);
         queueArray.enqueue(emp);
         queueLinkedList.enqueue(emp);
         javaArrayList.add(emp);
         javaLinkedList.add(emp);
         javaStack.push(emp);
         javaQueue.offer(emp);
      }
      
      JOptionPane.showMessageDialog(null, "Data Loaded", "Loading Data...", JOptionPane.INFORMATION_MESSAGE);
      
      int running = 1;
   
      while (running == 1) {
         String dataStructureChoice = JOptionPane.showInputDialog("Choose Data Structure:\n" +
                "[1] Array\n[2] Doubly Linked List\n[3] Stack (Array)\n[4] Stack (LinkedList)\n" +
                "[5] Queue (Array)\n[6] Queue (LinkedList)\n[7] ArrayList\n[8] LinkedList\n" +
                "[9] Stack (built-in)\n[10] Queue (built-in)\n[11] Quit");
         int choice = Integer.parseInt(dataStructureChoice);
      
         switch (choice) {
            case 1:
               performOperations(arrayList, handler);
               break;
            case 2:
               performOperations(doublyLinkedList, handler);
               break;
            case 3:
               performOperations(stackArray, handler);
               break;
            case 4:
               performOperations(stackLinkedList, handler);
               break;
            case 5:
               performOperations(queueArray, handler);
               break;
            case 6:
               performOperations(queueLinkedList, handler);
               break;
            case 7:
               performOperations(javaArrayList, handler);
               break;
            case 8:
               performOperations(javaLinkedList, handler);
               break;
            case 9:
               performOperations(javaStack, handler);
               break;
            case 10:
               performOperations(javaQueue, handler);
               break;
            case 11:
               running = 0;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Invalid choice! Please select again.");
         }
      }
   }

   private static void performOperations(Object dataStructure, EmployeeListHandler handler) {
      int running = 1;
   
      while (running == 1) {
         String operationChoice = JOptionPane.showInputDialog("Choose Operation:\n" +
                "[1] Show List\n[2] Add Employee\n[3] Search Employee\n[4] Remove Employee\n[5] Save and Quit");
         int choice = Integer.parseInt(operationChoice);
      
         switch (choice) {
            case 1:
               showList(dataStructure);
               break;
            case 2:
               addEmployee(dataStructure);
               break;
            case 3:
               searchEmployee(dataStructure);
               break;
            case 4:
               removeEmployee(dataStructure);
               break;
            case 5:
               handler.saveEmployees(getEmployeesFromDataStructure(dataStructure));
               running = 0;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Invalid choice! Please select again.");
         }
      }
   }

   private static void showList(Object dataStructure) {
      StringBuilder result = new StringBuilder();
   
      if (dataStructure instanceof DS_EmployeeList_Array) {
         DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
         for (int i = 0; i < list.getSize(); i++) {
            result.append(list.getList()[i].toString()).append("\n\n");
         }
      } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
         DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
         ArrayList<Employee> arrList = list.getList();
         Employee[] empArray = new Employee[list.getSize()];
         arrList.toArray(empArray);
         for (Employee emp : empArray) {
            if (emp != null) {
               result.append(emp.toString()).append("\n\n");
            }
         }
      } else if (dataStructure instanceof DS_EmployeeStack_Array) {
         DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
         for (int i = 0; i < stack.getSize(); i++) {
            result.append(stack.peekAt(i).toString()).append("\n\n");
         }
      } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
         DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
         Employee[] empArray = stack.getList();
         for (Employee emp : empArray) {
            if (emp != null) {
               result.append(emp.toString()).append("\n\n");
            }
         }
      } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
         DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
         for (int i = 0; i < queue.getSize(); i++) {
            result.append(queue.peekAt(i).toString()).append("\n\n");
         }
      } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
         DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
         Employee[] empArray = new Employee[queue.getSize()];
         queue.getList().toArray();
         for (Employee emp : empArray) {
            if (emp != null) {
               result.append(emp.toString()).append("\n\n");
            }
         }
      } else if (dataStructure instanceof ArrayList) {
         ArrayList<Employee> list = (ArrayList<Employee>) dataStructure;
         for (Employee emp : list) {
            result.append(emp.toString()).append("\n\n");
         }
      } else if (dataStructure instanceof LinkedList) {
         LinkedList<Employee> list = (LinkedList<Employee>) dataStructure;
         for (Employee emp : list) {
            result.append(emp.toString()).append("\n\n");
         }
      } else if (dataStructure instanceof Stack) {
         Stack<Employee> stack = (Stack<Employee>) dataStructure;
         for (Employee emp : stack) {
            result.append(emp.toString()).append("\n\n");
         }
      } else if (dataStructure instanceof Queue) {
         Queue<Employee> queue = (Queue<Employee>) dataStructure;
         for (Employee emp : queue) {
            result.append(emp.toString()).append("\n\n");
         }
      }
   
      JTextArea textArea = new JTextArea(result.toString());
      JScrollPane scrollPane = new JScrollPane(textArea);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      scrollPane.setPreferredSize(new Dimension(500, 500));
      JOptionPane.showMessageDialog(null, scrollPane, "List Of Employees", JOptionPane.INFORMATION_MESSAGE);
   }

   private static void addEmployee(Object dataStructure) {
      String name = JOptionPane.showInputDialog("Enter name:");
      String position = JOptionPane.showInputDialog("Enter position:");
      byte age = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
      int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
    
      Employee newEmployee = new Employee(name, position, age, id);
   
      if (dataStructure instanceof DS_EmployeeList_Array) {
         DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
         list.addItem(newEmployee);
      } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
         DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
         list.addItem(newEmployee);
      } else if (dataStructure instanceof DS_EmployeeStack_Array) {
         DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
         stack.push(newEmployee);
      } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
         DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
         stack.push(newEmployee);
      } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
         DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
         queue.enqueue(newEmployee);
      } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
         DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
         queue.enqueue(newEmployee);
      } else if (dataStructure instanceof ArrayList) {
         ArrayList<Employee> list = (ArrayList<Employee>) dataStructure;
         list.add(newEmployee);
      } else if (dataStructure instanceof LinkedList) {
         LinkedList<Employee> list = (LinkedList<Employee>) dataStructure;
         list.add(newEmployee);
      } else if (dataStructure instanceof Stack) {
         Stack<Employee> stack = (Stack<Employee>) dataStructure;
         stack.push(newEmployee);
      } else if (dataStructure instanceof Queue) {
         Queue<Employee> queue = (Queue<Employee>) dataStructure;
         queue.offer(newEmployee);
      }
   }

   private static void searchEmployee(Object dataStructure) {
      String searchCriteria = JOptionPane.showInputDialog("Search by:\n[1] Name\n[2] ID");
      int choice = Integer.parseInt(searchCriteria);
   
      if (choice == 1) {
         String name = JOptionPane.showInputDialog("Enter name to search:");
         boolean found = false;
      
         if (dataStructure instanceof DS_EmployeeList_Array) {
            DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
            for (int i = 0; i < list.getSize(); i++) {
               if (list.getList()[i].getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, list.getList()[i].toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
            DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
            for (Employee emp : list.getList()) {
               if (emp.getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeStack_Array) {
            DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
            for (int i = 0; i < stack.getSize(); i++) {
               if (stack.getList()[i].getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, stack.getList()[i].toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
            DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
            for (Employee emp : stack.getList()) {
               if (emp.getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
            DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
            for (int i = 0; i < queue.getSize(); i++) {
               if (queue.getList()[i].getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, queue.getList()[i].toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
            DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
            for (Employee emp : queue.getList()) {
               if (emp.getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof ArrayList) {
            ArrayList<Employee> list = (ArrayList<Employee>) dataStructure;
            Employee[] arrList = new Employee[list.size()];
            list.toArray(arrList);
            for (Employee emp : arrList) {
               if (emp.getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof Queue) {
            Queue queue = (Queue) dataStructure;
            Employee[] arrList = new Employee[queue.size()];
            queue.toArray(arrList);
            for (Employee emp : arrList) {
               if (emp.getName().equalsIgnoreCase(name)) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         }
      
         if (!found) {
            JOptionPane.showMessageDialog(null, "Employee not found.");
         }
      
      } else if (choice == 2) {
         int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search:"));
         boolean found = false;
      
         if (dataStructure instanceof DS_EmployeeList_Array) {
            DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
            for (int i = 0; i < list.getSize(); i++) {
               if (list.getList()[i].getID() == id) {
                  JOptionPane.showMessageDialog(null, list.getList()[i].toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
            DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
            for (Employee emp : list.getList()) {
               if (emp.getID() == id) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeStack_Array) {
            DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
            for (int i = 0; i < stack.getSize(); i++) {
               if (stack.getList()[i].getID() == id) {
                  JOptionPane.showMessageDialog(null, stack.getList()[i].toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
            DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
            for (Employee emp : stack.getList()) {
               if (emp.getID() == id) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
            DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
            for (int i = 0; i < queue.getSize(); i++) {
               if (queue.getList()[i].getID() == id) {
                  JOptionPane.showMessageDialog(null, queue.getList()[i].toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
            DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
            for (Employee emp : queue.getList()) {
               if (emp.getID() == id) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof ArrayList) {
            ArrayList list = (ArrayList) dataStructure;
            Employee[] arrList = new Employee[list.size()];
            list.toArray(arrList);
            for (Employee emp : arrList) {
               if (emp.getID() == id) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         } else if (dataStructure instanceof Queue) {
            Queue queue = (Queue) dataStructure;
            Employee[] arrList = new Employee[queue.size()];
            queue.toArray(arrList);
            for (Employee emp : arrList) {
               if (emp.getID() == id) {
                  JOptionPane.showMessageDialog(null, emp.toString());
                  found = true;
               }
            }
         }
      
         if (!found) {
            JOptionPane.showMessageDialog(null, "Employee not found.");
         }
      }
   }

   private static void removeEmployee(Object dataStructure) {
      String removeCriteria = JOptionPane.showInputDialog("Remove by:\n[1] Index\n[2] Name");
      int choice = Integer.parseInt(removeCriteria);
   
      if (choice == 1) {
         int index = Integer.parseInt(JOptionPane.showInputDialog("Enter index to remove:"));
         if (dataStructure instanceof DS_EmployeeList_Array) {
            DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
            list.removeByIndex(index);
         } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
            DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
            list.removeByIndex(index);
         } else if (dataStructure instanceof DS_EmployeeStack_Array) {
            DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
            stack.pop();
         } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
            DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
            stack.pop();
         } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
            DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
            queue.dequeue();
         } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
            DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
            queue.removeByIndex(index);
         } else if (dataStructure instanceof ArrayList) {
            ArrayList list = (ArrayList) dataStructure;
            list.remove(index);
         } else if (dataStructure instanceof Queue) {
            Queue queue = (Queue) dataStructure;
            queue.remove();
         }
      
         JOptionPane.showMessageDialog(null, "Employee removed successfully.");
      } else if (choice == 2) {
         String name = JOptionPane.showInputDialog("Enter name to remove:");
         boolean found = false;
      
         if (dataStructure instanceof DS_EmployeeList_Array) {
            DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
            int indexToRemove = list.searchByName(name);
            if (indexToRemove != -1) {
               list.removeByIndex(indexToRemove);
               found = true;
            }
         } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
            DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
            int indexToRemove = list.searchByName(name);
            if (indexToRemove != -1) {
               list.removeByIndex(indexToRemove);
               found = true;
            }
         } else if (dataStructure instanceof DS_EmployeeStack_Array) {
            DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
            stack.pop();
         } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
            DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
            stack.pop();
         } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
            DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
            queue.dequeue();
         } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
            DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
            queue.remove();
         } else if (dataStructure instanceof ArrayList) {
            ArrayList list = (ArrayList) dataStructure;
            list.remove(0);
         } else if (dataStructure instanceof Queue) {
            Queue queue = (Queue) dataStructure;
            queue.remove();
         }
      
         if (found) {
            JOptionPane.showMessageDialog(null, "Employee removed successfully.");
         } else {
            JOptionPane.showMessageDialog(null, "Employee not found.");
         }
      }
   }


   private static Employee[] getEmployeesFromDataStructure(Object dataStructure) {
      if (dataStructure instanceof DS_EmployeeList_Array) {
         DS_EmployeeList_Array list = (DS_EmployeeList_Array) dataStructure;
         return list.getList();
      } else if (dataStructure instanceof DS_EmployeeList_DoublyLinkedList) {
         DS_EmployeeList_DoublyLinkedList list = (DS_EmployeeList_DoublyLinkedList) dataStructure;
         return list.getList().toArray(new Employee[0]);
      } else if (dataStructure instanceof DS_EmployeeStack_Array) {
         DS_EmployeeStack_Array stack = (DS_EmployeeStack_Array) dataStructure;
         return stack.getList();
      } else if (dataStructure instanceof DS_EmployeeStack_LinkedList) {
         DS_EmployeeStack_LinkedList stack = (DS_EmployeeStack_LinkedList) dataStructure;
         return stack.getList();
      } else if (dataStructure instanceof DS_EmployeeQueue_Array) {
         DS_EmployeeQueue_Array queue = (DS_EmployeeQueue_Array) dataStructure;
         return queue.getList();
      } else if (dataStructure instanceof DS_EmployeeQueue_LinkedList) {
         DS_EmployeeQueue_LinkedList queue = (DS_EmployeeQueue_LinkedList) dataStructure;
         return queue.getList().toArray(new Employee[0]);
      } else if (dataStructure instanceof ArrayList) {
         ArrayList<Employee> list = (ArrayList<Employee>) dataStructure;
         return list.toArray(new Employee[0]);
      } else if (dataStructure instanceof LinkedList) {
         LinkedList<Employee> list = (LinkedList<Employee>) dataStructure;
         return list.toArray(new Employee[0]);
      } else if (dataStructure instanceof Stack) {
         Stack<Employee> stack = (Stack<Employee>) dataStructure;
         return stack.toArray(new Employee[0]);
      } else if (dataStructure instanceof Queue) {
         Queue<Employee> queue = (Queue<Employee>) dataStructure;
         return queue.toArray(new Employee[0]);
      }
   
      return new Employee[0]; 
   }
}
