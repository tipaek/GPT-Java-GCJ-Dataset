import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        
        String schedule = "";
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int numberOfActivities = in.nextInt();
            int start_time[] = new int[numberOfActivities];
            int end_time[] = new int[numberOfActivities];
            for (int activity = 0; activity < numberOfActivities; activity++) {
                start_time[activity] = in.nextInt();
                end_time[activity] = in.nextInt();
            }
            schedule = solution(start_time, end_time);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }
    
    public static String solution(int[] start_time, int[] end_time) {
        
        StringBuilder schedule = new StringBuilder();
        
        TreeMap<Integer, Integer> J_activities = new TreeMap<>();
        TreeMap<Integer, Integer> C_activities = new TreeMap<>();

        for (int i = 0; i < start_time.length; i++) {
            int c = start_time[i];
            int d = end_time[i];

            if (addInterval(c,d,J_activities)) {
                J_activities.put(c,d);
                schedule.append("J");
            } else if (addInterval(c,d,C_activities)) {
                C_activities.put(c,d);
                schedule.append("C");
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }
        return schedule.toString();
    }
    
    public static boolean addInterval(int c, int d, TreeMap<Integer, Integer> person) {
        boolean possible = true;
        for (Map.Entry<Integer, Integer> j_entry : person.entrySet()) {
            int a = j_entry.getKey();
            int b = j_entry.getValue();
            boolean start_overlap = a >= c && a < d;
            boolean end_overlap = b > c && b <= d;
            boolean outbound = a < c && b > d;

            if (start_overlap || end_overlap || outbound) {
                possible = false;
                break;
            }
        }
        return possible;
    }
}