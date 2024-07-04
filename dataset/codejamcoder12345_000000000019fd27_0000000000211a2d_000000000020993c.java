import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
      
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int c = 0; c < t; c++) {
            int n = in.nextInt();
            HashSet<Integer>[] rows = new HashSet<>[n];
            boolean[] rflags = new boolean[n];
            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<Integer>();
            }
            HashSet<Integer>[] cols = new HashSet<>[n];
            boolean[] cflags = new boolean[n];
            for (int i = 0; i < n; i++) {
                cols[i] = new HashSet<Integer>();
            }
            int trace = 0;
            int numRows = 0;
            int numCols = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = in.nextInt();
                    if (i == j) {
                        trace += cur;
                    }
                    if (!rows[i].contains(cur)) {
                        rows[i].add(cur);
                    } else {
                        if (!rflags[i]) {
                            rflags[i] = true;
                            numRows++;
                        }
                    }
                    if (!cols[j].contains(cur)) {
                        cols[j].add(cur);
                    } else {
                        if (!cflags[j]) {
                            cflags[j] = true;
                            numCols++;
                        }
                    }
                }
            }
            System.out.println("Case #" + String.valueOf(c+1) + ": " + String.valueOf(trace) + " " + String.valueOf(numRows) + " " + String.valueOf(numCols));
        }
        
    }
  
}