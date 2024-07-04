import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[][] mat = getMatrix(n, in);
            int trace = getTrace(mat);
            int rowCount = getUnstructuredRowCount(mat);
            int columnCount = getUnstructuredColumnCount(mat);
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + columnCount);
        }
    }
    
    public static int[][] getMatrix(int n, Scanner in){
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = in.nextInt();
            }
        }
        return mat;
    }
    
    public static int getTrace(int[][] mat){
        int n = mat.length;
        int trace = 0;
        for (int i = 0; i < n; i++){
            trace += mat[i][i];
        }
        return trace;
    }
    
    public static int getUnstructuredRowCount(int[][] mat){
        int n = mat.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            boolean[] isPresent = new boolean[n+1];
            for(int j = 0; j < n; j++){
                if(isPresent[mat[i][j]]){
                    count++;
                    break;
                }else{
                    isPresent[mat[i][j]] = true;
                }
            }
        }
        return count;
    }
    
    public static int getUnstructuredColumnCount(int[][] mat){
        int n = mat.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            boolean[] isPresent = new boolean[n+1];
            for(int j = 0; j < n; j++){
                if(isPresent[mat[j][i]]){
                    count++;
                    break;
                }else{
                    isPresent[mat[j][i]] = true;
                }
            }
        }
        return count;
    }
    
}