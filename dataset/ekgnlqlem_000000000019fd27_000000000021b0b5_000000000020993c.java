import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int i = 1; i <= T; i++){
            int N = input.nextInt();
            int[][] mat = new int[N][N];
            HashSet<Integer> set = new HashSet();
            int trace = 0;
            for(int r = 0; r < N; r++){
                set = new HashSet();
                for(int c = 0; c < N; c++){
                    mat[r][c] = input.nextInt();
                    if(r == c) trace += mat[r][c];
                }
            }
            
            
            int k_row = 0, k_col = 0;
            for(int r = 0; r < N; r++){
                set = new HashSet();
                for(int c = 0; c < N; c++){
                    if(!set.add(mat[r][c])){
                        k_row++;
                        break;
                    }
                }
            }
            
            for(int r = 0; r < N; r++){
                set = new HashSet();
                for(int c = 0; c < N; c++){
                    if(!set.add(mat[c][r])){
                        k_col++;
                        break;
                    }
                }
            }
            
            
            System.out.println("Case #"+i+": "+trace+" "+k_row+" "+k_col);
        }
    }
}