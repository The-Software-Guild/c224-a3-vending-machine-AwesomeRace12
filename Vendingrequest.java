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
public class Vendingrequest {
    public Items item;
    public Coincollect coininput;

    public Vendingrequest(int selectedProduct,int... coininput){
        this.item = Items.valueOf(selectedProduct);
        this.coininput = new Coincollect(coininput);
    }
}
