import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String num = br.readLine();
            L = num.length();
            int[] nums = new int[L];
            for (int l = 0; l < L; l++) {
                nums[l] = num.charAt(l) - '0';
            }
            System.out.println("Case #" + (t+1) + ": " + solve(nums));
        }
        br.close();
    }

    public static String solve(int[] a) {
        int currentDepth = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L; i++) {
            int n = a[i];
            if (n == currentDepth) {
                sb.append(n);
                continue;
            }
            if (n >= currentDepth) {
                for (int j = currentDepth; j < n; j++) {
                    sb.append('(');
                    currentDepth++;
                }
                sb.append(n);
                continue;
            }
            for (int j = currentDepth; j > n; j--) {
                sb.append(')');
                currentDepth--;
            }
            sb.append(n);
        }

        if (currentDepth > 0) {
            for (int i = 0; i < currentDepth; i++) {
                sb.append(')');
            }
        }

        return sb.toString();
    }
}
