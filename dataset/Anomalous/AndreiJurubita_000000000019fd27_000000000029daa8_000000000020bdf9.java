import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Writer writer = new PrintWriter(System.out);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Interval[] intervals = new Interval[N];
            List<Interval> sortedIntervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int S = scanner.nextInt();
                int E = scanner.nextInt();
                Interval interval = new Interval(S, E);
                intervals[i] = interval;
                sortedIntervals.add(interval);
            }

            sortedIntervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

            boolean impossible = false;
            int[] whosEnd = new int[2];

            for (Interval interval : sortedIntervals) {
                if (whosEnd[1] < whosEnd[0]) {
                    interval.who = 1;
                } else {
                    interval.who = 0;
                }

                if (interval.start < whosEnd[interval.who]) {
                    impossible = true;
                    break;
                }

                whosEnd[interval.who] = interval.end;
            }

            writer.write("Case #" + (t + 1) + ": ");
            if (impossible) {
                writer.write("IMPOSSIBLE");
            } else {
                for (Interval interval : intervals) {
                    writer.write(interval.who == 0 ? "C" : "J");
                }
            }
            writer.write(System.lineSeparator());
            writer.flush();
        }

        writer.close();
        scanner.close();
    }
}

class Interval {
    public int start;
    public int end;
    public int who = 0;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}