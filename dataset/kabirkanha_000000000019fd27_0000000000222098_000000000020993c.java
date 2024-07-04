import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt=0;
        while (T > 0) {
            --T;
            ++cnt;
            int N = scanner.nextInt();
            int mat[][] = new int[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            int r = 0;
            int c = 0;
            int k = 0;
            for (int i = 0; i < N; ++i) {
                HashSet<Integer> set = new HashSet<>(N);
                for (int j = 0; j < N; ++j) {
                    set.add(mat[i][j]);

                    if (i == j)
                        k += mat[i][j];
                }
                if (set.size()!=N)
                    r++;
            }
            for (int j = 0; j < N; ++j) {
                HashSet<Integer> set = new HashSet<>(N);
                for (int i = 0; i < N; ++i) {
                    set.add(mat[i][j]);
                }
                if (set.size()!=N)
                    c++;
            }
            System.out.println("Case #"+cnt+": "+k + " " + r + " " + c);
        }
    }
}
