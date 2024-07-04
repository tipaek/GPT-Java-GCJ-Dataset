import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner scanner = new Scanner(new BufferedReader(new FileReader("test_case.txt")));
        int nr = scanner.nextInt();
        for (int i = 0; i < nr; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String s = scanner.nextLine().trim();
            System.out.printf("Case #%d: %s\n", i+1, solve(x, y, s));
        }
    }

    private static String solve(int x, int y, String s) {
        int len  = s.length();
        int[][] pos = new int[len+1][2];
        pos[0][0] = x;
        pos[0][1] = y;
        for (int i = 1; i <= len; i++) {
            char c = s.charAt(i-1);
            if (c == 'S') {
                pos[i][1] = --y;
                pos[i][0] = x;
            } else if (c == 'N') {
                pos[i][1] = ++y;
                pos[i][0] = x;
            } else if (c == 'E') {
                pos[i][1] = y;
                pos[i][0] = ++x;
            } else {
                pos[i][1] = y;
                pos[i][0] = --x;
            }
        }
        for (int i = 0; i <= len; i++) {
            int[] cpos = pos[i];
            int distance = 0;
            distance += cpos[0] > 0 ? cpos[0] : -cpos[0];
            distance += cpos[1] > 0 ? cpos[1] : -cpos[1];
            if (distance <= i) {
                return String.valueOf(i);
            }
        }
        return "IMPOSSIBLE";
    }
}
