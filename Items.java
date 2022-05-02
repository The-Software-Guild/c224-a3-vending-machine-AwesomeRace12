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
public enum Items {
    COKE(1, 10),
    SPRITE(2, 20),
    LAYS(3, 5),
    AHOY(4, 8),
    SKITTLES(5, 25),
    TWIX(6, 15),
    TWINKIES(7, 10),
    EMPTY(0,0);
    
    private int selectnum;
    private int price;
    
    private Items(int selectnum, int price){
        this.selectnum=selectnum;
        this.price=price;
    }
    public int getselnum(){
        return selectnum;
    }
    public int getprice(){
        return price;
}
     public static Items valueOf(int numberSelection){
        for(Items item: Items.values()){
            if(numberSelection == item.getselnum()){
                return item;
            }
        }
        return EMPTY;
    }
}
