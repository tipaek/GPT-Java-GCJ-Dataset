import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 1; i <= cases; i++) {
            List<Time> activities = activityFinder(input);
            String sol = looker(activities, input);
            System.out.println("Case #" + i + ": " + sol);
        }
    }
    
    public static List<Time> activityFinder(Scanner input) {
        int num = input.nextInt();
        List<Time> list = new LinkedList<>();
        for(int i = 0; i < num; i++) {
            list.add(new Time(i, input.nextInt(), input.nextInt()));
        }
        return list;
    }
    
    public static String looker(List<Time> activities, Scanner input) {
        Collections.sort(activities);
        char[] sol = new char[activities.size()];
        for(int i = 0; i < activities.size(); i++) {
            sol[i] = 'C';
        }
        for(int i = 1; i < activities.size(); i++) {
            if(activities.get(i).start < activities.get(i - 1).end) {
                if(sol[activities.get(i - 1).place] == 'J') {
                    return "IMPOSSIBLE";
                }
                sol[activities.get(i).place] = 'J';
            }
        }
        return new String(sol);
    }
    
    private static class Time implements Comparable<Time> {
        public int start;
        public int end;
        public int place;
        
        public Time(int place, int start, int end) {
            this.start = start;
            this.end = end;
            this.place = place;
        }
        public int compareTo(Time other) {
            return this.start - other.start;
        }
    }
}