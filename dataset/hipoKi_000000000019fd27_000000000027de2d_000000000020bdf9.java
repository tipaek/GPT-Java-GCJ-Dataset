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
                activities.add(new Pair(in.nextInt(), in.nextInt(), i));
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

            Character[] result = new Character[activities.size()];

            boolean possible = true;
            for (Pair activity : activities) {
                if (activity.first >= C) {
                    result[activity.pos] = 'C';
                    C = activity.second;
                } else if (activity.first >= J) {
                    result[activity.pos] = 'J';
                    J = activity.second;
                } else {
                    possible = false;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (possible) {
                for (int i = 0; i < activities.size(); i++) {
                    sb.append(result[i]);
                }
            } else {
                sb.append("IMPOSSIBLE");
            }
            out.println(String.format("Case #%d: %s", c, sb.toString()));
        }
    }

    static class Pair {

        int first;
        int second;
        int pos;

        Pair(int first, int second, int pos) {
            this.first = first;
            this.second = second;
            this.pos = pos;
        }


    }

}
