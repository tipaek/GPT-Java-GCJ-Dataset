import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
		Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.valueOf(sc.nextLine());
            int[][] activities = new int[n][2];
            String input;
            for (int j = 0; j < n; j++) {
                input = sc.nextLine();
                activities[j][0] = Integer.valueOf(input.split(" ")[0]);
                activities[j][1] = Integer.valueOf(input.split(" ")[1]);
            }
            String result = s.getSchedule(activities);
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
    }
    
    public String getSchedule(int[][] activities) {
        int n = activities.length;
        Event[] events = new Event[2 * n];
        for (int i = 0; i < n; i++) {
            events[2 * i] = new Event(i, activities[i][0]);
            events[(2 * i) + 1] = new Event(i, activities[i][1]);
            events[(2 * i) + 1].start = events[2 * i];
        }
        Arrays.sort(events);
        
        // check
        char[] result = new char[n];
        List<Character> workers = new LinkedList<Character>();
        workers.add('C');
        workers.add('J');
        for (Event event : events) {
            if (event.start == null) {
                if (workers.size() == 0) {
                    return "IMPOSSIBLE";
                }
                event.executor = workers.remove(0);
                result[event.index] = event.executor;
            } else {
                workers.add(event.start.executor);
            }
        }
        //System.out.println(Arrays.toString(result));
        return new String(result);
    }
    
    class Event implements Comparable<Event>{
		Event start;
        int index;
        int time;
        char executor;
        public Event(int index, int time) {
            this.index = index;
            this.time = time;
        }
        
        public int compareTo(Event other) {
            int result = Integer.compare(this.time, other.time);
            if (result == 0) {
				result = Boolean.compare(this.start == null, other.start == null);
			}
			return result;
        }
    }
}
