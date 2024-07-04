import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    private static long[] solve(long[][] m) {
        int size = m.length;
        long sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += m[i][i];
        }

        long r = 0;
        for (int i = 0; i < size; ++i) {
            Set<Long> set = new HashSet<>();
            for (int j  = 0; j < size; ++j) {
                long val =  m[i][j];
                if (set.contains(val)) {
                    ++r;
                    break;
                } else  {
                    set.add(val);
                }
            }
        }

        long c = 0;
        for (int i = 0; i < size; ++i) {
            Set<Long> set = new HashSet<>();
            for (int j = 0; j < size; ++j) {
                long val =  m[j][i];
                if (set.contains(val)) {
                    ++c;
                    break;
                } else  {
                    set.add(val);
                }
            }
        }

        return new long[]{sum, r, c};
    }

    public static void main(String[] params)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            long[][] m = new long[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    m[j][k]  =  scanner.nextLong();
                }
            }
            long[] solution = solve(m);
            System.out.println(String.format("#%d: %d %d %d", i   + 1, solution[0], solution[1], solution[2]));
        }
    }
}
