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
        boolean isopen = false;
        for (int i = 0; i < str.length(); i++) {
            int curr = Integer.parseInt(""+str.charAt(i));
            if (curr == 0) {
                if (i == 0) {
                    ans.append(curr);
                } else if (isopen) {
                    ans.append(")" + curr);
                    isopen = false;
                }
            } else {
                if (i > 0 && isopen) {
                    ans.append(curr);
                } else {
                    ans.append("(" + curr);
                    isopen = true;
                }
                if (i+1 == str.length()) {
                    ans.append(")");
                }
            }
        }
        return ans.toString();
    }
}