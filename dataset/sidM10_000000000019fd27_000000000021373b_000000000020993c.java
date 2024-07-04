import java.util.*;
import java.io.*;

public class Solution {

    public static int[] vestigium(int[][] grid, int n){

        int[] res = new int[3];
        HashSet<Integer> set;

        for(int i = 0; i < n; i++){
            set = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(set.contains(grid[i][j])){
                    res[1]++;
                    break;
                }
                set.add(grid[i][j]);
            }
        }

        for(int i = 0; i < n; i++){
            set = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(set.contains(grid[j][i])){
                    res[2]++;
                    break;
                }
                set.add(grid[j][i]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j)
                    res[0] += grid[i][j];
            }
        }

        return res;
    } 

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    grid[j][k] = in.nextInt();
                }
            }
            int[] res = vestigium(grid,n);
            System.out.println("Case #" + i + ": "+res[0]+" "+res[1]+" "+res[2]);
        }
    }
}