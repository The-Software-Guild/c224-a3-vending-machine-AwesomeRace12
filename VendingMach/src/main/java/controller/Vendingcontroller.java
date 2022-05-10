/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import UI.VendingView;
import dao.VendingDao;
import service.ServicelayerImpl;
import UI.UserIO;
import UI.UserIOImpl;
import dao.VendingException;
import service.InsufficientFundsException;
import service.NoItemInventoryException;
import service.Servicelayer;
import java.util.*;
import dto.Item;
import java.math.BigDecimal;
/**
 *
 * @author aakar
 */
public class Vendingcontroller {
    VendingView view;
    private UserIO io = new UserIOImpl();
    private Servicelayer service;

    public Vendingcontroller(Servicelayer service, VendingView view) {
        this.service = service;
        this.view = view;
    }
    
    
    public void run(){
        boolean loop=true;
        int menuselect=0;
        menuselect = getMenu();
        try {
        while(loop){
            switch(menuselect){
                case 1:
                   addCoins();
                   getTotalMoney();
                  break;
                case 2:
                   if(service.getTotal().compareTo(BigDecimal.ZERO) == 0) {
                            io.print("No money");
                            break;
                        }
                  listItems();
                  break;
                case 3:
                  loop=false;
                  break;
                default:
                 unknownCommand();
            }
            io.print("Goodbye");
        }
        } catch (VendingException | InsufficientFundsException | NoItemInventoryException e) {
            view.displayErrorMessage(e.getMessage());
        }
        exitMessage();
              
    }
    
    
    public int getMenu(){
        return view.printmenu();
    }
    
    
    private void addCoins() throws VendingException {
        view.displayAddCoinBanner();

        int newPenny = view.getPenny();
        service.addCoin("PENNY", newPenny);

        int newNickel = view.getNickle();
        service.addCoin("NICKEL", newNickel);

        int newDime = view.getDime();
        service.addCoin("DIME", newDime);

        int newQuarter = view.getQuarter();
        service.addCoin("QUARTER", newQuarter);

        view.displayAddSuccessBanner();
    }


    private void getTotalMoney()throws VendingException {
        view.displayTotalBanner();
        view.displayTotal(service.getTotal());
    }

    private void listItems() throws VendingException, InsufficientFundsException, NoItemInventoryException {
        view.displayPurchaseBanner();
        List<Item> itemList = service.getItemList();
        List<Item> availableItems = view.displayItems(itemList);
        Item chosenItem = view.chooseItem(availableItems);
        Item removedItem = service.vendItem(chosenItem);

        if (chosenItem.getAmount()==(removedItem.getAmount())) {
            view.displayNotEnoughMoney();
            view.displayTotal(service.getTotal());
        }
        else {
            view.displayChange(service.getChange(chosenItem));
        }
    }
    
    
      private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void exitMessage() {
        view.displayExit();
    }

}
