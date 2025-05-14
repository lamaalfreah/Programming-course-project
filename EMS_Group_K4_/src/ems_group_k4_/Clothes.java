package ems_group_k4_;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Clothes extends Item
{
 private String color;
 private String department;
 private String size; 

public Clothes() 
{
}// end of Clothes.

public Clothes( int itemID, String itemName, String color, String department, String size) 
{
 super(itemID, itemName);
 this.color = color;
 this.department = department;
 this.size = size;
}// end of Clothes.

 public String getColor() 
{
 return color;
}// end of getColor.

public void setColor(String color) 
{
 this.color = color;
}// end of setColor.

public String getDepartment() 
{
 return department;
}// end of getDepartment.

public void setDepartment(String department) 
{
this.department = department;
}// end of setDepartment.

public String getSize() 
{
return size;
}// end of getSize.

public void setSize(String size) 
{
 this.size = size;
}// end of setSize.

public void displayFile() throws Exception
{
 File file = new File("clothes.txt");   
 System.out.println("Items from clothes.txt: ");     
 Scanner input=new Scanner(file);
 String firstLine=input.nextLine();
 System.out.println(firstLine);
 input.useDelimiter("(\\p{javaWhitespace}|,)+");
 while(input.hasNext())
 {
 setItemID(input.nextInt());
 setItemName(input.useDelimiter("(,)+").next());
 input.useDelimiter("(\\p{javaWhitespace}|,)+");
 color=input.next();
 department=input.next();
 size=input.next();
 setPrice(input.nextInt());
 System.out.println(getItemID()+","+getItemName()+","+color+","+department+","+size+","+getPrice());
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
File file = new File("clothes.txt");   
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
File file=new File("clothes.txt");
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
File file = new File("clothes.txt"); 
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
}// end of Clothes. 