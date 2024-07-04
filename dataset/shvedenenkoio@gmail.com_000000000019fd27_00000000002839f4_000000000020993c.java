import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    private int[][] matrix;
    
    private int k;
    private int r;
    private int c;
    
    public Solution(int[][] matrix) {
        this.matrix = matrix;
        calculateVestigium();
    }
    
    private void calculateVestigium() {
        for(int i = 0; i < matrix.length; i++) {
            k+= matrix[i][i];
            r+= repeatedNumbersRow(i);
            c+= repeatedNumbersColumn(i);
        }
    }
    
    private int repeatedNumbersRow(int row) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < matrix.length; i++) {
            int num = matrix[row][i];
            
            if(set.contains(num)) {
                return 1;
            }
            
            set.add(num);
        }
        
        return 0;
    }
    
    private int repeatedNumbersColumn(int column) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < matrix.length; i++) {
            int num = matrix[i][column];
            
            if(set.contains(num)) {
                return 1;
            }
            
            set.add(num);
        }
        
        return 0;
    }
    
    public VestigiumResult getResult() {
        return new VestigiumResult(k, r, c);
    }
    
    class VestigiumResult {
        int k, r, c;
        
        VestigiumResult(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();

          int[][] matri = new int[n][n];
          
          for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                matri[r][c] = in.nextInt();
            }
          }
          
          Solution v = new Solution(matri);
          
          VestigiumResult res = v.getResult();

          System.out.println("Case #" + i + ": " + res.k + " " + res.r + " " + res.c);
        }
    }
    
}
