
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String data = in.next();
            String ris = "";
            int p = 0;

            for (int j = 0; j < data.length(); j++) {
                int x = Integer.parseInt(data.charAt(j) + "");
                if (x < p) {
                    for (int z = 0; z < p - x; z++) {
                        ris += ")";
                    }
                    p = x;
                } else if (x > p) { 
                    for (int z = 0; z < x - p; z++) {
                        ris += "(";
                    }
                    p = x;
                }
                ris += "" + x;

            }
            
            
            while (p != 0) {
                p--;
                ris += ")";
            }
            System.out.println("Case #" + i + ": " + ris);
        }
    }
}
