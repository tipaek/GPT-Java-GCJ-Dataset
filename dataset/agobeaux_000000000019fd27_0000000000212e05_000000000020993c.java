import java.util.*;
public class Solution {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            boolean dupl_row[] = new boolean[N];
            boolean dupl_col[] = new boolean[N];
            boolean rows_elems[][] = new boolean[N][N];
            boolean cols_elems[][] = new boolean[N][N];
            int k = 0;
            for(int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    int token = sc.nextInt()-1;
                    if (rows_elems[j][token]) {
                        dupl_row[j] = true;
                    }
                    rows_elems[j][token] = true;
                    if (cols_elems[l][token]) {
                        dupl_col[l] = true;
                    }
                    cols_elems[l][token] = true;
                    if (j == l) {
                        k += token+1;
                    }
                }
            }
            int r = 0, c = 0;
            for (int j = 0; j < N; j++) {
                if (dupl_col[j]) {
                    c++;
                }
                if (dupl_row[j]) {
                    r++;
                }
            }
            
            
            System.out.println(String.format("Case #%d: %d %d %d", i, k, r, c));
        }
    }
}
