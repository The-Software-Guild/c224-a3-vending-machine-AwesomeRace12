/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import dao.VendingAuditDao;
import dao.VendingDao;
import dao.VendingException;
import dto.Item;
import java.math.BigDecimal;
import java.util.*;
/**
 *
 * @author aakar
 */
public class ServicelayerImpl implements Servicelayer {
    private VendingAuditDao auditDao;
    private VendingDao dao;
    
    public ServicelayerImpl(VendingDao dao, VendingAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }

    private void hasEnoughMoney(Item item) throws InsufficientFundsException, VendingException, VendingException {
        BigDecimal temp = new BigDecimal(item.getPrice());
        if (dao.getTotal().compareTo(temp) < 0) {
            throw new InsufficientFundsException("INSUFFICIENT FUNDS");
        }
    }

    @Override
    public List<Item> getItemList() throws NoItemInventoryException, VendingException {
        if (dao.getItemList().isEmpty()) {
            throw new NoItemInventoryException("VENDING MACHINE EMPTY");
        }
        return dao.getItemList();
    }

    @Override
    public List<BigDecimal> getChange(Item item) throws InsufficientFundsException, VendingException {
        hasEnoughMoney(item);
        return dao.getChange(item);
    }

    @Override
    public Item vendItem(Item item) throws NoItemInventoryException, InsufficientFundsException, VendingException {
        auditDao.writeAuditEntry("Item: " + item.getItem() + " VENDED.");
        if (dao.getItemList().isEmpty()) {
            throw new NoItemInventoryException("VENDING MACHINE EMPTY");
        }
        
        BigDecimal temp = new BigDecimal(item.getPrice());

        hasEnoughMoney(item);
        return dao.vendItem(item);
    }
    @Override
    public BigDecimal getTotal() throws VendingException {
        return dao.getTotal();
    }

    @Override
    public BigDecimal addCoin(String coinType, int amount) throws VendingException {
        return dao.addCoin(coinType, amount);
    }
}
