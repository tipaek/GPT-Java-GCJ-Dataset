import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for(int x = 0; x < t; x++) {
            StringBuilder s = new StringBuilder();
            String sRe = "";
            String sCo = "";
            String sBo = "";
            for (int i = 0; i < b; i++) {
                s.append('x');
            }

            int i = 0; int offset = 0;
            while (!know(s.toString()) && i < 150) {
                System.err.println(s.toString());

                if (i % 10 == 0) {
                    sRe = rev(s.toString());
                    sCo = complement(s.toString());
                    sBo = both(s.toString()); 
                    for (int j = 0; j < 5; j++) {
                        System.out.println(j + 1 + offset);
                        System.out.flush();
                        s.setCharAt(j, in.next().charAt(0));
                        
                    }
                }
                // determine index to query
                int p = i + 1;
                System.out.println(p);
                System.out.flush();
                s.setCharAt(p - 1, in.next().charAt(0));
                
                p = b - i;
                System.out.println(p);
                System.out.flush();
                s.setCharAt(p - 1, in.next().charAt(0));

                // increment counter
                i++;
            }

            System.out.println(s.toString());
            System.out.flush();
            
            char ok = in.next().charAt(0);
            if (ok == 'N') System.exit(0);
        }

        System.exit(0);
    }

    static String rev(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        builder.reverse();
        return builder.toString();
    }

    static String complement(String s) {
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == '1') builder.append('0');
            else builder.append('1');
        }
        return builder.toString();
    }
    
    static String both(String s) {
        return rev(complement(s));
    }

    static boolean know(String s) {
        for (char c : s.toCharArray())
            if (c == 'x') return false;
        return true;
    }
}