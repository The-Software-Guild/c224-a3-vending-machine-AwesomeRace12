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
public class Coincollect {
       public int num1cent;
    public int num5cent;
    public int num10cent;
    public int num25cent;
    public int num50cent;
    
    public Coincollect(int... coininput){
        this.num1cent = coininput[0];
        this.num5cent = coininput[1];
        this.num10cent = coininput[2];
        this.num25cent = coininput[3];
        this.num50cent = coininput[4];
    }
    
    public int gettotal(){
        int total=0;
        total = total + this.num1cent*Coins.PENNY.getdenom();
        total = total + this.num5cent*Coins.NICKLE.getdenom();
        total = total + this.num10cent*Coins.DIME.getdenom();
        total = total + this.num25cent*Coins.QUARTER.getdenom();
        total = total + this.num50cent*Coins.HALFDOLLAR.getdenom();
        return total;
    }
}
