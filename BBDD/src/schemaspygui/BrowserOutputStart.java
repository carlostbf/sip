/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schemaspygui;

import java.io.*;

/**
 *
 * @author joachim uhl; mailto:admin@joachim-uhl.de; http://www.joachim-uhl.de/projekte/schemaspygui/
 */
public class BrowserOutputStart {
    static String url;

    public BrowserOutputStart( String url_in ) {
        url = "file://" +url_in;
    }

    public static void launch() {
        try {
            if (isWindows()) {
                Runtime.getRuntime().exec( "rundll32 url.dll,FileProtocolHandler "
                + url );
            } else {
                Runtime.getRuntime().exec("firefox " + url);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name");
        if ( os != null && os.startsWith("Windows")) {
            return true;
        } else {
            return false;
        }
    }
}
