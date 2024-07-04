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
                if (i > 0 && prev != null && prev > 0) {
                    ans.append(times(")", prev) + curr);
                    close+= prev;
                } else {
                    ans.append(curr);
                }
            } else {
                if (prev != null && prev > curr) {
                    ans.append(times(")", prev-curr) + curr);
                    close+=prev-curr;
                } else if (prev != null && prev < curr) {
                    ans.append(times("(", curr - prev) + curr);
                    open+=curr - prev;
                } else if (i == 0) {
                    ans.append(times("(", curr) + curr);
                    open+=curr;
                } else {
                    ans.append(curr);
                }
            }
        }
        if (open > close) {
            ans.append(times(")", open-close));
        } else {
            ans.insert(0, times("(", close - open));
        }
        return ans.toString();
    }

    private static String times(String s, Integer times) {
        String ans = "";
        for (int i = 0; i< times; i++) {
            ans += s;
        }
        return ans;
    }
}