import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NC = Integer.parseInt(in.nextLine());
        for(int i = 0; i < NC; i ++){
            int trace = 0, rowr = 0, colr = 0;
            int size = Integer.parseInt(in.nextLine());
            int[][] grid = new int[size][size];
            for(int r = 0; r < size; r ++){
                StringTokenizer row = new StringTokenizer(in.nextLine());
                for(int c = 0; c < size; c ++) grid[r][c] = Integer.parseInt(row.nextToken());
            }
            for(int j = 0; j < size; j ++) trace += grid[j][j];
            for(int j = 0; j < size; j ++){
                for(int k = 0; k < size; k ++){
                    for(int l = k+1; l < size; l ++){
                        if(grid[j][k] == grid[j][l]){
                            rowr ++;
                            k = size;
                            l = size;
                        }
                    }
                }
            }
            for(int j = 0; j < size; j ++){
                for(int k = 0; k < size; k ++){
                    for(int l = k+1; l < size; l ++){
                        if(grid[k][j] == grid[l][j]){
                            colr ++;
                            k = size;
                            l = size;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + rowr + " " + colr);
        }
    }
}