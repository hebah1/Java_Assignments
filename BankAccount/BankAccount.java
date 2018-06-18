/* 1, The puropse of this program is to create a bank and become fimilar with 
 * LinkedList.
 * 2. To solve this problem I created a Customer Object. The class consist of 9 
 * method and the main method. Each method calls the menu method which displays the
 * the Bank's menu. Each method is self explanatory. To get the current account, I created
 * a int that stores the last index of the linkedlist as default. When the user wants to 
 * changing the current record, it'll first search for then first and last name of the account
 * they want, save the index and store it as the current record.
 * 3. LinkedList Data Structure 
 * 4. The Expected input if the first and last name of the customer and balance.
 * User input.
 * 5.The purpose of this class to add customers(objects) into the Bank(linkedlist) 
    and change various elements of the customer base on user input. 
*/
        import java.util.LinkedList;
        import java.util.*;
        import java.lang.*;
        public class BankAccount {
            public static void main(String[] args) {    
            int current = 0;

            LinkedList<Customer> bank = new LinkedList<Customer>();

            menu(bank, current);

          }
           // Takes in the LinkedList and the current customer
          public static void menu(LinkedList bank, int current){
            String input;
            System.out.println("a\tShow all records"+
                               "\nr\tRemove the current record"+
                               "\nf\tChange the first name in the current record"+
                               "\nl\tChange the last name in the current record"+
                               "\nn\tAdd a new record"+
                               "\nd\tAdd a deposit to the current record"+
                               "\nw\tMake a withdrawal from the current record"+
                               "\nq\tQuit"+
                               "\ns\tSelect a record from the record list to become the current record"
                              );
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();        
            input = input.toLowerCase();
            
            for(int i = 0; i<input.length(); i++){ 
              switch(input.charAt(i)){
               case'a':
                  display(bank,current);
                  break;
               case'r':
                  remove(bank,current);
                  break;
                case'f':
                  changeFirst(bank,current);
                  break;
                case'l':
                  changeLast(bank,current);
                  break;
                case'n':
                 newRecord(bank,current);
                  break;
                case'd':
                  makeDeposit(bank,current);
                  break;
                case'w':
                  withdrawl(bank,current);
                  break;
                case'q':
                  System.out.println("GoodBye");
                  System.exit(0);
                case's':
                  select(bank,current);
                  break;
                default:
                  System.out.println("Not a valid input. Try again");
                  menu(bank,current);
                  break;
              }
           }
                    
          }
          // Takes in the LinkedList and the current customer 
          public static void newRecord(LinkedList bank, int current){
          String n = "Person has been added";
          String f;
          String l;

          System.out.println("Enter First name");
          Scanner sc = new Scanner(System.in);
          f = sc.nextLine();

          System.out.println("Enter Last name");
          l = sc.nextLine();

          bank.add(new Customer(f,l));
          System.out.println(n);
          
          current = bank.size()-1;
          Customer c = new Customer();
          c = (Customer) bank.get(bank.size()-1);
          
          menu(bank,current);
          }
           // Takes in the LinkedList and the current customer
          public static void makeDeposit(LinkedList bank, int current){
              System.out.println("Enter the deposited amount: ");
              Scanner sc = new Scanner(System.in);
              int amount = sc.nextInt();
              
              Customer d = new Customer();
              d = (Customer) bank.get(current);
              d.deposit(amount);
              
              menu(bank,current);
          }
           // Takes in the LinkedList and the current customer. Displays elements in order. 
          public static void display(LinkedList bank, int current){
              Object temp;
          //Sorts the elements
          for (int i = 0; i < bank.size(); i++){
            for (int j = i + 1; j < bank.size(); j++){
                        Customer cm = new Customer();
                        Customer cm2 = new Customer();
                        cm = (Customer) bank.get(i); 
                        cm2 = (Customer) bank.get(j);
                if (cm.getLastName().compareTo(cm2.getLastName())>0){
                    temp = bank.get(i);
                    bank.set(i,bank.get(j));
                    bank.set(j, temp);
                }
            }
          }  
              //Prints the elements
              System.out.println("First Name\tLast Name\tBalance");
              System.out.println("_____________________________________________________");
              for(int i =0; i < bank.size(); i++){
                  System.out.println(bank.get(i));
              }
              menu(bank, current);
          }  
           // Takes in the LinkedList and the current customer
        private static void changeLast(LinkedList bank, int current) {
             Customer c = new Customer();
             c = (Customer) bank.get(current);
             
                System.out.println("Current Record: "+c.getFirstName()+" "+c.getLastName());
                System.out.println("Enter last name to change: ");
                Scanner sc = new Scanner(System.in);
                String change = sc.nextLine();
                c.setLastName(change);
                System.out.println("Name has been changed to "+c.getFirstName()+" "+c.getLastName());
                menu(bank,current);
            }
         // Takes in the LinkedList and the current customer
      private static void select(LinkedList bank, int current) {
       System.out.println("Enter First Name: ");
       Scanner sc = new Scanner(System.in);
       String first = sc.nextLine();
       
       System.out.println("Enter Last Name: ");
       String last = sc.nextLine();
       
       Customer c2 = new Customer(first,last);
       
      int r;
      for(int i = 0; i<bank.size(); i++){
       Customer c1 = (Customer) bank.get(i);
       if(c1.getFirstName().equals(c2.getFirstName())){
           if(c1.getFirstName().equals(c2.getFirstName())){
           r=i;
           current = i;
           System.out.println("Current record has been changed to "+c2.getFirstName()+" "+c2.getLastName());
           } else{
             //  System.out.println("Doesn't Exist");
           }
       }else{
       //System.out.println("Doesn't Exist");
       }
      }

       menu(bank,current);
       }
       // Takes in the LinkedList and the current customer
    private static void changeFirst(LinkedList bank, int current){
             Customer c = new Customer();
             c = (Customer) bank.get(current);
             
                System.out.println("Current Record: "+c.getFirstName()+" "+c.getLastName());
                System.out.println("Enter First name to change: ");
                Scanner sc = new Scanner(System.in);
                String change = sc.nextLine();
                
                c.setFirstName(change);
                System.out.println("Name has been changed");
                menu(bank, current);
    }
     // Takes in the LinkedList and the current customer
    private static void withdrawl(LinkedList bank, int current) {          
              System.out.println("Enter amount to withdrawl: ");
              Scanner sc = new Scanner(System.in);
              int amount = sc.nextInt();
              
              Customer c = new Customer();
              c = (Customer) bank.get(current);
         
              c.withdraw(amount);
              menu(bank,current);     
    }
    
        // Takes in the LinkedList and the current customer
       private static void remove(LinkedList bank, int current) {
           Customer c = new Customer();
           c = (Customer) bank.get(current);
           
           System.out.println("Deleted: "+c.getFirstName()+" "+c.getLastName());
           bank.remove(current);
           menu(bank,current);
        }
                }
