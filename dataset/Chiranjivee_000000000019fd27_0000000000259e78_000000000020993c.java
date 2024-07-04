import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Problem1  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        int c = 1;        
        while (t-- > 0) {
            int n = sc.nextInt();
            int [][] mat = new int[n][n];
            int trace = 0;
            int rowsWithDupElements = 0;
            int colsWithDupElements = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                boolean dupRow = false;
                for (int j = 0; j < n; j++) {
                    int x = sc.nextInt();
                    if (set.contains(x)) {
                        dupRow =  true;
                    }

                    mat[i][j] = x;
                    set.add(x);
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
                if (dupRow) rowsWithDupElements++;
            }
            
            for (int i = 0; i <  n;  i++) {
                Set<Integer> set = new HashSet<>();
                boolean dupCol = false;
                for (int j  = 0;  j < n; j++) {
                    int x = mat[j][i];
                    if (set.contains(x)) {
                        dupCol = true;
                    }
                    set.add(x);
                }
                if (dupCol) colsWithDupElements++;
            }

            System.out.println(
                "Case #" + c++ + ": " + trace + " " + rowsWithDupElements + " " + colsWithDupElements);
        }
    }
}