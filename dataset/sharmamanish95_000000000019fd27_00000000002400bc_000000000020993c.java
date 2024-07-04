import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i<=t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int j = 0; j<n; j++) {
            	for(int k = 0; k<n; k++) {
            		arr[j][k] = sc.nextInt();
            	}
            }
            int[] ans = getTrace(arr, n);
            System.out.println("Case #"+ i +": " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
    
    static int[] getTrace(int[][] arr, int n) {
        int[] ans = new int[3];
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        for(int i = 0; i< n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            boolean rowDuplicate = false;
            boolean colDuplicate = false;
            for(int j = 0;  j<n ; j++) {
                if(i==j)
                    diagonalSum +=  arr[i][j];
                if(rowSet.contains(arr[i][j]))
                    rowDuplicate = true;
                else
                    rowSet.add(arr[i][j]);
                if(colSet.contains(arr[j][i]))
                	colDuplicate = true;
                else
                	colSet.add(arr[j][i]);
            }
            if(rowDuplicate==true)
                duplicateRows++;
            if(colDuplicate==true)
            	duplicateCols++;
        }
        
        ans[0] = diagonalSum;
        ans[1] = duplicateRows;
        ans[2] = duplicateCols;
        return ans;
    }
    
    
    
}
