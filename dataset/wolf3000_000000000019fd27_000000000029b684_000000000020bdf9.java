import apple.laf.JRSUIUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by birukoudzmitry on 04.04.20.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    public static class Act {
        int s;
        int e;
        int i;
    }

    private static String solve(Scanner in) {

        int n = in.nextInt();

        List<Act> acts = new ArrayList<>();
        Map<Integer, Integer> open = new HashMap<>();
        Map<Integer, Integer> close = new HashMap<>();

        TreeSet<Integer> points = new TreeSet<>();

        for (int i = 0; i < n; ++i) {

            int s = in.nextInt();
            int e = in.nextInt();
            int opened = open.getOrDefault(s, 0);
            int closed = close.getOrDefault(e, 0);

            open.put(s, opened + 1);
            close.put(e, closed + 1);

            Act act = new Act();
            act.s = s;
            act.e = e;
            act.i = i;
            acts.add(act);
            points.add(s);
            points.add(e);
        }

        int opened = 0;
        for (Integer p : points) {
            opened += open.getOrDefault(p, 0);
            opened -= close.getOrDefault(p, 0);
            if (opened > 2) {
                return "IMPOSSIBLE";
            }
        }

        Collections.sort(acts, (a, b) -> Integer.compare(a.s, b.s));
        char[] s = new char[n];

        int curr = 0;
        int[] free = new int[2];

        for(Act a:acts){
            if(free[curr] > a.s){
                curr = 1 - curr;
            }
            s[a.i] = getSymbol(curr);
            free[curr] = a.e;
        }

        return new String(s);
    }

    private static char getSymbol(int curr) {
        if(curr == 0){
            return 'C';
        }else{
            return 'J';
        }
    }

}

/**
 * 5
 99 150     J
 1 100      C
 100 301
 2 5        J
 150 250
 */
