import java.io.*;
import java.util.*;

class Solution {

    public static boolean check(int[] a, int n, int k) {
        int trace = 0;
        for (int i = 0; i < n * n; i += (n + 1)) {
            trace += a[i];
        }
        if (trace != k) {
            return false;
        }

        int rows = 0, columns = 0;
        for (int i = 0; i < n * n; i += n) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = i; j < i + n; j++) {
                if (!rowSet.add(a[j])) {
                    rows++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = i; j < n * n; j += n) {
                if (!colSet.add(a[j])) {
                    columns++;
                    break;
                }
            }
        }

        return trace == k && rows == 0 && columns == 0;
    }

    public static boolean generate(int[] a, int n, int k, int idx) {
        if (idx == n * n) {
            if (check(a, n, k)) {
                System.out.println("POSSIBLE");
                for (int i = 0; i < n * n; i += n) {
                    for (int j = i; j < i + n; j++) {
                        System.out.print(a[j] + " ");
                    }
                    System.out.println();
                }
                return true;
            }
            return false;
        }

        for (int i = 1; i <= n; i++) {
            a[idx] = i;
            if (generate(a, n, k, idx + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int caseNumber = 1;
        while (t-- > 0) {
            System.out.print("Case #" + caseNumber + ": ");
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[] a = new int[n * n];

            if (!generate(a, n, k, 0)) {
                System.out.println("IMPOSSIBLE");
            }
            caseNumber++;
        }
    }
}