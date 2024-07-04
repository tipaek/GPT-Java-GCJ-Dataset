import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
      
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int c = 0; c < t; c++) {
            int n = in.nextInt();
            Set<Integer>[] rows = new Set<Integer>[n];
            boolean[] rflags = new boolean[n];
            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<Integer>();
            }
            Set<Integer>[] cols = new Set<Integer>[n];
            boolean[] cflags = new boolean[n];
            for (int i = 0; i < n; i++) {
                cols[i] = new HashSet<Integer>();
            }
            trace = 0;
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
            System.out.println("Case #" + String.ValueOf(c+1) + ": " + String.ValueOf(trace) + " " + String.ValueOf(numRows) + " " + String.ValueOf(numCols));
        }
        
    }
  
}