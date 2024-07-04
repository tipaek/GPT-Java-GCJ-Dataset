import java.util.Scanner;
import java.util.Vector;

import static java.lang.Math.pow;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for (int a = 1; a <= t; a++) {
            int x, y, i;
            Vector<String> vector = new Vector<>();
            String s = "";
            x = scan.nextInt();
            y = scan.nextInt();
            dfs(vector, s, 0, 0, x, y, 0);
            if (vector.size() == 0)
                System.out.println("Case #" + a + ": " + "IMPOSSIBLE");
            else {
                int mn = vector.get(0).length();
                String ss = vector.get(0);
                for (i = 1; i < vector.size(); i++) {
                    if (mn > vector.get(i).length()) {
                        mn = vector.get(i).length();
                        ss = vector.get(i);
                    }
                }
                System.out.println("Case #" + a + ": " + ss);
            }
        }
    }

    static void dfs(Vector<String> ans, String s, int i, int j, int x, int y, int c) {
        int temp1 = Math.abs(x);
        int temp2 = Math.abs(y);
        int count = temp1 + temp2;
        if (c >= count)
            return;
        if (i == x && j == y) {
            ans.add(s);
            return;
        }
        dfs(ans, s + "N", i, j + (int) pow(2, c), x, y, c + 1);
        dfs(ans, s + "S", i, j - (int) pow(2, c), x, y, c + 1);
        dfs(ans, s + "E", i + (int) pow(2, c), j, x, y, c + 1);
        dfs(ans, s + "W", i - (int) pow(2, c), j, x, y, c + 1);
    }
}
