import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            // Overrandomized
            int size = 10000;
            int u = in.nextInt();
            in.nextLine();
            long[] q = new long[size];
            String[] r = new String[size];
            for (int j=0; j<size; j++) {
                q[j] = in.nextLong();
                r[j] = in.nextLine().trim();
            }

            System.out.println("Case #" + i + ": "+overrandomized(u, q, r, size));
        }
    }

    private static String overrandomized(int u, long[] q, String[] r, int size) {
        Set[] candidates = new Set[10];
        Set dict = new HashSet<Character>(10);
        outer:
        for (int i=0; i<size; i++) {
            String curR = r[i];
            for (int j = 0; j < curR.length(); j++) {
                char c = curR.charAt(j);
                dict.add(c);
                if (dict.size()==10)
                    break outer;
            }
        }
        char[] d = new char[10];
        Arrays.fill(d, '*');
        for (int j=0; j<10; j++) {
            Set<Character> set = new HashSet<>(10);
            set.addAll(dict);
            candidates[j] = set;
        }
        for (int i=0; i<size; i++) {
            String curR = r[i];
            char firstChar = curR.charAt(0);
            candidates[0].remove(firstChar);
            long curQ = q[i];
            if (curQ != -1) {
                if (numberOfDigit(curQ)==curR.length()) {
                    while (curQ>=10) {
                        curQ /= 10;
                    }
                    int firstDigit = (int) curQ;
                    for (int j = firstDigit+1; j<10; j++) {
                        candidates[j].remove(firstChar);
                    }
                }
            }
        }

        dfs(d, q, r, candidates, dict, 0);

        String s = new String(d);
        return s;
    }

    private static boolean dfs(char[] d, long[] q, String[] r, Set[] candidates, Set dict, int curD) {
        if (curD > 9) {
            System.out.println("D = "+new String(d));
            return check(d, q, r);
        }

        Iterator i = candidates[curD].iterator();
        while (i.hasNext()) {
            char nextChar = (char) i.next();
            if (dict.contains(nextChar)) {
                dict.remove(nextChar);
                d[curD] = nextChar;
                if (dfs(d, q, r, candidates, dict, curD + 1)) {
                    return true;
                } else {
                    dict.add(nextChar);
                }
            }
        }
        return false;
    }

    private static boolean check(char[] d, long[] q, String[] r) {
        for (int i=0; i<r.length; i++) {
            long curQ = q[i];
            if (curQ > 0) {
                String curR = r[i];
                for (int j=0; j<10; j++) {
                    char c = d[j];
                    curR = curR.replace(c, (char) ('0'+j));
                }
                long realR = Long.parseLong(curR);
                if (curQ > realR) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int numberOfDigit(long curQ) {
        int count = 0;
        while (curQ>0) {
            curQ /= 10;
            count++;
        }
        return count;
    }
}