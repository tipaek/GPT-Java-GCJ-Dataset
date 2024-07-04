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
        int close = 0;
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            int curr = Integer.parseInt(""+str.charAt(i));
            Integer prev = null;
            if (i > 0) {
                prev = Integer.parseInt(""+str.charAt(i-1));
            }
            if (curr == 0) {
                if (i == 0) {
                    ans.append(curr);
                } else if (prev != null && prev > 0) {
                    ans.append(")" + curr);
                    close++;
                }
            } else {
                if (prev != null && prev > curr) {
                    ans.append(")" + curr);
                    close++;
                } else if (prev != null && prev < curr) {
                    ans.append("(" + curr);
                    open++;
                } else if (i == 0) {
                    ans.append("(" + curr);
                    open++;
                } else {
                    ans.append(curr);
                }
            }
        }
        if (open > close) {
            int diff = open-close;
            while (diff-- != 0) {
                ans.append(")");
            }
        } else {
            int diff = close - open;
            while (diff-- != 0) {
                ans.insert(0, ")");
            }
        }
        return ans.toString();
    }
}