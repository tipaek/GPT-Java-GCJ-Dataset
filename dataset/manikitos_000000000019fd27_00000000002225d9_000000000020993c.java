import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String... args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int k = 0;
            int r = 0;

            int[][] m = new int[n][n];
            Set<Integer> contains = new HashSet<>();
            for (int j1 = 0; j1 < n; j1++) {
                contains.clear();
                boolean found = false;
                for (int j2 = 0; j2 < n; j2++) {
                    int number = in.nextInt();
                    m[j1][j2] = number;
                    if (j1 == j2)
                        k += number;
                    if (!found) {
                        if (contains.contains(number)) {
                            found = true;
                            ++r;
                        } else
                            contains.add(number);
                    }
                }
            }
            int c = 0;
            for (int j2 = 0; j2 < n; j2++) {
                contains.clear();
                for (int j1 = 0; j1 < n; j1++) {
                    if (contains.contains(m[j1][j2])) {
                        ++c;
                        break;
                    } else
                        contains.add(m[j1][j2]);
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}