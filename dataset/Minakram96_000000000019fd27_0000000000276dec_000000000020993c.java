import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static int k, r, c = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            solve(n, in);
            int temp = i + 1;
            System.out.println("Case #" + temp + ": " + k + " " + r + " " + c);
        }
    }

    private static void solve(int n, Scanner in) {
        Set<Integer>[] matrix = new Set[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> currentRowSum = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int numb = in.nextInt();
                currentRowSum.add(numb);
                matrix[j].add(numb);
                if (i == j)
                    k += numb;
            }
            if (currentRowSum.size() < n) {
                r++;
            }
        }
        c = (int) Arrays.stream(matrix).filter(i -> i.size() < n).count();
    }
}
