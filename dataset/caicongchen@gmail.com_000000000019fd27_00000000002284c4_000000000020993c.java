import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int N = in.nextInt(); // Matrix size N*N
        int k = 0, r = 0, c = 0;
        int[][] M = new int[N][N];

        Set<Integer> checkRow = new HashSet<>();

        for (int i = 1; i <= t; ++i) {
            for (int j = 0; j < N; ++j) {
                checkRow.clear();
                for (int z = 0; z < N; ++z) {
                    int n = in.nextInt(); // not use nextLine(), which will skip the first line;
                    M[j][z] = n;
                    checkRow.add(n);
                    if (j == z) {
                        k += n;
                    }
                }
                if (checkRow.size() != N) {
                    r++;
                }
            }
            System.out.println("Case #:" + i + " " + k + " " + r + " " + checkColumn(M, checkRow));
        }
    }

    static int checkColumn(int[][] M, Set<Integer> check) {
        int result = 0;
        for (int i = 0; i < M.length; ++i) {
            check.clear();
            for (int j = 0; j < M.length; ++j) {
                check.add(M[j][i]);
            }
            if (check.size() != M.length) {
                result++;
            }
        }

        return result;
    }

}