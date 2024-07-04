import java.io.*;
import java.util.*;

// public class A {
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
            }
            int[] idxs = new int[n];
            StringBuilder sb = new StringBuilder();
            boolean success = true;
            // Iterate until everything starts with *
            boolean all_star = false;
            while (!all_star) {
                all_star = true;
                char pop = (char) 0;
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(idxs[i]) != '*') {
                       all_star = false;
                       if (pop == 0) {
                           pop = patterns[i].charAt(idxs[i]);
                       } else {
                           if (pop != patterns[i].charAt(idxs[i])) {
                               // Quit
                               all_star = false;
                               success = false;
                               break;
                           }
                       }
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(idxs[i]) == pop) {
                        idxs[i]++;
                    }
                }
                if (!all_star) {
                    sb.append(pop);
                }
            }
            int[] end_idxs = new int[n];
            for (int i = 0; i < n; i++) {
                end_idxs[i] = patterns[i].length() - 1;
            }
            all_star = false;
            StringBuilder sb_end = new StringBuilder();
            while (!all_star) {
                all_star = true;
                char pop = (char) 0;
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(end_idxs[i]) != '*') {
                       all_star = false;
                       if (pop == 0) {
                           pop = patterns[i].charAt(end_idxs[i]);
                       } else {
                           if (pop != patterns[i].charAt(end_idxs[i])) {
                               // Quit
                               all_star = false;
                               success = false;
                               break;
                           }
                       }
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(end_idxs[i]) == pop) {
                        end_idxs[i]--;
                    }
                }
                if (!all_star) {
                    sb_end.append(pop);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = idxs[i] + 1; j < end_idxs[i]; j++) {
                    if (patterns[i].charAt(j) != '*') {
                        sb.append(patterns[i].charAt(j));
                    }
                }
            }
            if (success) {
                System.out.println("Case #" + cases + ": " + sb + sb_end.reverse());
            } else {
                System.out.println("Case #" + cases + ": *");
            }
        }
    }
}
