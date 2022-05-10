/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author aakar
 */
public class InsufficientFundsException extends Exception {
      public InsufficientFundsException(String msg) {
        super(msg);
    }

    public InsufficientFundsException(String msg, Throwable cause) {
        super (msg, cause);
    }
}
