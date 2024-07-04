import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int N = 0;
        int k = 0, r = 0;
    
        Set<Integer> checkRow = new HashSet<>();
        List<String> result = new ArrayList<>();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            N = in.nextInt(); // Matrix size N*N
            int[][] M = new int[N][N];
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
            result.add("Case #" + i + ": " + k + " " + r + " " + checkColumn(M, checkRow));
            k = 0;
            r = 0;
        }
        for (String a : result) {
            System.out.println(a);
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