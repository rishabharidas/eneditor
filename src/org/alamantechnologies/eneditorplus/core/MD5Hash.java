/* 
 * AL-AMAN TECHNOLOGIES CONFIDENTIAL
 * AUTHOR : MUHAMMAD SWALAH A A.
 * Unpublished Copyright (c) 2016-2020 AL-AMAN TECHNOLOGIES, All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property of AL-AMAN TECHNOLOGIES. The
 * intellectual and technical concepts contained herein are proprietary to AL-AMAN TECHNOLOGIES and 
 * may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret
 * or copyright law. Dissemination of this information or reproduction of this material is strictly
 * forbidden unless prior written permission is obtained from AL-AMAN TECHNOLOGIES.  Access to the
 * source code contained herein is hereby forbidden to anyone except current AL-AMAN TECHNOLOGIES 
 * employees, managers or contractors who have executed Confidentiality and Non-disclosure agreements
 * explicitly covering such access.
 *
 * The copyright notice above does not evidence any actual or intended publication or disclosure of
 * this source code, which includes information that is confidential and/or proprietary, and is a 
 * trade secret, of AL-AMAN TECHNOLOGIES. ANY REPRODUCTION, MODIFICATION, DISTRIBUTION, 
 * PUBLIC PERFORMANCE, OR PUBLIC DISPLAY OF OR THROUGH USE OF THIS SOURCE CODE WITHOUT THE EXPRESS
 * WRITTEN CONSENT OF COMPANY IS STRICTLY PROHIBITED, AND IN VIOLATION OF APPLICABLE LAWS AND 
 * INTERNATIONAL TREATIES.  THE RECEIPT OR POSSESSION OF THIS SOURCE CODE AND/OR RELATED INFORMATION
 * DOES NOT CONVEY OR IMPLY ANY RIGHTS TO REPRODUCE, DISCLOSE OR DISTRIBUTE ITS CONTENTS, OR TO 
 * MANUFACTURE, USE, OR SELL ANYTHING THAT IT MAY DESCRIBE, IN WHOLE OR IN PART.
 */
package org.alamantechnologies.eneditorplus.core;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AL-AMAN TECHNOLOGIES
 */
public class MD5Hash {
    
    
    /**/
    /**for removing all white spaces in a given string
     * @param inString
     * @return  CharSequence without spaces*/
    public static String removeSpace(CharSequence inString)
    {
        String patternStr = "\\s+";
        String replaceStr = "";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inString);
        return matcher.replaceAll(replaceStr);
    }
    /**/
    
    
    public static String getMD5Hash(String stringText)
    {
        String hash ="";
        try 
        {
            //byte[] bytes = { 0x35, 0x24, 0x76, 0x12 };
            
            byte[] bytes = stringText.getBytes("UTF-16LE");
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] digest = m.digest(bytes);
            /*hash = new BigInteger(1, digest).toString(16);*/
            hash = String.format("%032x", new BigInteger(1, digest));
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(MD5Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        StringBuilder hwidMd5 = new StringBuilder();
            
            int limit = hash.length();
            for (int i = 0; i < limit; i++) {
                hwidMd5.append(hash.substring(i, i + 1));
                if ((i + 1) % 4 == 0 && (limit - (i + 1) > 0)) {
                    hwidMd5.append("-");
                }
            }
            hash = hwidMd5.toString();
*/
        return hash;
    }
    public static void main(String[] args) {
        System.out.println(MD5Hash.getMD5Hash("hai"));
        System.out.println(MD5Hash.getMD5Hash("hai").length());
    }

}
