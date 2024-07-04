
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.compare;


public class Solution {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String result = "IMPOSSIBLE";
            boolean impossible = false;


            int N = sc.nextInt();
            TreeSet<Event> events = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                events.add(new Event(s, i, 1));
                events.add(new Event(e, i, 0));
            }
            Set<Integer> active = new HashSet<>();
            String[] names = new String[N];

            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event e = iterator.next();
                if(e.type == 0) { // end
                    active.remove(e.activityID);
                }
                else { // start
                    if(active.size() == 2) {
                        impossible = true;
                        break; // IMPOSSIBLE;
                    }
                    if(active.size() == 0) {
                        names[e.activityID] = "C";
                    }
                    if(active.size() == 1) {
                        String current = names[active.iterator().next()];
                        if(current.equals("C")) {
                            names[e.activityID] = "J";
                        }
                        if(current.equals("J")) {
                            names[e.activityID] = "C";
                        }
                    }
                    active.add(e.activityID);
                }

            }

            if(!impossible) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < N; i++) {
                    sb.append(names[i]);
                }
                result = sb.toString();
            }



            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static class Event implements Comparable<Event>{
        int time;
        int activityID;
        int type; // 0 == end, 1 == start;

        public Event(int time, int i, int i1) {
            this.time = time;
            activityID = i;
            type = i1;
        }

        @Override
        public int compareTo(Event o) {
            int c = compare(time, o.time);
            if(c != 0) return c;

            c = compare(type, o.type);
            if(c != 0) return c;

            c = compare(activityID, o.activityID);
            return c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Event event = (Event) o;

            if (time != event.time) return false;
            if (activityID != event.activityID) return false;
            return type == event.type;
        }

        @Override
        public int hashCode() {
            int result = time;
            result = 31 * result + activityID;
            result = 31 * result + type;
            return result;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "time=" + time +
                    ", activityID=" + activityID +
                    ", type=" + type +
                    '}';
        }
    }

}
