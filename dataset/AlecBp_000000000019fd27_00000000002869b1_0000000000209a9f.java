import java.util.*;
import java.io.*;
/* @author AlecBp */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        String strOut;
        for (int i = 0; i < t; i++) {
            String strIn = in.next();
            strOut = "";
            boolean parIsOpen = false;
            for (int j = 0; j < strIn.length(); j++) {
                if (strIn.charAt(j) == '1') {
                    if (!parIsOpen) {
                        strOut += "(";
                        parIsOpen = true;
                    }
                    strOut += "1";
                } else {
                    if (parIsOpen) {
                        strOut += ")";
                        parIsOpen = false;
                    }
                    strOut += "0";
                }
            }
            if (parIsOpen) {
                strOut += ")";
            }

            System.out.println(strOut);
        }
    }
}
