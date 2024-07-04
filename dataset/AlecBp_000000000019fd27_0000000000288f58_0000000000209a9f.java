 import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        String strOut;
        for (int i = 0; i < t; i++) {
            String strIn = in.next();
            strOut = "";
            int numPar = 0;
            for (int j = 0; j < strIn.length(); j++) {
                int curr = Character.getNumericValue(strIn.charAt(j));
                
                int diff = numPar - curr;
                if (diff < 0) {
                    // ADD par
                    while (diff < 0) {
                        strOut += "(";
                        diff++;
                        numPar++;
                    }
                } else if (diff > 0) {
                    while (diff > 0) {
                        strOut += ")";
                        diff--;
                        numPar--;
                    }
                }
                strOut += strIn.charAt(j);
            }
            while (numPar > 0) {
                strOut += ")";
                numPar--;
            }

            System.out.println("Case #" + (i + 1) + ": " + strOut);
        }
    }
}
