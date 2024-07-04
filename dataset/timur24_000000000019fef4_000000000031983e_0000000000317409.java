import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String[] m = in.next().split("");
            int res = 0;
            boolean b = false;
            for (String s : m) {
                if (s.equals("N")) y++;
                else if (s.equals("S")) y--;
                else if (s.equals("E")) x++;
                else x--;
                res++;
                if (res >= Math.abs(x) + Math.abs(y)) {
                    b = true;
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + (b ? res : "IMPOSSIBLE"));
        }
        in.close();
    }
}
