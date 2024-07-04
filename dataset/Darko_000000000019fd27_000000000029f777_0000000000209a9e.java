import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private void work() {
        Random rnd = new Random();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] spl = sc.nextLine().trim().split("\\s+");
        int t = Integer.parseInt(spl[0]);
        int b = Integer.parseInt(spl[1]);
        int[][] a = new int[4][b + 1];
        // 0 - no change
        // 1 - reverse
        // 2 - complement
        // 3 - reverse and complement
        while (t-- > 0) {
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                System.out.flush();
                int bit = Integer.parseInt(sc.nextLine().trim());
                a[0][i] = bit;
                a[1][b - 1 - i] = bit;
                a[2][i] = 1 - bit;
                a[3][b - 1 - i] = 1 - bit;
            }
            int queried = b;
            while (queried++ % 10 != 1) {
                System.out.println(1);
                System.out.flush();
                sc.nextLine();
            }

            int possible = 15;
            int pc = 4;
            for (int i = 1; i <= b; i++) {
                int s = 0;
                for (int j = 0; j < 4; j++) {
                    if (((1 << j) & possible) != 0) s += a[j][i];
                }
                if (s == 0 || s == pc) continue;
                System.out.println(i);
                System.out.flush();
                int bit = Integer.parseInt(sc.nextLine().trim());
                for (int j = 0; j < 4; j++) {
                    if (((1 << j) & possible) == 0) continue;
                    if (a[j][i] != bit) {
                        possible &= ~(1 << j);
                        pc--;
                    }
                }
                if (pc == 1) break;
            }

            for (int i = 0; i < 4; i++) {
                if (((1 << i) & possible) != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 1; j <= b; j++) sb.append(a[i][j]);
                    System.out.println(sb.toString());
                    System.out.flush();
                    char response = sc.nextLine().charAt(0);
                    if (response == 'N') System.exit(0);
                    break;
                }
            }
        }
        sc.close();
        System.out.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
