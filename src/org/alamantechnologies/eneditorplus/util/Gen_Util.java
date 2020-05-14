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

import javax.swing.JOptionPane;
import java.awt.Component;

public class Gen_Util 
{
    public static void showErrorDialog(String errMsg)
    {
        JOptionPane.showMessageDialog(null, errMsg, "Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void showErrorDialog(Component component,String errMsg)
    {
        JOptionPane.showMessageDialog(component, errMsg, "Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void showSuccessDialog(String sucMsg)
    {
        JOptionPane.showMessageDialog(null, sucMsg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showInformationDialog(String information)
    {
        JOptionPane.showMessageDialog(null, information, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    public static int showConfirmDialog(String conMsg)
    {
        return JOptionPane.showConfirmDialog(null, conMsg, "Confirm",JOptionPane.YES_NO_OPTION);
    }
    public static int showConfirmDialog(String conMsg,int msgType)
    {
        return JOptionPane.showConfirmDialog(null, conMsg, "Confirm",JOptionPane.YES_NO_OPTION,msgType);
    }
}
