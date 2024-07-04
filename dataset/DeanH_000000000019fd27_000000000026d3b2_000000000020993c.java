import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int mat[][] = new int[n][n];
        
     
        for(int j = 0; j < n; j++){
            for(int l = 0; l < n; l++){
                mat[j][l] = in.nextInt();
            }
        }
        
        int trace = 0;
        for(int k = 0; k < n; k++){
            trace += mat[k][k];
        } 
        
        int rowCount = 0;
        for(int a = 0; a < mat.length; a++){
            HashSet<Integer> rowDups = new HashSet<Integer>();
            boolean hasDups = false;
            for(int s = 0; s < mat[a].length; s++){
                if(!rowDups.contains(mat[a][s])) {
                   rowDups.add(mat[a][s]); 
                } else {
                    hasDups = true;
                }
            }
            if(hasDups == true) {
                ++rowCount;
            }
            
        }
        
        int colCount = 0;
        for(int d = 0; d < mat.length; d++){
            HashSet<Integer> colDups = new HashSet<Integer>();
            boolean hasColDups = false;
            for(int f = 0; f < mat[d].length; f++){
                if(!colDups.contains(mat[f][d])) {
                   colDups.add(mat[f][d]); 
                } else {
                    hasColDups = true;
                }
            }
            if(hasColDups == true) {
                ++colCount;
            }
            
        }
        
        System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + 
        colCount);
        
        
     }
    }
}