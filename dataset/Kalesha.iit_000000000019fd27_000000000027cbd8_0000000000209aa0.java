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
            if (n > 1 && trace % n == 0 && trace <= n * n) {
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
                    StringBuilder stringBuilder = new StringBuilder("");
                    String out = "";
                    for (int k = i; k > 0; k--) {
                        stringBuilder.append(a[n-k]).append(" ");
                    }
                    for (int j = 0; j < n - i; j++) {
                        stringBuilder.append(a[j]).append(" ");
                    }
                    System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
                }
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}