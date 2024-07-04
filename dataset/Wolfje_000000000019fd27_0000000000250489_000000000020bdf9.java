import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution problem = new Solution();
        problem.run(in);
    }

    public void run(Scanner in) {
        int tests = in.nextInt();
        for ( int t = 1; t <= tests; t++) {
            int n = in.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for(int i = 0; i < n; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }
            
            String result = solve(start, end);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }

    public String solve(int[] start, int[] end) {
        int n = start.length;
        char[] result = new char[n];
        PriorityQueue<Event> list = new PriorityQueue<>();
        for ( int i = 0; i < n; i++) list.add(new Event(start[i], i));
        LinkedList<Character> available = new LinkedList<>();
        available.add('J');
        available.add('C');
        while ( !list.isEmpty() ) {
            Event e = list.poll();
//            System.out.println(e);
            if ( e.start ) {
                if ( available.isEmpty()) return "IMPOSSIBLE";
                char c = available.poll();
                result[e.index] = c;
                list.add(new Event(end[e.index], c));
            } else {
                available.add(e.person);
            }
        }
        return new String(result);
    }

    public class Event implements Comparable<Event> {
        boolean start;
        int time, index;
        char person;
        Event(int t, int i ) {
            time = t;
            index = i;
            start = true;
            person = '.';
        }
        Event(int t, char c) {
            time = t;
            person = c;
            start = false;
        }

        @Override
        public int compareTo(Event o) {
            if ( time != o.time ) return time - o.time;
            if ( start != o.start ) return start ? 1 : -1;
            return Character.compare(person, o.person);
        }

        public String toString() {
            return String.format("time %d start %s index %d person %s", time, start, index, person);
        }
    }

}
