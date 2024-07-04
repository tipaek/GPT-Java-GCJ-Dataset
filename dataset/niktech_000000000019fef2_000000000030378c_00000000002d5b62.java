import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String smallest(ArrayList<String> l) {
        String first = l.get(0);
        for (int i = 1 ; i < l.size() ; i++) {
            if (l.get(i).length() < first.length()) {
                first = l.get(i);
            } // if
        } // for
        return first;
    }

    static String solve(int x, int y, int n, String s, int max) {
        if (n > max)
            return "IMPOSSIBLE";
        if (x == 0 && y == 0)
            return s;

        if (x == 0) {
            String s1 = solve(x, y+n, n*2, s+"S", max);
            String s2 = solve(x, y-n, n*2, s+"N", max);
            if (!s1.equals("IMPOSSIBLE") && !s2.equals("IMPOSSIBLE")) {
                if (s1.length() > s2.length())
                    return s2;
                return s1;
            }
            if (!s1.equals("IMPOSSIBLE"))
                return s1;
            return s2;
        }

        if (y == 0) {
            String s1 = solve(x+n, 0, n*2, s+"W", max);
            String s2 = solve(x-n, 0, n*2, s+"E", max);
            if (!s1.equals("IMPOSSIBLE") && !s2.equals("IMPOSSIBLE")) {
                if (s1.length() > s2.length())
                    return s2;
                return s1;
            }
            if (!s1.equals("IMPOSSIBLE"))
                return s1;
            return s2;
        }

        String s1 = solve(x, y+n, n*2, s+"S", max);
        String s2 = solve(x, y-n, n*2, s+"N", max);
        String s3 = solve(x+n, y, n*2, s+"W", max);
        String s4 = solve(x-n, y, n*2, s+"E", max);
        ArrayList<String> l = new ArrayList<>();
        if (!s1.equals("IMPOSSIBLE"))
            l.add(s1);
        if (!s2.equals("IMPOSSIBLE"))
            l.add(s2);
        if (!s3.equals("IMPOSSIBLE"))
            l.add(s3);
        if (!s4.equals("IMPOSSIBLE"))
            l.add(s4);
        if (l.isEmpty())
            return "IMPOSSIBLE";
        return smallest(l);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i=1; i<= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if ((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #" + i + ": " + solve(x,y,1,"", (Math.abs(x)+Math.abs(y))*2));
        }
    }
}