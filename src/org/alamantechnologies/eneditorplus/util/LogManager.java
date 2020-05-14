/* 
 * The MIT License
 *
 * Copyright 2016 AL-AMAN TECHNOLOGIES.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.alamantechnologies.eneditorplus.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import org.alamantechnologies.eneditorplus.core.CryptoUtil;

/**
 *
 * @author MUHAMMAD SWALAH A A
 */
public class LogManager 
{
    private static final String LOG_ENC_KEY="P1vcg0jznOQK2XTtW+98h39uQUPu|2V:8J9qt\"110<144Cj.dq*Cd|m9N`5G,Bf";
    private static void createLogDirIfNotExist()
    {
        File theDir = new File("LOG");
        // if the directory does not exist, create it
        if (!theDir.exists()) 
        {
            try
            {
                theDir.mkdir();
            } 
            catch(SecurityException se)
            {
                JOptionPane.showMessageDialog(null, "err:#"+se.hashCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void logErr(Exception ex)
    {
        createLogDirIfNotExist();
        Writer writer = new StringWriter();
        PrintWriter printWriter1 = new PrintWriter(writer);
        ex.printStackTrace(printWriter1);
        String err = writer.toString();
        
        FileWriter fileWriter = null;
        PrintWriter printWriter;
        File file;
        String date;
        
        DateFormat dateFormat = new SimpleDateFormat("[yyyy-MMM-dd HH:mm:ss]");
        Date dat = new Date();
        CryptoUtil enc = new CryptoUtil();
        date = String.valueOf(dateFormat.format(dat));
        try
        {
            file = new File("LOG/ErrorLog.log");
            fileWriter = new FileWriter(file,true);
            printWriter = new PrintWriter(fileWriter);
            //printWriter.println(date+err);
            printWriter.println(enc.encrypt(LOG_ENC_KEY, date+err));
            printWriter.println("---------------------");
               
        }
        catch(IOException e)
        {
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex1) {
            Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, ex1);
        }
        /*catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex1) {
        Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, ex1);
        } */  /*catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex1) {
            Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, ex1);
        } */
        finally
        {   
            try
            {
                fileWriter.flush();
                fileWriter.close(); 
            } catch (IOException ex1) {
                Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }
        JOptionPane.showMessageDialog(null, "err:#"+ex.hashCode(), "Error", ERROR_MESSAGE, null);
    }
}
