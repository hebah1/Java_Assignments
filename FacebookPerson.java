// This is the FacebookPerson_Graphics class
// Dr. Xiaolin Hu
// 03/05/2015
package Facebook;

public class FacebookPerson{
  
  private String myName;
  protected String myMood;
  protected Facebook myfacebook;
  
  public FacebookPerson(String name){
    myName = name;
    myfacebook = new Facebook(myName);
    //System.out.println("FacebookPerson's constructor");
  }
  
  public FacebookPerson(){
    
  }
  
  public String getName(){
    return myName;
  }
  
  public void setMood(String newMood){
    myMood = newMood;
    myfacebook.setContent(myMood);
  }
  
  public String getMood(){
    return myMood;
  }
  
}