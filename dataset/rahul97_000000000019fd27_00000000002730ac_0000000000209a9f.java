// package foregone;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                String m = in.nextLine();
                System.out.println("Case #" + i + ": " + extracted(m));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String extracted(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ('0' == str.charAt(i)) {
                if (i == 0) {
                    ans.append("0");
                } else if (Integer.parseInt(""+str.charAt(i-1)) > 0) {
                    ans.append(")0");
                }
            } else {
                if (i > 0 && Integer.parseInt(""+str.charAt(i-1)) == 1) {
                    ans.append("1");
                } else {
                    ans.append("(1");
                }
                if (i+1 == str.length()) {
                    ans.append(")");
                }
            }
        }
        return ans.toString();
    }
}