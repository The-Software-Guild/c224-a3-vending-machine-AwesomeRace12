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
public class CalcExtend implements Calculate {
           public int calculateTot(Coincollect coininput){
        return coininput.gettotal();
    }
    
    public Coincollect calculateChange(int amountMoneyToReturn) {
        Coincollect change = new Coincollect(new int[5]);
        int remainingAmount = amountMoneyToReturn;
        change.num1cent = remainingAmount / Coins.PENNY.getdenom();
        remainingAmount = remainingAmount % Coins.PENNY.getdenom();

        change.num5cent = remainingAmount / Coins.NICKLE.getdenom();
        remainingAmount = remainingAmount % Coins.NICKLE.getdenom();

        change.num10cent = remainingAmount / Coins.DIME.getdenom();
        remainingAmount = remainingAmount % Coins.DIME.getdenom();

        change.num25cent = remainingAmount / Coins.QUARTER.getdenom();
        remainingAmount = remainingAmount % Coins.QUARTER.getdenom();

        change.num50cent = remainingAmount / Coins.HALFDOLLAR.getdenom();


        return change;
    }
}
