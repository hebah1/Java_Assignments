public class Bankperson{
  private String firstname, lastname;
  private double balance;
  
  public Bankperson(){
    balance = 0.0;
  }
  public Bankperson(String f, String l, double n){
    firstname = f;
    lastname = l;
    balance = n;
  }
  public Bankperson(String f, String l){
    firstname = f;
    lastname = l;
  }
  public void setFirstName(String x){
    firstname = x;
  }
  public void setLastName(String x){
    lastname = x;
  }
  public void setBalance(double x){
    balance = x;
  }
  public double getBalance(){
    return balance;
  }
  public String getLastName(){
    return lastname;
  }
  public String getFirstName(){
    return firstname;
  }
  public void withdraw(double x){
    if(x >= balance){
      balance += x;
    } else{
        System.out.println("Insufficent Funds");  
    }
  }
  public void deposit(int x){
  balance +=x;
  }
}