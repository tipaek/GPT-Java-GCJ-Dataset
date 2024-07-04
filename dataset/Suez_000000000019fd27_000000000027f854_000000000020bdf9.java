import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            Time[] times = new Time[N];
            for (int i=0; i<N; i++) {
                times[i] = new Time();
                times[i].s = in.nextInt();
                times[i].e = in.nextInt();
                times[i].indx = i;
            }
            Arrays.sort(times);


            Output[] outputs = new Output[N];
            for (int i=0; i<N; i++) {
                outputs[i] = new Output();
            }

            char current = 'C';
            outputs[0].out = current;
            outputs[0].indx = times[0].indx;
            int error = 0;
            for (int i=1; i<N; i++) {
                if (times[i-1].e > times[i].s) {
                    current = current == 'C' ? 'J' : 'C';
                    if (i>1 && times[i-2].e > times[i].s) {
                        error = 1;
                    }
                }
                outputs[i].out = current;
                outputs[i].indx = times[i].indx;
            }

            Arrays.sort(outputs);
            StringBuilder out = new StringBuilder();
            for (int i=0; i<N; i++) {
                out.append(outputs[i].out);
            }
            System.out.println(String.format("Case #%s: %s", t+1, error == 1 ? "IMPOSSIBLE" : out.toString()));
        }
    }

    static class Time implements Comparable<Time> {
        Integer indx;
        Integer s;
        Integer e;
        @Override
        public int compareTo(Time o) {
            return this.s.compareTo(o.s);
        }
    }

    static class Output implements Comparable<Output> {
        Integer indx;
        Character out;
        @Override
        public int compareTo(Output o) {
            return this.indx.compareTo(o.indx);
        }
    }
}
