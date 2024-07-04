import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();
            int[][] grid = new int[N][N];
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    grid[r][c] = sc.nextInt();
                }
            }
            
            int[] res = findLatinTrace(grid, N);
            System.out.println("Case #" + t + ": " + res[0] + " " + res[1] + " " + res[2]);
            
        }
    }
    
    public static int[] findLatinTrace(int[][] grid, int N) {
        int[] res = new int[3];
        if(N == 0){
            return res;
        }
        
        for(int i = 0; i < N; i++){
            
            res[0] += grid[i][i];
            Set<Integer> rowItems = new HashSet<>();
            
            for(int j = 0; j < N; j++){
                if(rowItems.contains(grid[i][j])){
                    res[1]++;
                    break;
                }
                rowItems.add(grid[i][j]);
            }

            Set<Integer> colItems = new HashSet<>();
            for(int j = 0; j < N; j++){
                if(colItems.contains(grid[j][i])){
                    res[2]++;
                    break;
                }
                colItems.add(grid[j][i]);
            }
        }
        
        return res;
    }
}