import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int cas = 1; cas <= t; ++cas) {
            int n = in.nextInt();
            int[][] M = new int[n][n];
            for (int row = 0; row <= n - 1; row++) {
                for (int col = 0; col <= n - 1; col++) {
                    M[row][col] = in.nextInt();
                }
            }

            int k = 0;
            int r = 0;
            for (int row = 0; row <= n - 1; row++) {
                k += M[row][row];
                Set<Integer> checkSet = createCheckSet(n);
                for (int col = 0; col <= n - 1; col++) {
                    if (checkSet.contains(M[row][col])) {
                        checkSet.remove(M[row][col]);
                    } else {
                        r++;
                        break;
                    }
                }
            }
            int c = 0;
            for (int col = 0; col <= n - 1; col++) {
                Set<Integer> checkSet = createCheckSet(n);
                for (int row = 0; row <= n - 1; row++) {
                    if (checkSet.contains(M[row][col])) {
                        checkSet.remove(M[row][col]);
                    } else {
                        c++;
                        break;
                    }
                }
            }

            System.out.print("Case #" + cas + ": ");
            System.out.println(k + " " + r + " " + c);
        }
    }

    private static Set<Integer> createCheckSet(int n) {
        Set<Integer> checkSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            checkSet.add(i);
        }
        return checkSet;
    }
}
