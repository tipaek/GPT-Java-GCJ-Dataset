import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        ParentingPartneringReturns ppr = new ParentingPartneringReturns();
        ppr.solve();
    }
}

class ParentingPartneringReturns {

    static class Activity implements Comparable<Activity> {
        int num, start, end;

        Activity(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity a) {
            if (this.start != a.start) return this.start - a.start;
            if (this.end != a.end) return this.end - a.end;
            return this.num - a.num;
        }

        @Override
        public String toString() {
            return "[" + num + ": " + start + " -> " + end + "]";
        }
    }

    private static final int MAXN = 1000;
    private static final char JAMIE = 'J';
    private static final char CAMERON = 'C';

    private final FScanner in;
    private final FPrinter out;
    private final ArrayList<Activity> activities;
    private final char[] result;

    ParentingPartneringReturns() throws IOException {
        in = new FScanner();
        out = new FPrinter();
        activities = new ArrayList<>();
        result = new char[MAXN];
    }

    void analyzeCase(int caseNumber) throws IOException {
        activities.clear();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(i, in.nextInt(), in.nextInt()));
        }

        Collections.sort(activities);

        int timeJ = 0, timeC = 0;
        boolean feasible = true;

        for (Activity activity : activities) {
            if (activity.start >= timeJ) {
                result[activity.num] = JAMIE;
                timeJ = activity.end;
            } else if (activity.start >= timeC) {
                result[activity.num] = CAMERON;
                timeC = activity.end;
            } else {
                feasible = false;
                break;
            }
        }

        String answer = feasible ? String.copyValueOf(result, 0, n) : "IMPOSSIBLE";
        out.printlnCase(caseNumber, answer);
    }

    void solve() throws IOException {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            analyzeCase(i);
        }
        out.close();
    }
}

class FScanner {
    private final StreamTokenizer in;

    FScanner() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}

class FPrinter {
    private final PrintWriter out;

    FPrinter() {
        out = new PrintWriter(System.out);
    }

    void printCase(int caseNumber) {
        out.print("Case #");
        out.print(caseNumber);
        out.print(": ");
    }

    void printlnCase(int caseNumber, String answer) {
        printCase(caseNumber);
        out.println(answer);
    }

    void close() {
        out.flush();
        out.close();
    }
}