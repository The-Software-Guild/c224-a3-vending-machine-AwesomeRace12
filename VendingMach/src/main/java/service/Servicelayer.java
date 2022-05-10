/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import dao.VendingException;
import dto.Item;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author aakar
 */
public interface Servicelayer {
      List<Item> getItemList() throws 
            NoItemInventoryException,
            VendingException;
    List<BigDecimal> getChange(Item item) throws 
            InsufficientFundsException,
            VendingException;
    Item vendItem(Item item) throws
            NoItemInventoryException,
            InsufficientFundsException,
            VendingException;
    BigDecimal getTotal() throws VendingException;

    BigDecimal addCoin(String penny, int newPenny) throws VendingException;
}
