import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int brac = 0;

            for(int i = 0;i < n;i++) {
                int val = s.charAt(i)-48;

                if(val == brac) sb.append(s.charAt(i));
                else if(val > brac) {
                    int diff = val - brac;
                    sb.append(generateOpenBraces(diff)).append(s.charAt(i));
                    brac = brac + diff;
                }
                else {
                    int diff = brac - val;
                    sb.append(generateCloseBraces(diff)).append(s.charAt(i));
                    brac = brac - diff;
                }
            }
            if(brac > 0) sb.append(generateCloseBraces(brac));

            System.out.println(sb.toString());

        }
    }

    public static String generateOpenBraces(int n) {
        return String.join("", Collections.nCopies(n, "("));
    }
    public static String generateCloseBraces(int n) {
        return String.join("", Collections.nCopies(n, ")"));
    }
}