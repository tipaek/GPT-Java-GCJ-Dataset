import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.util.Collections.min;

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

    static String solve(int x, int y, int n, String s) {
        if (n> 10)
            return "IMPOSSIBLE";
        if (x == 0 && y == 0)
            return s;

        if (x == 0) {
            String s1 = solve(x, y+n, n*2, s+"S");
            String s2 = solve(x, y-n, n*2, s+"N");
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
            String s1 = solve(x+n, 0, n*2, s+"W");
            String s2 = solve(x-n, 0, n*2, s+"E");
            if (!s1.equals("IMPOSSIBLE") && !s2.equals("IMPOSSIBLE")) {
                if (s1.length() > s2.length())
                    return s2;
                return s1;
            }
            if (!s1.equals("IMPOSSIBLE"))
                return s1;
            return s2;
        }

        String s1 = solve(x, y+n, n*2, s+"S");
        String s2 = solve(x, y-n, n*2, s+"N");
        String s3 = solve(x+n, y, n*2, s+"W");
        String s4 = solve(x-n, y, n*2, s+"E");
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

            System.out.println("Case " + i + ": " + solve(x,y,1,""));
        }
    }
}
