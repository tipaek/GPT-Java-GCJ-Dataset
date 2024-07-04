import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        for (int cc = 0; cc < cases; cc++) {
            int t = Integer.parseInt(reader.readLine());

            List<Tuple> schedule = new ArrayList<>(t);
            for (int i = 0; i < t; i++) {
                String[] s = reader.readLine().split(" ");
                schedule.add(new Tuple(Integer.parseInt(s[0]), Integer.parseInt(s[1]), i));
            }
            Collections.sort(schedule);


            int cTime = Integer.MIN_VALUE;
            int jTime = Integer.MIN_VALUE;
            boolean impossible = false;

            for (int i = 0; i < schedule.size(); i++) {
                Tuple tuple = schedule.get(i);
                if (cTime <= tuple.a) {
                    tuple.c = 'C';
                    cTime = tuple.b;
                } else if (jTime <= tuple.a) {
                    tuple.c = 'J';
                    jTime = tuple.b;
                } else {
                    impossible = true;
                    break;
                }
            }
            StringBuilder r = new StringBuilder(t);
            if (impossible) {
                r.append("IMPOSSIBLE");
            } else {
                Collections.sort(schedule, Comparator.comparingInt(tuple -> tuple.i));

                for (Tuple tuple : schedule) {
                    r.append(tuple.c);
                }
            }

            System.out.printf("Case #%d: %s%n", cc + 1, r);
        }
    }

    static class Tuple implements Comparable<Tuple> {

        int a;
        int b;
        int i;
        char c;

        Tuple(int a, int b, int i) {
            this.a = a;
            this.b = b;
            this.i = i;
        }

        @Override
        public int compareTo(Tuple o) {
            int d = a - o.a;
            if (d == 0) {
                return b - o.b;
            }
            return d;
        }

        @Override
        public String toString() {
            return a + ", " + b;
        }
    }

}
