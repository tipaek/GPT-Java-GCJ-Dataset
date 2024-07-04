import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            if (trace % n == 0 && trace <= n * n) {
                System.out.println("Case #" + t + ": POSSIBLE");
                int middle = trace / n;
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = i + 1;
                    if (i + 1 == middle) {
                        a[i] = a[0];
                        a[0] = i + 1;
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int k = i; k > 0; k--) {
                        System.out.print(a[n - k] + " ");
                    }
                    for (int j = 0; j < n - i; j++) {
                        System.out.print(a[j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}