import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Event[] events = new Event[N];
            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                events[j] = new Event(start, end, j);
            }

            Arrays.sort(events, Comparator.comparingInt(e -> e.start));

            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] schedule = new char[N];
            boolean possible = true;

            for (Event event : events) {
                if (event.start >= cameronEnd) {
                    schedule[event.index] = 'C';
                    cameronEnd = event.end;
                } else if (event.start >= jamieEnd) {
                    schedule[event.index] = 'J';
                    jamieEnd = event.end;
                } else {
                    possible = false;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }

            if (possible) {
                System.out.println(new String(schedule));
            }
        }
    }
}

class Event {
    int start;
    int end;
    int index;

    public Event(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}