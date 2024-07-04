import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no_of_testcase = sc.nextInt();
        
        for (int count = 1; count <= no_of_testcase; count++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += a[i][i];
            }
            
            int r = 0, c = 0;
            
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    rowSet.add(a[i][j]);
                    colSet.add(a[j][i]);
                }
                
                if (rowSet.size() < n) {
                    r++;
                }
                if (colSet.size() < n) {
                    c++;
                }
            }
            
            System.out.println("Case #" + count + ": " + trace + " " + r + " " + c);
        }
        
        sc.close();
    }
}