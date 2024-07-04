
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        StringBuilder sb = new StringBuilder();
        int p;
        int n;
        char[] A;
        int J,C;
        Event[] events;
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            events = new Event[n];
            A = new char[n];
            J=0;
            C=0;
            for (int j = 0; j < n; j++) {
                events[j] = new Event(in.nextInt(), in.nextInt(), j);
            }
            Arrays.sort(events, Comparator.comparingInt(a -> a.start));
            boolean posible = true;
            for (int j = 0; j < n; j++) {
                final int min = Math.min(J, C);
                if (min > events[j].start) {
                    posible = false;
                    break;
                }
                if(min == J) {
                    A[events[j].i]='J';
                    J = events[j].end;
                } else {
                    A[events[j].i]='C';
                    C = events[j].end;
                }
            }
            if (posible) {
                System.out.println("Case #" + i + ": " +  new String(A));
            } else
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");


        }
    }

    static class Event {
        final int start;
        final int end;
        final int i;

        public Event(int start, int end, int i) {
            this.start = start;
            this.end = end;
            this.i = i;
        }
    }
}
