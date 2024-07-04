import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int c = 1; c <= t; ++c) {
            int N = in.nextInt();

            List<Pair> activities  = new LinkedList<>();

            for (int i = 0; i <  N; i++) {
                activities.add(new Pair(in.nextInt(), in.nextInt()));
            }

            activities.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o2.first > o1.first) {
                        return -1;
                    } else if (o2.first < o1.first) {
                        return 1;
                    } else {
                        return o1.second - o2.second;
                    }
                }
            });

            int C = 0;
            int J = 0;

            StringBuilder sb = new StringBuilder();
            for (Pair activity : activities) {
                if (activity.first >= C) {
                    sb.append('C');
                    C = activity.second;
                } else if (activity.first >= J) {
                    sb.append('J');
                    J = activity.second;
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            out.println(String.format("Case #%d: %s", c, sb.toString()));
        }
    }

    static class Pair {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


    }

}
