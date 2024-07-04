import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 1; i<=t; i++){
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            for(int j=0; j<n; j++){
                for (int k=0; k<n; k++){
                    grid[j][k] = in.nextInt();
                }
            }
            int trace = calcTrace(grid);
            int repeatedRows = calcRows(grid);
            int repeatedCols = calcCols(grid);
            System.out.println(String.format("Case #%d: %d %d %d", i, trace, repeatedRows, repeatedCols));
        }
    }

    private static int calcCols(int[][] grid) {
        int repeats = 0;
        for(int col=0; col<grid.length; col++){
            boolean repeatedEntry = false;
            int[] counts = new int[grid.length];
            for(int row=0; row<grid.length; row++){
                counts[grid[row][col]-1] = counts[grid[row][col]-1] +1;
                if(counts[grid[row][col]-1]>1){
                    repeatedEntry = true;
                }
            }
            if(repeatedEntry) repeats++;
        }
        return repeats;
    }

    private static int calcRows(int[][] grid) {
        int repeats = 0;
        for(int row = 0; row<grid.length; row++){
            boolean repeatedEntry = false;
            int[] counts = new int[grid.length];
            for(int entry: grid[row]){
                counts[entry-1] = counts[entry-1] + 1;
                if (counts[entry-1]>1) {
                    repeatedEntry = true;
                }
            }
            if (repeatedEntry) repeats++;
        }
        return  repeats;
    }

    private static int calcTrace(int[][] grid) {
        int trace = 0;
        for(int i=0; i<grid.length; i++){
            trace += grid[i][i];
        }
        return trace;
    }
}
