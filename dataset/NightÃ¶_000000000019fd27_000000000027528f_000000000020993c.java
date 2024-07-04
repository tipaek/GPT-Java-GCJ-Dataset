import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class Solution{
    public static void vestigium(int[][] matrix, int N, int x) {
        int trace  = 0;
        int R = 0;
        int C = 0;
        for(int i=0; i < N; i++){
            trace += matrix[i][i];
        }
        for(int r = 0; r<N ; r++){
            int c = 0;
            HashSet<Integer> nums = new HashSet();
            while( c < N){
                if ( nums.contains(matrix[r][c])) {
                    R+=1 ;
                    break;
                }
                nums.add(matrix[r][c]);
                c++;
            }
        }
        for(int c = 0; c<N ; c++){
            int r = 0;
            HashSet<Integer> nums = new HashSet();
            while( r < N){
                if ( nums.contains(matrix[r][c])) {
                    C+=1 ;
                    break;
                }
                nums.add(matrix[r][c]);
                r++;
            }
        }
        System.out.println("Case #"+x+": "+trace+" "+ R+" "+ C);
    }

     public static void main(String []args){
        Solution sol = new Solution();
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        //stdin.nextLine();
        
        for(int t=0; t<T; t++){
            int N = stdin.nextInt();
            //stdin.nextLine();
            int[][] matrix = new int[N][N];
            for(int i=0; i < N; i++){
                //String line = stdin.nextLine();
                for(int j = 0; j < N; j ++){
                    matrix[i][j] = stdin.nextInt();
                    //System.out.print(matrix[i][j]+" ");
                 }
            }
            sol.vestigium(matrix, N, t+1);
        }
     }
}