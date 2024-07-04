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
        
        String schedule = "";
        
        TreeMap<Integer, Integer> J_activities = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> C_activities = new TreeMap<Integer, Integer>();
        boolean j_possible = true;
        boolean c_possible = true;
        
        for (int i = 0; i < start_time.length; i++) {
            int activity_start = start_time[i];
            int activity_end = end_time[i];

            for (Map.Entry<Integer, Integer> j_entry : J_activities.entrySet()) {
                int j_entry_activity_start = j_entry.getKey();
                int j_entry_activity_end = j_entry.getValue();
                boolean start_overlap = j_entry_activity_start >= activity_start && j_entry_activity_start < activity_end;
                boolean end_overlap = j_entry_activity_end > activity_start && j_entry_activity_end <= activity_end;
                boolean outbound = j_entry_activity_start < activity_start && j_entry_activity_end > activity_end;
                if (start_overlap || end_overlap || outbound) {
                    j_possible = false;
                    break;
                }
                j_possible = true;
            }
            if (j_possible) {
                J_activities.put(activity_start,activity_end);
                schedule += "J";
            } else {
                for (Map.Entry<Integer, Integer> c_entry : C_activities.entrySet()) {
                    int c_entry_activity_start = c_entry.getKey();
                    int c_entry_activity_end = c_entry.getValue();
                    boolean start_overlap = c_entry_activity_start >= activity_start && c_entry_activity_start < activity_end;
                    boolean end_overlap = c_entry_activity_end > activity_start && c_entry_activity_end <= activity_end;
                    boolean outbound = c_entry_activity_start < activity_start && c_entry_activity_end > activity_end;
                    if (start_overlap || end_overlap || outbound) {
                        c_possible = false;
                        break;
                    }
                    c_possible = true;
                }
                if (c_possible) {
                    C_activities.put(activity_start,activity_end);
                    schedule += "C";
                }
            }
            if (!j_possible && !c_possible) {
                schedule = "IMPOSSIBLE";
                break;
            }
        }
        return schedule;
    }
}