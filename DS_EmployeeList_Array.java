package employee;

public class DS_EmployeeList_Array {
   
   final int arraySize=100;
   Employee EmployeeList[];
   int size;
   
   DS_EmployeeList_Array(){    
      makeEmpty();   
   }
   
   public boolean checkDuplicateID(int ID, Employee[] list){
      boolean result = true;
      for (int i = 0; i < list.length; i++){
         if (list[i] == null);
         else {
            if (list[i].getID() == ID) result = false;
         }
      }
      return result;
   }
   
   public void makeEmpty(){
      EmployeeList = new Employee[arraySize];
      size=0; 
   }

   public Employee getItem(int i){
      return EmployeeList[i];
   }
   
   public int getSize(){
      return size;}
   
   public Employee[] getList(){
      return EmployeeList;
   }

   public void setList(Employee[] list){
      this.EmployeeList = list;
   }
   
   public void addItem(Employee E){
      EmployeeList[size] = new Employee(E);
      size++;
   }
   
   public void addItem(int i, Employee E){
      if (size < arraySize){
         for (int j = arraySize-1; j > i-1; j--){
            if (EmployeeList[j-1] != null) EmployeeList[j] = EmployeeList[j-1];
         }
      }
      EmployeeList[i-1] = E;
      size++;
   }
   
   public int searchByIndex(int i){
      return i-1;
   }
   
   public int searchByName(String n){
      Employee temp;
      for (int i = 0; i < size; i++){
         temp = EmployeeList[i];
         if (temp.getName().equals(n)){
            return i;
         }
      }
      return -100;
   }
   
   public int searchByID(int id){
      Employee temp;
      for (int i = 0; i < size; i++){
         temp = EmployeeList[i];
         if (temp.getID() == id){
            return i;
         }
      }
      return 0;
   }
   
   public void remove(){
      EmployeeList[size-1] = null;
      size--;
   }
   
   public void removeByIndex(int i){
      EmployeeList[i-1] = null;
      for (int j = 0; j < size; j++){
         EmployeeList[j] = EmployeeList[j+1];
      }
      size--;
   }
   
   public void removeByName(String name) {
      for (int i = 0; i < size; i++) {
         if (EmployeeList[i].getName().equalsIgnoreCase(name)) {
            for (int j = i; j < size - 1; j++) {
               EmployeeList[j] = EmployeeList[j + 1];
            }
            EmployeeList[--size] = null; 
            break; 
         }
      }
   }
   
   public String toString(){
      String str="";
      
      for(int i=0; i< size; i++)
         str += EmployeeList[i].toString()+"\n\n";
      
      return str; 
   }
   
}
