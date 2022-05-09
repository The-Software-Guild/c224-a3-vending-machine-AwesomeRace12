/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author aakar
 */
public class VendingDisplay implements VendingMachine{
      private Vendingcontroller controller = new Vendingcontrollerextend();
    private int itemselected;
    private Coincollect change;
    
    public void displayItems(){
        System.out.println("Welcome to the vending machine");
        System.out.println("Itemss available: ");
        for(Items item: Items.values()){
            if(!Items.EMPTY.equals(item)) {
                System.out.println("     " + item.getselnum() + "  " + item.name() + " - Price: " + item.getprice() + "   ");
            }
        }
        System.out.println(" Please select your item: ");
    }
    
    
    public int getItem(int itemselected){
       return this.itemselected = itemselected;
    }
    
    public void displaycoinsentered(){
        System.out.println("Enter the coins");
        System.out.println("#1cent, #5cent, #10cent, #25cent, and #50cent");
        
    }  
    
    public void coinsentered(int... coins){
        Vendingrequest request = new Vendingrequest(itemselected, coins);
        change = controller.calculateChange(request);
    }
    public void displaychange(){
        System.out.println("Your change is :"+ change.gettotal()+ " as follows: ");
        System.out.println("    1 cents coins: "+ change.num1cent);
        System.out.println("    5cents coins: "+ change.num5cent);
        System.out.println("    10cents coins: "+ change.num10cent);
        System.out.println("    25 cents coins: "+ change.num25cent);
        System.out.println("    50 cents coins: "+ change.num50cent);
    }
}
