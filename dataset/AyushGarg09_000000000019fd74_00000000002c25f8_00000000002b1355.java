import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public double getAvgSkill(double[][] grid, int m, int n){

        int neighbors = 0;
        int totalSkill = 0;

        for(int i = 0; i < direction.length; i++){
            int x = m + direction[i][0];
            int y = n + direction[i][1];

            int p = m;
            int q = n;
            while(x >= 0 && y >= 0 && x < grid.length && y < grid[m].length ){

              // System.out.println(x+":"+y+"  "+m+":"+n);

                if(grid[x][y] != 0) {
                    neighbors++;
                    totalSkill += grid[x][y];
                    break;
                }

                if(x == p-1){
                    p = x;
                    x--;
                }
                else if(x == p+1){
                    p = x;
                    x++;
                }
                else if(y == q-1) {
                    q = y;
                    y--;
                }
                else if(y == q+1){
                    q = y;
                    y++;
                }
            }
        }

        if(neighbors == 0) return 0;
//System.out.println(totalSkill);
        return (double)totalSkill/(double) neighbors;

    }

    public int getScore(double[][] grid){

        int result = 0;
        boolean go = false;

        //HashSet<Integer> markZero = new HashSet();

        while(true) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    result += grid[i][j];
                }
            }

          //System.out.println("Result :"+result);
           HashSet<Integer> markZero = new HashSet();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {

                    if(grid[i][j] != 0) {
                        double avgskill = this.getAvgSkill(grid, i, j);

                       // System.out.println(avgskill+ "pos: "+i + ","+j);

                        if (grid[i][j] < avgskill) {
                            markZero.add(i*grid[i].length + j);
                            go = true;
                        }
                    }

                }

            }

            for(int i: markZero){
                int x = i / grid[0].length;
                int y = i % grid[0].length;

                grid[x][y] = 0;
            }

//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[0].length; j++) {
//                    System.out.print(grid[i][j]+" ");
//                }
//                System.out.println();
//            }
//
//
//
//

            if (!go) return result;
            go = false;
        }

    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {

            int r = input.nextInt();
            int c = input.nextInt();

            double[][] grid = new double[r][c];
            for(int i = 0 ; i < r; i++){
                for(int j = 0; j < c; j++)
                    grid[i][j] = (double)input.nextInt();
            }
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[0].length; j++) {
//                    System.out.print(grid[i][j]+" ");
//                }
//                System.out.println();
//            }

            int result = new Solution().getScore(grid);
            System.out.println("Case #" + ks + ": " + result);
        }
    }
}
