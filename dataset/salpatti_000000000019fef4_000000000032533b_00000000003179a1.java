import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

//ROUND 1C
public class Solution {

    public static void main(String[] args) {
        solveProblem2(System.in, System.out);
    }

    public static void solveProblem2(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sol = new StringBuilder();
            final int u = s.nextInt();
            final Map<Character, Integer> chars = new HashMap<>();
            if (u == 2) {
                for (int i = 0; i < 10000; i++) {
                    s.next();
                    String r = s.next();
                    for (char c : r.toCharArray()) {
                        if (chars.containsKey(c)) {
                            int act = chars.get(c);
                            chars.put(c, act + 1);
                        } else {
                            chars.put(c, 1);
                        }
                    }
                }
            } else {
                List<String> rs = new ArrayList<>(10000);
                for (int i = 0; i < 10000; i++) {
                    s.next();
                    String r = s.next();
                    rs.add(r);
                    char c = r.charAt(0);
                    if (chars.containsKey(c)) {
                        int act = chars.get(c);
                        chars.put(c, act + 1);
                    } else {
                        chars.put(c, 1);
                    }
                }
                //search 0
                for (String r : rs) {
                    for (char c : r.toCharArray()) {
                        if (!chars.containsKey(c)) {
                            chars.put(c, 1);
                        }
                    }
                }
            }

            TreeMap<Integer, Character> ordered = new TreeMap<>();
            //non funziona perché key puó essere uguale
            for (char key : chars.keySet()) {
                ordered.put(chars.get(key), key);
            }
            for (int key : ordered.descendingKeySet()) {
                sol.append(ordered.get(key));
            }

                char zero = sol.charAt(sol.length() - 1);
                sol = sol.deleteCharAt(sol.length() - 1);
                sol = new StringBuilder(zero + sol.toString());

            ps.print("Case #" + t + ": " + sol.toString());
            if (t != T) ps.println();
        }
    }

    public static void solveProblem1(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            final int x = s.nextInt();
            final int y = s.nextInt();
            final String m = s.next();
            int catx = x;
            int caty = y;
            int myx = 0;
            int myy = 0;
            final int steps = m.length();
            int nextcatmove = 0;
            int currmin = Integer.MAX_VALUE;
            boolean done = false;
            while (nextcatmove < steps) {
                char c = m.charAt(nextcatmove);
                if (c == 'N') {
                    caty++;
                } else if (c == 'S') {
                    caty--;
                } else if (c == 'W') {
                    catx--;
                } else if (c == 'E') {
                    catx++;
                }

                int currentsteps = nextcatmove + 1;
                int minutes = Math.abs(catx - myx) + Math.abs(caty - myy);
                if (minutes <= currentsteps) {
                    done = true;
                    if (currentsteps < currmin) {
                        currmin = currentsteps;
                    }
                }

                nextcatmove++;
            }
            if (done) {
                ps.print("Case #" + t + ": " + currmin);
            } else {
                ps.print("Case #" + t + ": " + "IMPOSSIBLE");
            }
            if (t != T) ps.println();
        }
    }

    public static void solveProblem3(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sol = new StringBuilder();
            ps.print("Case #" + t + ": " + sol.toString());
        }
    }
}
