import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int a = 1; a <= t; ++a) {
            int n = in.nextInt();
            ArrayList<SE> se = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                se.add(new SE(i, in.nextInt(), in.nextInt()));
            }
            se.sort(Comparator.comparing(SE::getS));
            int pc = 0, pj = 0;
            boolean poss = true;
            for (SE ac : se) {
                if (ac.s >= pc) {
                    ac.who = "C";
                    pc = ac.e;
                } else if (ac.s >= pj) {
                    ac.who = "J";
                    pj = ac.e;
                } else {
                    poss = false;
                    break;
                }
            }
            if (!poss) {
                System.out.printf("Case #%d: %s\n", a, "IMPOSSIBLE");
            } else {
                se.sort(Comparator.comparing(SE::getI));
                String res = se.stream().map(SE::getWho).collect(Collectors.joining());
                System.out.printf("Case #%d: %s\n", a, res);
            }
        }
    }


    static class SE {
        private final int i, s, e;
        String who;

        SE(int i, int s, int e) {
            this.i = i;
            this.s = s;
            this.e = e;
        }

        public int getI() {
            return i;
        }

        public int getS() {
            return s;
        }

        public String getWho() {
            return who;
        }
    }
}