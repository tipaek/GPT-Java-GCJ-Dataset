import java.util.*;

public class Solution {
    public static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String ans = "";

        // for cases in which the trace is all the same number
        for (int m = 1; m<=n; m++) {
            if (k == n*m) {
                ans += "POSSIBLE\n";
                int val = m;
                for (int i = 0; i < n; i++) {
                    val = m-i;
                    if (val <= 0) { val += n; }
                    for (int j = n; j > 0; j--) {
                        int num = val - j;
                        if (num <= 0) { num += n; }
                        ans += num + " ";
                    }
                    if (i == n-1) {
                        return ans;
                    }
                    ans += "\n";
                }
            }
        }

        // for traces that are a sum of diff numbers
        int trace = 0;
        if (n%2 == 1) {
            for (int i = 1; i<=n; i++) {
                trace += i;
            }
            if (k == trace) {
                ans += "POSSIBLE\n";
                int val = n;
                for (int i = 0; i < n; i++) {
                    val = n-i;
                    for (int j = 0; j < n; j++) {
                        int num = val - j;
                        if (num <= 0) { num += n; }
                        ans += num + " ";
                    }
                    if (i == n-1) {
                        return ans;
                    }
                    ans += "\n";
                }
            }
        } else {
            for (int i = 1; i<=n; i+=2) {
                trace += i;
            }
            
            if (k == trace) {
                ans += "POSSIBLE\n";
                int val = n;
                for (int i = 0; i < n; i++) {
                    val = n-i;
                    for (int j = 0; j < n; j++) {
                        int num = val - j;
                        if (num <= 0) { num += n; }
                        ans += num + " ";
                    }
                    if (i == n-1) {
                        return ans;
                    }
                    ans += "\n";
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }

        
    }
}