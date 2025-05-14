package ems_group_k4_;

public class User 
{
   private int userID;
   private String firstName;
   private String lastName;
   private String userName; 
   String password;

   //String email;
   private String userType;
   
   public User() 
   {
      
   }// end of User.
   
   public User(String userName, String password) 
   {
       this.userName = userName;
       this.password = password;
   }// end of User.
      
   public User(int userID, String firstName, String lastName, String userName, String password, String userType) 
   {
       this.userID = userID;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userName = userName;
       this.password = password;
       this.userType = userType;
   }// end of User.

   public int getUserID() 
   {
   return userID; 
   }// end of getUserID.
 
   void setUserID(int userID)
   {
   this.userID = userID;
   }// end of setUserID.
   
   public String getFirstName() 
   {
   return firstName; 
   }// end of getFirstName.
 
   void setFirstName(String firstName)
   {
   this.firstName = firstName;
   }// end of setFirstName.
   
   public String getLastName() 
   {
   return lastName; 
   }// end of getLastName.
 
   void setLastName(String lastName)
   {
   this.lastName = lastName;
   }// end of setLasName.
   
   public String getUserName() 
   {
   return userName; 
   }// end of getUserName.
 
   void setUserName(String userName)
   {
   this.userName = userName;
   }// end of setUserName.
   
   public String getUserType() 
   {
   return userType; 
   }// end of getUserType.
 
   void setUserType(String userType)
   {
   this.userType = userType;
   }// end of setUserType.
   
    public String getPassword() 
    {
        return password;
    }// end of getPassword.

    public void setPassword(String password)
    {
        this.password = password;
    }// end of setPassword.    
}// end of User. 