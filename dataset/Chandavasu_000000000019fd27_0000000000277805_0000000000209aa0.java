import java.lang.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        int numOfTest = in.nextInt();
        
        for(int i = 0; i < numOfTest; i++) {
            
            int n = in.nextInt();
            int trace = in.nextInt();
            
            new Solution().createMatrix(i+1, n, trace);
        }
    }
    
    public void createMatrix(int test, int n, int trace) {
        
        ArrayList<Integer> vals = new ArrayList<Integer>();
        
        if(trace % n == 0) {
            
            System.out.println("Case #" + test + ": POSSIBLE");
        } else {
           
           System.out.println("Case #" + test + ": IMPOSSIBLE"); 
           return;
        }
            
        int d = trace/n;
        for(int i = 1; i <= n; i++) {
            if(i != d) {
                vals.add(i);
            }
        }
                
        int[][] matrix = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            int index = 0;
            for(int j = 0; j < n; j++) {
                
                if(i == j) {
                    
                    matrix[i][j] = d;
                } else {
                    
                    matrix[i][j] = vals.get(index);
                    index++;
                }
                
                System.out.print(matrix[i][j] + " ");
            }
            
            //shifts by one digit
            int r = vals.remove(0);
            vals.add(r);
            System.out.println();
        }
    }
}