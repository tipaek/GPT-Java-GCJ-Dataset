import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
      
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int c = 0; c < t; c++) {
            int n = in.nextInt();
            ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>(n);
            boolean[] rflags = new boolean[n];
            for (int i = 0; i < n; i++) {
                rows.add(new HashSet<Integer>());
            }
            ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>(n);
            boolean[] cflags = new boolean[n];
            for (int i = 0; i < n; i++) {
                cols.add(new HashSet<Integer>());
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
                    if (!rows.get(i).contains(cur)) {
                        rows.get(i).add(cur);
                    } else {
                        if (!rflags[i]) {
                            rflags[i] = true;
                            numRows++;
                        }
                    }
                    if (!cols.get(j).contains(cur)) {
                        cols.get(j).add(cur);
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