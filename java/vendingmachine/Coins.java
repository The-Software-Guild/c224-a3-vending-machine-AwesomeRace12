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
public enum Coins {
    PENNY(1),
    DIME(10),
    QUARTER(25),
    NICKLE(5),
    HALFDOLLAR(50);
    
    private int denom;
    
    Coins(int denom){
        this.denom = denom;
    }
    
      public static int[] parseCoins(String coins){
        String[] numberCoinsInText = coins.split(",");
        int[] result = new int[numberCoinsInText.length];
        for(int index=0;index<numberCoinsInText.length;index++){
            result[index] = Integer.parseInt(numberCoinsInText[index]);
        }
        return result;
    }
    
    public int getdenom(){
       return denom; 
    }
}
