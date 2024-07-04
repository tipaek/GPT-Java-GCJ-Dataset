import java.util.*;
class Solution{
    
    static void getVestigium(int[][] grid, int current){
        int[] sol = new int[3];
        int n = grid.length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0; i < n; i ++){
            sol[0] += grid[i][i];
            for(int j = 0; j < n; j ++){
                row.add(grid[i][j]);
                col.add(grid[j][i]);
            }
            if(row.size() < n){
                sol[1] ++;
            }
            if(col.size() < n){
                sol[2] ++;
            }
            row.clear();
            col.clear();
        }
        System.out.print("Case #");
        System.out.print(current + ": ");
        System.out.print(sol[0] + " " );
        System.out.print(sol[1] + " " );
        System.out.println(sol[2] + " " );
    }
    
    public static void main(String[] args){
        Scanner ip = new Scanner(System.in);
        int tests = ip.nextInt();
        int current = 1;
        while(tests != 0){
            int size = ip.nextInt();
            int[][] grid = new int[size][size];
            for(int i = 0; i < size; i ++){
                for(int j = 0; j < size; j ++){
                    grid[i][j] = ip.nextInt();
                }
            }
            int[] sol = new int[3];
            Solution.getVestigium(grid, current);
            current ++;
            tests --;
        }
    }
}