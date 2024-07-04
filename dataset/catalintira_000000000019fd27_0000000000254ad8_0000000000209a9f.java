import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.


        for (int testNo = 1; testNo <= tests; ++testNo) {
            System.out.print("Case #" + testNo + ": ");
            String n = in.next();
            int paraCount = 0;


            for(int i = 0; i < n.length(); ++i) {
                int paraDiff = Integer.parseInt(n.charAt(i) + "") - paraCount;
                boolean openP = paraDiff > 0;
                paraCount += paraDiff;
                String paraString = ")";
                if(openP) {
                    paraString = "(";
                } else {
                    paraDiff *= -1;
                }


                for(int p = 0; p < paraDiff; ++p) {
                    System.out.print(paraString);
                }

                System.out.print(n.charAt(i));
            }
            for(int i = 0; i < paraCount; ++i) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
