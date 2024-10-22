import java.io.*;
import java.util.*;

public class EmployeeListHandler{
   File list;
   int lines;
   Employee employee;
   String[] array;
   Scanner s;
   
   public EmployeeListHandler(){
      list = new File("EmployeeList.txt");
      read();
      toArray();
      lines = array.length/4;
   }
   
   public Employee[] getEmployees(){
      int j = 0;
      Employee[] e = new Employee[lines];
      for (int i = 0; i < lines; i++){
         Employee node = new Employee(array[j], array[j+1], (byte)Integer.parseInt(array[j+2]), Integer.parseInt(array[j+3]));
         e[i] = node;
         j += 4;
      }
      return e;
   }
   
   public String[] getArray(){
      return array;
   }
   
   public int getLines(){
      return lines;
   }  
   
   public void toArray(){
      int n = 0;
      String fileContent = "";
      while (s.hasNextLine()) {
         fileContent += s.nextLine();
         n++;
      }
      array = fileContent.split(", ");
   }
   
   public Employee arrayToEmployee(String n, String p, byte i, int id){
      return employee = new Employee(n, p, i, id);
   }
   
   public void read(){
      try{
         s = new Scanner(list);
      }
      catch(FileNotFoundException e){
         System.out.println("No File Detected!");
      }
   }
   
   public String encode(Employee[] eList){
      String encoded = "";
      for (int i = 0; i < eList.length; i++){
         if (eList[i] == null) break;
         encoded += (eList[i].getName() + ", " + eList[i].getPosition() + ", " + eList[i].getAge() + ", " + eList[i].getID() + ", \n");
      }
      return encoded;
   }
   
   public void saveEmployees(Employee[] employeeList){ 
      try{
         FileWriter writer = new FileWriter("EmployeeList.txt");
         writer.write(encode(employeeList));
         writer.close();
         System.out.println("Saved Successfully");
      } catch (IOException e){
         System.out.println("An Error Has Occured.");
      }
      
   }
   
}