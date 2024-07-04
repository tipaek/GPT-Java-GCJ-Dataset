import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= t; c++) {
            int n = Integer.parseInt(br.readLine());
            char[] day = new char[24 * 60 + 1];
            Arrays.fill(day, '0');

            int[][] time = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().trim().split("\\s+");
                time[i][0] = Integer.parseInt(str[0]);
                time[i][1] = Integer.parseInt(str[1]);
            }

            boolean isPossible = true;
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = time[i][0];
                int end = time[i][1];
                String s = new String(day, start, end - start + 1);

                if (!s.contains("1")) {
                    res.append('C');
                    Arrays.fill(day, start, end, '1');
                } else if (!s.contains("2")) {
                    res.append('J');
                    Arrays.fill(day, start, end, '2');
                } else {
                    System.out.println("Case #" + c + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + c + ": " + res.toString());
            }
        }
    }
}