/* This class creates the customer object, which consist of a first name, last name
and balance.
*/ 

public class Customer {
    
 private String firstname, lastname;
  private double balance;
  
  public Customer(){
    balance = 0.0;
  }
  public Customer(String f, String l, double n){
    firstname = f;
    lastname = l;
    balance = n;
  }
  public Customer(String f, String l){
    firstname = f;
    lastname = l;
  }
  //Sets the first name
  public void setFirstName(String x){
    firstname = x;
  }
  // Sets the last name
  public void setLastName(String x){
    lastname = x;
  }
  //Sets the balance
  public void setBalance(double x){
    balance = x;
  }
  //Gets the balance
  public double getBalance(){
    return balance;
  }
  //Gets the last name
  public String getLastName(){
    return lastname;
  }
  //Gets the first name
  public String getFirstName(){
    return firstname;
  }
  //Withdraw x amount from balance
  public void withdraw(double x){

      if(x>balance){
          System.out.println("Insufficent Funds");
      }else{
          balance -= x;
          System.out.println(x+"amount has been withdrawn from "+firstname+" "+lastname);
      }  
    
  }
  //Deposit x amount into the balance
  public void deposit(double x){
  balance +=x;
  System.out.println(x+"amount has been deposited to "+firstname+" "+lastname);
  }
  //Prints out a string
  public String toString(){
      return firstname+"\t\t"+lastname+"\t\t"+balance;
  }
}