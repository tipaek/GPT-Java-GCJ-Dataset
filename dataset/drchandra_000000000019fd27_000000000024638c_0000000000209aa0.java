import java.util.*;
import java.lang.*;

public class Solution{

    public static String latinSquare(int[][] mat, int n, int k){
        int trace = 0;
        int idx = 0;

        if(k > ((n * (n+1)) / 2))
            return "IMPOSSIBLE";

        while(trace < k){
            trace++;
            mat[idx][idx]++;
            idx++;
            idx %= n;
        }

        int firstVal = mat[0][0];
        int[] cyc = new int[n-1];
        for(int i=0;i<n-1;i++){
            cyc[i] = firstVal%n + 1;
            firstVal++;
        }
        
        for(int i=0;i<n;i++){
            int idx1 = i;
            for(int j=0;j<n;j++){
                if(i == j)  continue;
                mat[i][j] = cyc[(idx1++)%(n-1)];
            }
        }

        for(int i=0;i<n;i++){
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            for(int j=0;j<n;j++){
                if(rows.contains(mat[i][j]))
                    return "IMPOSSIBLE";
                else
                    rows.add(mat[i][j]);
                if(cols.contains(mat[j][i]))
                    return "IMPOSSIBLE";
                else
                    cols.add(mat[j][i]);
            }
        }

        return "POSSIBlE";
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int tc = Integer.parseInt(scan.nextLine());
        for(int t = 1; t <= tc; t++){
            String[] words = scan.nextLine().split(" ");
            int n = Integer.parseInt(words[0]);
            int k = Integer.parseInt(words[1]);
            int[][] mat = new int[n][n];
            String res = latinSquare(mat, n, k);
            System.out.println("Case #" + t + ": " + res);
            if(res.equals("IMPOSSIBLE"))
                continue;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }        
    }
}