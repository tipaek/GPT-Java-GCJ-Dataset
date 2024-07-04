import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] data = new int[n][n];
            int sum = 0;
            int rcount = 0;
            
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    data[j][k] = sc.nextInt();
                    if (!rowSet.add(data[j][k])) {
                        rcount++;
                    }
                    if (j == k) {
                        sum += data[j][k];
                    }
                }
            }
            
            int ccount = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(data[k][j])) {
                        ccount++;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + sum + " " + rcount + " " + ccount);
        }
    }
}