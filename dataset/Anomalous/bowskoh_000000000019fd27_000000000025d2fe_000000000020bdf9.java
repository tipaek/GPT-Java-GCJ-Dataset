import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    static class Period implements Comparable<Period> {
        int start;
        int end;
        int index;

        public Period(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Period other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private static void solve() throws Exception {
        int periodCount = nextInt();
        List<Period> periods = new ArrayList<>();
        char[] schedule = new char[periodCount];

        for (int i = 0; i < periodCount; i++) {
            int start = nextInt();
            int end = nextInt();
            periods.add(new Period(start, end, i));
        }

        Collections.sort(periods);

        boolean impossible = false;
        int cEnd = 0, jEnd = 0;

        for (Period period : periods) {
            if (period.start >= cEnd) {
                schedule[period.index] = 'C';
                cEnd = period.end;
            } else if (period.start >= jEnd) {
                schedule[period.index] = 'J';
                jEnd = period.end;
            } else {
                impossible = true;
                break;
            }
        }

        if (impossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(new String(schedule));
        }
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(br.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}