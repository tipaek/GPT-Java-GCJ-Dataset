import java.util.*;
import java.io.*;

public class Solution{
    public static int n;
    public static int[][] mat;
    public static void main(String[] args){
    
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int T = in.nextInt();
      for(int i = 0; i < T; i++){
        solve(in, i);
        }
    }

    public static void solve(Scanner in, int t){
        n = in.nextInt();
        int trace = 0;
        mat = new int[n][n];
        int badRows = 0;
        int badCols = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = in.nextInt();
            }
        }
    
        //Trace
        for(int i = 0; i < n; i++){
            trace += mat[i][i];
        }
    
        //badRows
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n; j++){
                if(!rowContains(i, j)){
                    badRows++;
                    break;
                }
            }
        }
    
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n; j++){
                if(!colContains(i, j)){
                    badCols++;
                    break;
                }
            }
        }
        t++;
        System.out.println("Case #" + t + ": " + trace + " " + badRows + " " + badCols);
    }   
    
    public static boolean rowContains(int i, int num){
        for(int j = 0; j < n; j++){
            if(mat[i][j] == num){
                return true;
            }
        }
        return false;
    }

    public static boolean colContains(int i, int num){
        for(int j = 0; j < n; j++){
            if(mat[j][i] == num){
                return true;
            }
        }
        return false;
    }
}