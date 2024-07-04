import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        in.nextLine(); 
        int[][] matrix = new int[n][n];    
        for(int j = 0; j < n; ++j) {
            String[] temp = in.nextLine().split("\\s");
            for(int k=0; k < temp.length; k++) {
                matrix[j][k] = Integer.parseInt(temp[k]);
            }
        }
        
        int trace = 0;
        int r = 0;
        int c = 0;
        for(int m=0; m < n; m++) {
            Map rowMap = new HashMap<Integer, Integer>();
            boolean rowDuplicated = false;
            for(int l=0; l < n; l++) {
                if(m==l) {
                    trace += matrix[m][l];
                }
                if(rowMap.containsKey(matrix[m][l])) {
                    rowDuplicated = true;
                }
                else {
                    rowMap.put(matrix[m][l], matrix[m][l]);
                }
            }
            if(rowDuplicated) {
                r += 1;
            }
        }
        
        for(int p=0; p < n; p++) {
            Map rowMap = new HashMap<Integer, Integer>();
            boolean colDuplicated = false;
            for(int q=0; q < n; q++) {
                if(rowMap.containsKey(matrix[q][p])) {
                    colDuplicated = true;
                }
                else {
                    rowMap.put(matrix[q][p], matrix[q][p]);
                }
            }
            if(colDuplicated) {
                c += 1;
            }
        }
        
        System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
    }
  }
}