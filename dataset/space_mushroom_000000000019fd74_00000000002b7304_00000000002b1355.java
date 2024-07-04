import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static class Cell{
        private int d;
        private boolean isEliminated = false;

        public Cell(int d){
            this.d = d;
        }
    }

    private static long calculateRoundInterest(Cell[][] grid){
        long interest = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                interest += grid[i][j].d;
            }
        }

        return interest;
    }

    private static boolean clearEliminated(Cell[][] grid){
        boolean flag = false;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j].isEliminated && grid[i][j].d != 0) {
                    grid[i][j].d = 0;
                    flag = true;
                }
            }
        }

        return flag;
    }

    private static double calculateAverageD(Cell[][] grid, int row, int col){
        int left = 0, right = 0, up = 0, down = 0;

        for(int i=row+1; i<grid.length; i++){
            if(grid[i][col].d != 0){
                right = grid[i][col].d;
                break;
            }
        }
        for(int i=row-1; i>=0; i--){
            if(grid[i][col].d != 0){
                left = grid[i][col].d;
                break;
            }
        }

        for(int i=col+1; i<grid[0].length; i++){
            if(grid[row][i].d != 0){
                down = grid[row][i].d;
                break;
            }
        }
        for(int i=col-1; i>=0; i--){
            if(grid[row][i].d != 0){
                up = grid[row][i].d;
                break;
            }
        }

        int notZeros = 0;

        if(left!=0)
            notZeros++;
        if(right!=0)
            notZeros++;
        if(up!=0)
            notZeros++;
        if(down!=0)
            notZeros++;

        if(notZeros == 0)
            return 0.0;
        return (left + right + up + down) / (1.0 * notZeros);
    }

    private static void eliminateParticipants(Cell[][] grid){
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                double averageD = calculateAverageD(grid, i, j);
                if(averageD > grid[i][j].d) {
                    grid[i][j].isEliminated = true;
                }
            }
        }
    }

    private static long solve(Cell[][] grid){
        boolean flag = true;
        long totalInterest = 0;

        while(flag){
            eliminateParticipants(grid);
            totalInterest += calculateRoundInterest(grid);
            flag = clearEliminated(grid);
        }
        return totalInterest;
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int r = input.nextInt();
            int c = input.nextInt();
            Cell[][] grid = new Cell[r][c];
            for(int j=0; j<r; j++){
                for(int k=0; k<c; k++){
                    int d = input.nextInt();
                    grid[j][k] = new Cell(d);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(grid));
        }
    }
}