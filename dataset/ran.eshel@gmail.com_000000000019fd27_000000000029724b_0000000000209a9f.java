import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        String[] open  = new String[10];
        String[] close = new String[10];
        open[0] = "";
        close[0] = "";

        for (int i = 1; i < 10; i++) {
            open[i] = open[i - 1] + "(";
            close[i] = close[i - 1] + ")";
        }

        Scanner s = null;
        try {
            s = new Scanner (new File("test.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        if (s == null)
            return;

        int t = s.nextInt();
        for (int i = 1; i <= t; ++i) {

            String n = s.next();

            String r = "";

            int len = n.length();
            int prevC = 0;
            for (int j = 0; j < len; j++) {
                char c = n.charAt(j);
                int ci = c - '0';
                if (ci >= prevC)
                    r += open[ci - prevC] + c;
                else
                    r += close[prevC - ci] + c;

                prevC = ci;
            }

            r += close[prevC];

            System.out.println("Case #" + i + ": " + r);
        }
    }
}

