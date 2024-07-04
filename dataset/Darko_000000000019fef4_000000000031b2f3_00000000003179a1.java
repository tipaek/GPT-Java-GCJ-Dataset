import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int u = sc.nextInt();
            char[] m = new char[10];
            for (int i = 0; i < 10000; i++) {
                long q = sc.nextLong();
                char[] r = sc.next().toCharArray();
                for (int j = r.length - 1; j >= 0; j--) {
                    long d = q % 10;
                    q /= 10;
                    m[(int) d] = r[j];
                }
            }

            System.out.printf("Case #%d: %s\n", tc, String.copyValueOf(m));
        }
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
