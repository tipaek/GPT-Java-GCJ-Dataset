import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            System.out.printf("Case #%d: ", t);
            int N = sc.nextInt();
            char[] s = new char[N];
            Event[] events = new Event[N];
            for (int i = 0; i < N; i++) {
                events[i] = new Event(sc.nextInt(), sc.nextInt(), i);
            }
            Arrays.sort(events);
            int C = 0, J = 0;
            boolean impossible = false;
            for (Event e : events) {
                if (C <= e.start) {
                    s[e.originalPos] = 'C';
                    C = e.end;
                } else if (J <= e.start) {
                    s[e.originalPos] = 'J';
                    J = e.end;
                } else{
                    impossible = true;
                    break;
                }
            }
            if(impossible){
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(s));
            }
        }
    }

    static class Event implements Comparable<Event> {
        int start, end, originalPos;

        Event(int start, int end, int originalPos) {
            this.start = start;
            this.end = end;
            this.originalPos = originalPos;
        }

        @Override
        public int compareTo(Event o) {
            return Integer.compare(start, o.start);
        }
    }
}
