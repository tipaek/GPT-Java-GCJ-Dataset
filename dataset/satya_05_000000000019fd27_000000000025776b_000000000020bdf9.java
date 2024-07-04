import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        String[] strings;
        // For each test case.
        for (int p=0; p<t; p++) {
            int n = Integer.parseInt(br.readLine());

            Event[] events = new Event[n];

            for (int i = 0; i < n; i++) {
                strings = br.readLine().split(" ");
                events[i] = new Event(
                    Integer.parseInt(strings[0]),
                    Integer.parseInt(strings[1]),
                    i);
            }

            Arrays.sort(events, new Comparator<Event>() {
                @Override
                public int compare(Event e1, Event e2) {
                    if (e1.end == e2.end) {
                        return e1.start - e2.start;
                    }
                    return e1.end - e2.end;
                }
            });

            boolean[] jamie = new boolean[24*60 + 1];
            boolean[] cameron = new boolean[24*60 + 1];

            boolean isImpossible = false;
            for (int i = 0; i < n; i++) {
                boolean isJamie = true;
                boolean isCameron = true;
                for (int j = events[i].start; j < events[i].end; j++) {
                    if (jamie[j] == true) { isJamie = false; }
                    if (cameron[j] == true) { isCameron = false; }
                }

                if (isJamie) {
                    events[i].assigned = 'J';
                    for (int j = events[i].start; j < events[i].end; j++) {
                        jamie[j] = true;
                    }
                } else if (isCameron) {
                    events[i].assigned = 'C';
                    for (int j = events[i].start; j < events[i].end; j++) {
                        cameron[j] = true;
                    }
                } else {
                    isImpossible = true;
                }
            }

            Arrays.sort(events, new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return o1.index - o2.index;
                }
            });

            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0; i<n; i++) {
                stringBuffer.append(events[i].assigned);
            }

            output(sb, p, isImpossible ? "IMPOSSIBLE" : stringBuffer.toString());
        }
        System.out.println(sb);
    }

    private static void output(StringBuffer sb, int testCase, String answer) {
        sb.append("Case #" + (testCase + 1) + ": " + answer +  "\n");
    }
}

class Event {
    int start;
    int end;
    char assigned;
    int index;

    public Event(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}