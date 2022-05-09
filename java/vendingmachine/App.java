/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author aakar
 */
public class App {
    public static void main(String[] args) {
       /*
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
        */
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
     VendingMachine machine = ctx.getBean("VendingMachine", VendingDisplay.class);
     Scanner input = new Scanner(System.in);
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
