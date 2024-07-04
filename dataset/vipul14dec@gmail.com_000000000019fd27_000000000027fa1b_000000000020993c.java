/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;
public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i< t;i++) {
            int n = Integer.parseInt(sc.nextLine());
            int [][] grid = new int[n][n];
            int dupRows = 0;
            int dupCols = 0;
            int trace = 0;
            for(int j=0; j<n;j++) {
                int col = 0;
                Set<Integer> rowSet= new HashSet<Integer>();
                String[] s = sc.nextLine().trim().split("\\s+");
                for(String v: s) {
                    grid[j][col] = Integer.parseInt(v);
                    rowSet.add(grid[j][col]);
                    col++;
                }
                if(rowSet.size() != n) dupRows++;
            }
            for(int row=0; row<n;row++) {
                trace += grid[row][row];
                Set<Integer> colSet= new HashSet<Integer>();
                for(int col=0;col<n;col++) {
                    colSet.add(grid[col][row]);
                }
                if(colSet.size() != n) dupCols++;
            }
            System.out.println("Case #" + t + ": " + trace + " " + dupRows + " " + dupCols);
        }
    }
}
