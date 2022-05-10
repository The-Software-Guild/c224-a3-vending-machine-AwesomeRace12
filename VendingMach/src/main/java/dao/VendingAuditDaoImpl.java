/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.io.*;
import java.time.LocalDateTime;
/**
 *
 * @author aakar
 */
public class VendingAuditDaoImpl implements VendingAuditDao {
    
    public static final String AUDIT_FILE = "audit.txt";

    public void writeAuditEntry(String entry) throws VendingException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp + " : " + entry);
        out.flush();
    }
}
