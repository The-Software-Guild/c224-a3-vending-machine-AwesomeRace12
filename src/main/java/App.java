/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aakar
 */
import UI.VendingView;
import dao.VendingDao;
import dao.VendingAuditDao;
import dao.VendingAuditDaoImpl;
import dao.VendingDaoImpl;
import service.ServicelayerImpl;
import controller.Vendingcontroller;
import UI.UserIO;
import UI.UserIOImpl;
import service.InsufficientFundsException;
import service.NoItemInventoryException;
import service.Servicelayer;
import service.ServicelayerImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//       UserIO myio = new UserIOImpl();
//       VendingView myview = new VendingView(myio);
//       VendingDao myDao = new VendingDaoImpl();
//       VendingAuditDao myAuditDao = new VendingAuditDaoImpl();
//       Servicelayer myService = new ServicelayerImpl(myDao,myAuditDao);
//       Vendingcontroller controller = new Vendingcontroller(myService, myview);
//       controller.run();
     
          ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Vendingcontroller controller = 
           ctx.getBean("controller", Vendingcontroller.class);
        controller.run();
    }
    
}
