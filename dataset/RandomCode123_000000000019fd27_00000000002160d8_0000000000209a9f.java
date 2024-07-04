import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String str = in.nextLine();
            StringBuilder builder = new StringBuilder();

            for(char c : str.toCharArray()){
                int n = Character.getNumericValue(c);
                StringBuilder ap = new StringBuilder();
                for(int z  = 0; z<n; z++){
                    ap.append("(");
                }
                ap.append(n);
                for(int z  = 0; z<n; z++){
                    ap.append(")");
                }
                builder.append(ap.toString());
            }
            str = builder.toString();
            while(str.contains(")(")){
                str = str.replace(")(","");
            }

            System.out.println("Case #" + i + ": " + str);
        }
    }
}