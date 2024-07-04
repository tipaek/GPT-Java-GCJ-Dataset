import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class CJ1 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int k = 1; k<=t; k++){
            String[] s_n = bf.readLine().trim().split(" ");
            int n = Integer.parseInt(s_n[0]);

            int[][] a = new int[n + 1][n + 1];
            for(int i=1;i<=n;i++) {
                String[] s_a = bf.readLine().trim().split(" ");
                for (int j = 1; j <= n; j++) {
                    a[i][j] =Integer.parseInt(s_a[j - 1]);
                }
            }

            solveForAns(t,a);
        }
    }

    public static void solveForAns(int testCaseNo, int[][] a){
        System.out.println("Case #"+testCaseNo+": "+calculateTrace(a)+" "+getDuplicateRowsNo(a)+" "+getDuplicateColumnsNo(a));
    }

    public static int calculateTrace(int[][] a){
        int n = a.length;
        int trace = 0;
        for(int i=1; i<n; i++){
            trace += a[i][i];
        }
        return trace;
    }

    public static int getDuplicateRowsNo(int[][] a){
        int duplicateRows = 0;
        int n = a.length;
        for(int i = 1; i < n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=1;j<n; j++){
                set.add(a[i][j]);
            }
            if(set.size()!=n-1)
                duplicateRows++;
        }
        return duplicateRows;
    }

    public static int getDuplicateColumnsNo(int[][] a){
        int duplicateColumns = 0;
        int n = a.length;
        for(int j = 1; j < n; j++){
            Set<Integer> set = new HashSet<>();
            for(int i=1;i<n; i++){
                set.add(a[i][j]);
            }
            if(set.size()!=n-1)
                duplicateColumns++;
        }
        return duplicateColumns;
    }


}
