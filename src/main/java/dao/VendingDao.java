/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Item;
import java.util.*;
import java.math.BigDecimal;

/**
 *
 * @author aakar
 */
public interface VendingDao {
    BigDecimal addCoin(String coinType, int amount) throws VendingException;
    BigDecimal getTotal() throws VendingException;
    List<Item> getItemList() throws VendingException;
    Item vendItem(Item item) throws VendingException;
    List<BigDecimal> getChange(Item item)throws VendingException;
}
