import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Harry on 4/3/20.
 */
//https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
public class Solution {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int t=1; t<=T; t++){
            int N = scanner.nextInt();
            int[][] grid = new int[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    grid[r][c] = scanner.nextInt();
                }
            }
            int k = 0;
            int r = 0;
            int c = 0;

            for(int i=0; i<N; i++){
                HashSet<Integer> set = new HashSet();
                for(int j=0; j<N; j++){
                    if(set.contains(grid[i][j])){
                        r++;
                        break;
                    }
                    set.add(grid[i][j]);
                }
            }

            for(int i=0; i<N; i++){
                HashSet<Integer> set = new HashSet();
                for(int j=0; j<N; j++){
                    if(set.contains(grid[j][i])){
                        c++;
                        break;
                    }
                    set.add(grid[j][i]);
                }
            }

            for(int i=0; i<N; i++){
                k+=grid[i][i];
            }

            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
        }
    }
}
