import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];

            for (int x = 0; x < n; x++) {
                start[x] = in.nextInt();
                end[x] = in.nextInt();
            }

            System.out.println("Case #" + i + ": " + solve(n, start, end));
        }
    }

    public static String solve(int n, int[] start, int[] end) {

        String[] cameron = new String[24 * 60 + 1];
        String[] james = new String[24 * 60 + 1];

        StringBuffer out = new StringBuffer();

        for (int i = 0; i < n; i++) {
            if (canAssign(cameron, start[i], end[i])) {
                assign("C", cameron, start[i], end[i]);
                out.append("C");
            } else if (canAssign(james, start[i], end[i])) {
                assign("J", james, start[i], end[i]);
                out.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return out.toString();
    }

    public static boolean canAssign(String[] person, int start, int end) {

        for (int i = start; i < end; i++) {
            if (person[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void assign(String s, String[] person, int start, int end) {
        for (int i = start; i < end; i++) {
            person[i] = s;
        }
    }
}
