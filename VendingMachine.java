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
public interface VendingMachine {
    
    void displayItems();
    
    int getItem(int itemselected);
    
    void displaycoinsentered();
    
    void coinsentered(int... coin);
    
    void displaychange();
    
}
