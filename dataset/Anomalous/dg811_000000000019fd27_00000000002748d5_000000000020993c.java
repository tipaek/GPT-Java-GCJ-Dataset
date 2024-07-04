import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            int sum = 0;
            int rmax = 0;
            int cmax = 0;
            int[][] arr = new int[n][n];
            
            // Read the matrix and calculate row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (!rowSet.add(arr[i][j]) && !rowHasDuplicate) {
                        rmax++;
                        rowHasDuplicate = true;
                    }
                }
            }
            
            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(arr[i][j]) && !colHasDuplicate) {
                        cmax++;
                        colHasDuplicate = true;
                    }
                }
            }
            
            // Calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }
            
            System.out.println(sum + " " + rmax + " " + cmax);
        }
        
        sc.close();
    }
}