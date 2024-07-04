import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main (String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] toks = reader.readLine().split(" ");
        int t = Integer.parseInt(toks[0]);
        for (int test = 0; test < t; test++) {
            String str = reader.readLine();
            int n = str.length();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str.split("")[i]);
            }
            StringBuilder sb = new StringBuilder("");
            sb.append("Case #");
            sb.append(test + 1);
            sb.append(": ");
            for (int i = 0; i < a[0]; i++) sb.append("(");
            sb.append(a[0]);
            if (n == 1) for (int i = 0; i < a[0]; i++) sb.append(")");
            else {
                for (int i = 1; i < n; i++) {
                    if (a[i] > a[i - 1]) {
                        for (int j = 0; j < a[i] - a[i - 1]; j++) {
                            sb.append("(");
                        }
                        sb.append(a[i]);
                    } else if (a[i - 1] > a[i]) {
                        for (int j = 0; j < a[i - 1] - a[i]; j++) {
                            sb.append(")");
                        }
                        sb.append(a[i]);
                    } else sb.append(a[i]);
                }
                for (int i = 0; i < a[n - 1]; i++) sb.append(")");
            }
            System.out.println(sb);

        }
    }
}
