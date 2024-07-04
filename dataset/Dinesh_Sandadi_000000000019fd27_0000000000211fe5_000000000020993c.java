import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void printAnswer(int T,int t, int r, int c){
        System.out.println("Case #" + T + ": " + t + " " + r +" " + c);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int count = 1;
        Solution s1 = new Solution();
        while(count <= T) {
            int N = sc.nextInt();

            int[][] grid = new int[N][N];

            int trace = 0;
            int rows = 0;

            for(int i = 0; i < N; i++){
                Set<Integer> visited =new HashSet<>();
                boolean flag = false;
                for(int j = 0; j < N; j++){
                    grid[i][j] = sc.nextInt();
                    if(i == j)
                        trace += grid[i][j];
                    if(visited.contains(grid[i][j]) && !flag){
                        ++rows;
                        flag = true;
                        
                    }
                    visited.add(grid[i][j]);
                }
            }

            int cols = 0;
            for(int j = 0; j < N; j++){
                Set<Integer> visited = new HashSet<>();
                boolean flag = false;
                for(int i = 0; i < N; i++){
                    if(visited.contains(grid[i][j]) && !flag){
                        flag = true;
                        cols++;
                    }
                    
                    visited.add(grid[i][j]);
                }
            }

            s1.printAnswer(count, trace, rows, cols);
            count++;
            
        }
        }
}
