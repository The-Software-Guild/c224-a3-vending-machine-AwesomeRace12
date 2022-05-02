/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import vendingmachine.VendingMachine;
import vendingmachine.VendingDisplay;
import java.util.*;

/**
 *
 * @author aakar
 */
public class App {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       VendingMachine machine = new VendingDisplay();
       
       machine.displayItems();

        String selectedItem = input.nextLine();
        machine.getItem(Integer.parseInt(selectedItem));

        machine.displaycoinsentered();

        String userEnteredCoins = input.nextLine();
        int[] enteredCoins = Coins.parseCoins(userEnteredCoins);
        machine.coinsentered(enteredCoins);
        machine.displaychange();
    }
}
