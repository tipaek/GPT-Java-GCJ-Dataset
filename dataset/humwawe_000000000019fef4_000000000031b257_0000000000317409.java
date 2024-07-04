import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %d";
        f:
        for (int cas = 1; cas <= n; cas++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int count = 0;
            int i = 0;
            int j = 0;
            for (char c : s.toCharArray()) {
                count++;
                if (c == 'N') {
                    j -= 1;
                } else if (c == 'S') {
                    j += 1;
                } else if (c == 'E') {
                    i -= 1;
                } else if (c == 'W') {
                    i += 1;
                }
                if (Math.abs(i - x) + Math.abs(j - y) <= count) {
                    System.out.println(String.format(result, cas, count));
                    continue f;
                }
            }
            System.out.println(String.format("Case #%d: %s", cas, "IMPOSSIBLE"));
        }
    }
}