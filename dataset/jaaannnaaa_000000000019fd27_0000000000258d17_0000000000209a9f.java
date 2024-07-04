import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // File myObj = new File("test.txt");
        // Scanner in = new Scanner(myObj);

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
            
        // System.out.println(t);

        for (int tt = 1; tt <= t; tt++) {
            String s = in.nextLine();
            char[] sa = s.toCharArray();

            StringBuilder sb = new StringBuilder();

            int open = 0;

            for (char c : sa) {
                int num = Character.getNumericValue(c);
                // System.out.println(open);
                // System.out.println("num: " + num);
                if (num > open) {
                    int toOpen = num - open;
                    for (int i = 0; i < toOpen; i++) {
                        sb.append("(");
                    }
                    open = open + toOpen;
                } else if (num < open) {
                    int toClose = open - num;
                    for (int i = 0; i < toClose; i++) {
                        sb.append(")");
                    }
                    open = open - toClose;
                }
                sb.append(num);

            }

            for (int i = 0; i < open; i++) {
                sb.append(")");
            }
            
            System.out.println("Case #" + tt + ": " + sb.toString());
        }

        in.close();
    }
}