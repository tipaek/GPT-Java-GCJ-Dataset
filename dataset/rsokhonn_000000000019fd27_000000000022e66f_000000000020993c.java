import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=0; tc<numTC; tc++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int k=0, r=0, c=0;
            
            for(int i=0; i<n; i++) {
                HashSet<Integer> setRow = new HashSet<Integer>();
                boolean rowHasDuplicate = false;
                
                HashSet<Integer> setCol = new HashSet<Integer>();
                boolean colHasDuplicate = false;
                
                for(int j=0; j<n; j++) {
                    if (i == j) 
                        k += matrix[i][j];
                    if (!rowHasDuplicate) {
                        if(setRow.contains(matrix[i][j]))
                            rowHasDuplicate = true;
                        else
                            setRow.add(matrix[i][j]);
                    }
                    
                    if (!colHasDuplicate) {
                        if(setCol.contains(matrix[j][i]))
                            colHasDuplicate = true;
                        else
                            setCol.add(matrix[j][i]);
                    }
                }
                if (rowHasDuplicate) r++;
                if (colHasDuplicate) c++;
            }
            
            System.out.println(k + " " + r + " " + c);
        }
    }
}