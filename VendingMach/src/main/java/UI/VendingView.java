/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
/**
 *
 * @author aakar
 */
public class VendingView {
    private UserIO io;
    
    public VendingView(UserIO io){
     this.io = io;   
    }
    
    public int printmenu(){
        io.print("Main menu");
        io.print("1. Enter the coins");
        io.print("2. Which item do you want to purchase");
        io.print("3. Exit");
        
        return io.readInt("Please select", 1, 3);
    }
    
    public int getPenny(){
       int penny = io.readInt("How many pennies");
       return penny;
    }
    
    public int getNickle(){
       int nickle = io.readInt("How many nickles");
       return nickle;
    }
    
    public int getDime(){
       int dime = io.readInt("How many dimes");
       return dime;
    }
    
    public int getQuarter(){
       int quarter = io.readInt("How many quarters");
       return quarter;
    }
      public void displayAddCoinBanner() {
        io.print("Adding coins");
    }
    public void displayAddCoinSuccessBanner() {
        io.readString( "Coins added successfully.  Please hit enter to continue");
    }
    public void displayTotal(BigDecimal total) {
        io.print("$" + total.toString());
        io.readString("Please hit enter to continue.");
    }

    public void displayChange(List<BigDecimal> total) {
        io.print("Quarters: " + total.get(0));
        io.print("Dimes: " + total.get(1));
        io.print("Nickels: " + total.get(2));
        io.print("Pennies: " + total.get(3));
        io.print("Your change is $" + total.get(4));
        io.readString("Please hit enter to continue.");
    }

    public void displayTotalBanner() {
        io.print("=== Display Money ===");
    }

    public void displayPurchaseBanner() {
        io.print("=== Buying Item ===");
    }

    public List<Item> displayItems(List<Item> itemList) {
        int counter = 1;

        List<Item> inStock = itemList.stream()
                .filter((item) -> (item.getAmount()) >= 1)
                .collect(Collectors.toList());
        for (Item currentItem : inStock) {
            String itemInfo = String.format("#" + counter + " %s : $%s",
                    currentItem.getItem(),
                    currentItem.getPrice());
            io.print(itemInfo);
            counter++;
        }
        return inStock;


    }

    public Item chooseItem(List<Item> list) {
        if(!list.isEmpty()) {
            int choice = io.readInt("Please select from the above choices according to it's number on the list.", 1, list.size());
            Item item = list.get(choice-1);
            return item;
        }
        else {
            return null;
        }
    }
    public void displayExit() {
        io.print("Good Bye");
    }
       public void displayAddSuccessBanner() {
        io.readString("Coins successfully added. Please hit enter to continue");
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("ERROR");
        io.print(errorMsg);
    }
    public void displayNotEnoughMoney() {
        io.print("=== NOT ENOUGH MONEY ===");
        io.print("=== Display Money ===");
    }
}
