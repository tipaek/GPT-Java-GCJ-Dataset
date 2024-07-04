import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int c = 1; c <= t; c++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder day = new StringBuilder("0".repeat(24 * 60 + 1));

            int[][] time = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().trim().split("\\s+");
                time[i][0] = Integer.parseInt(str[0]);
                time[i][1] = Integer.parseInt(str[1]);
            }

            boolean isImpossible = false;
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = time[i][0];
                int end = time[i][1];
                String s = day.substring(start, end + 1);

                if (!s.contains("1")) {
                    res.append('C');
                    day.replace(start, end + 1, "1".repeat(end - start + 1));
                } else if (!s.contains("2")) {
                    res.append('J');
                    day.replace(start, end + 1, "2".repeat(end - start + 1));
                } else {
                    System.out.println("Case #" + c + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + c + ": " + res.toString());
            }
        }
    }
}