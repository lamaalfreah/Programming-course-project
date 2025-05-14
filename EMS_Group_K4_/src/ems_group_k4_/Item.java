package ems_group_k4_;

public abstract class Item 
{
   private int itemID;
   private String itemName;
   private double price;
   
   public Item() 
   {
      
   }// end of Item.
   
   public Item(int itemID, String itemName) 
   {
        this.itemID = itemID;
        this.itemName = itemName;
   }// end of Item.
   
   public abstract String orderSummary(int quantity);
   
   public int getItemID() 
   {
   return itemID; 
   }// end of getItemID.
 
   void setItemID(int itemID)
   {
   this.itemID = itemID;
   }// end of setItemID.
   
   public String getItemName() 
   {
   return itemName; 
   }// end of getItemName.
 
   void setItemName(String itemName)
   {
   this.itemName = itemName;
   }// end of setItemName.
   
   public double getPrice() 
   {
   return price; 
   }// end of getPrice.
 
   void setPrice(double price)
   {
   this.price = price;
   }// end of setPrice.
}// end of Item. 