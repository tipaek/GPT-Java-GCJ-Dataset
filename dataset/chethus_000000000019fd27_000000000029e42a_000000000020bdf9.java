import java.io.*;
import java.util.*;
public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i ++) {
            int numTasks = Integer.parseInt(br.readLine());
            PriorityQueue<Event> events = new PriorityQueue<>();
            for (int j = 0; j < numTasks; j ++) {
                st = new StringTokenizer(br.readLine());
                Event start = new Event(Integer.parseInt(st.nextToken()), true, j);
                Event end = new Event(Integer.parseInt(st.nextToken()), false, j);
                events.offer(start);
                events.offer(end);
            }
            boolean cFree = true;
            boolean jFree = true;
            char[] arr = new char[numTasks];
            while (!events.isEmpty()) {
                Event cur = events.poll();
                if (!cur.start) {
                    if (arr[cur.ind] == 'C') {
                        cFree = true;
                    } else {
                        jFree = true;
                    }
                } else {
                    if (!cFree && !jFree) {
                        break;
                    } else {
                        if (cFree) {
                            arr[cur.ind] = 'C';
                            cFree = false;
                        } else {
                            arr[cur.ind] = 'J';
                            jFree = false;
                        }
                    }
                }
            }
            String output = (cFree || jFree) ? new String(arr) : "IMPOSSIBLE";
            System.out.println("Case #" + Integer.toString(i + 1) + ": " + output);
        }
    }
    static class Event implements Comparable<Event>{
        public int time;
        public boolean start;
        public int ind;
        public Event(int time, boolean start, int ind) {
            this.time = time;
            this.start = start;
            this.ind = ind;
        }
        public int compareTo(Event other) {
            int times = ((Integer)this.time).compareTo(other.time);
            if (times != 0) {
                return times;
            } else {
                if (this.start == other.start) {
                    return 0;
                } else if (!this.start) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
}
