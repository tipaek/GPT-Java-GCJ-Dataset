import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            rows = scan.nextInt();
            cols = scan.nextInt();
            int[][] grid = new int[rows][cols];
            for(int col = 0; col < cols; col++) {
                for(int row = 0; row < rows; row++) {
                    grid[row][col] = scan.nextInt();
                }
            }
            long interest = simulate(grid, 0);
            System.out.printf("Case #%d: %d\n",i+1,interest);
        }
    }

    public static long simulate(int[][] grid, long interest) {
        int[][] toEliminate = new int[rows][cols];
        int numToEliminate = 0;
        for(int col = 0; col < cols; col++) {
            for(int row = 0; row < rows; row++) {
                if(grid[row][col]==0)continue;
                interest += grid[row][col];
                double average = 0;
                double adj = 0;
                int a = row;
                int b = col + 1;
                while(b<cols&&grid[a][b]==0)b++;
                if(b<cols&&grid[a][b]!=0) {
                    average+=grid[a][b];
                    adj++;
                }
                a = row;
                b = col - 1;
                while(b>=0&&grid[a][b]==0)b--;
                if(b>=0&&grid[a][b]!=0) {
                    average+=grid[a][b];
                    adj++;
                }
                a = row+1;
                b = col;
                while(a<rows&&grid[a][b]==0)a++;
                if(a<rows&&grid[a][b]!=0) {
                    average+=grid[a][b];
                    adj++;
                }
                a = row-1;
                b = col;
                while(a>=0&&grid[a][b]==0)a--;
                if(a>=0&&grid[a][b]!=0) {
                    average+=grid[a][b];
                    adj++;
                }
                if(adj>0) {
                    if((average/adj)-grid[row][col]>.01) {
                        numToEliminate++;
                        toEliminate[row][col]=1;
                    }
                }
            }
        }
        if(numToEliminate==0)return interest;
        for(int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if(toEliminate[row][col]==1) {
                    grid[row][col]=0;
                }
            }
        }
        return simulate(grid, interest);
    }
}
