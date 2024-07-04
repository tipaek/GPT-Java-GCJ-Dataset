import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    static String y = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            y = "";
            int n = in.nextInt();
            solve(n, in);
            int temp = i + 1;
            System.out.println("Case #" + temp + ": " + y);
        }
    }

    private static void solve(int n, Scanner in) {
        int c = -1;
        int j = -1;

        int start = -1;
        int end = -1;
        List<TimeEntry> times = new LinkedList<>();
        for (int i =0; i < n; i++){
            start = in.nextInt();
            end = in.nextInt();
            TimeEntry t = new TimeEntry(start, end);
            t.position = i;
            times.add(t);
        }

        times.sort(TimeEntry::compareTo);

        Iterator<TimeEntry> it = times.iterator();
        while (it.hasNext()) {
            TimeEntry t = it.next();
            start = t.start;
            end = t.end;
            if (c <= start) {
                t.doneBy = "C";
                c = end;
            } else if (j <= start) {
                t.doneBy = "J";
                j = end;
            } else {
                y = "IMPOSSIBLE";
                return;
            }
        }

        times = times.parallelStream().sorted((x,y) -> Integer.compare(x.position, y.position)).collect(Collectors.toList());
        y = times.stream().map(time-> time.doneBy).reduce((x,y) -> x+y).get();
    }

    private static class TimeEntry implements Comparable<TimeEntry>{
        int start;
        int end;
        int position;
        String doneBy;

        public TimeEntry(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(TimeEntry timeEntry) {
            return Integer.compare(this.start, timeEntry.start);
        }
    }
}
