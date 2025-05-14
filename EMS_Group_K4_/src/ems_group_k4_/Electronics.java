package ems_group_k4_;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Electronics extends Item 
{
 private String brand;
 private String model;
 private int year;  
    
public Electronics()
{
        
}// end of Electronics.

public Electronics(int itemID,String itemName,String brand, String model, int year) 
{
 super(itemID,itemName);
 this.brand = brand;
 this.model = model;
 this.year = year;
}// end of Electronics.
   
public String getBrand() 
{
 return brand;
}// end of getBrand.

public void setBrand(String brand) 
{
 this.brand = brand;
}// end of setBrand.

public String getModel() 
{
 return model;
}// end of getModel.

public void setModel(String model) 
{
 this.model = model;
}// end of setModel.

public int getYear() 
{
 return year;
}// end of getYear.

public void setYear(int year) 
{
 this.year = year;
}// end of setYear.

public void displayFile() throws Exception
{
 File file = new File("electronics.txt") ;   
 System.out.println("Items from electronics.txt: ");
 Scanner input=new Scanner(file);
 String firstLine=input.nextLine();
 System.out.println(firstLine);
  
 input.useDelimiter("(\\p{javaWhitespace}|,)+");
 while(input.hasNext())
 {
   setItemID(input.nextInt());
   setItemName(input.useDelimiter("(,)+").next());
   input.useDelimiter("(\\p{javaWhitespace}|,)+");
   brand=input.next();
   model=input.next();
   year=input.nextInt();
   setPrice(input.nextInt());
   System.out.println(getItemID()+","+getItemName()+","+brand+","+model+","+year+","+getPrice());
  }// end of while.
 input.close();     
}// end of displayFile. 

@Override
public String orderSummary(int quantity)
{
 return "Purchased item:"+ getItemID()+ ",QTY="+ quantity+",Total price="+(getPrice()*quantity);
}// end of orderSummary. 

public static boolean match(String itemId) throws Exception
{
File file = new File("electronics.txt");   
Scanner input=new Scanner(file);
String firstLine=input.nextLine();
String str=null;
boolean found=false;
while(input.hasNext())
{
 str=input.nextLine().substring(0, 4);
 if(str.equals(itemId))
 {
 found=true;       
 }// end of if.
}// end of while.
input.close();
return found;
}// end of match.
    
public static void deleteItem(String lineToRemove) throws Exception
{
File file=new File("electronics.txt");
File newfile=new File("temp.txt");
Scanner input=new Scanner(file);
PrintWriter pw=new PrintWriter("temp.txt");
String newFileContentes;
while(input.hasNextLine())
{
  newFileContentes=input.nextLine();
  if(lineToRemove.matches(newFileContentes))
  {
  }// end of if. 
  else
  {
  pw.println(newFileContentes);
  }// end of else. 
}// end of while.
input.close();
pw.close();
file.delete();
newfile.renameTo(file);
}// end of deleteItem.
       
public static String findingPrice(String itemId)throws IOException{
File file = new File("electronics.txt"); 
String numPrice=null;
String str;
Scanner input=new Scanner(file);
while(input.hasNext())
{
  str=input.nextLine();
  String strId=str.substring(0, 4);
  if(strId.equals(itemId))
  {
  int index=str.lastIndexOf(",");
  numPrice=str.substring(index+1);
  }// end of if.    
}// end of while.
  input.close();
  return numPrice;
}// end of findingPrice.
}// end of Electronics. 
