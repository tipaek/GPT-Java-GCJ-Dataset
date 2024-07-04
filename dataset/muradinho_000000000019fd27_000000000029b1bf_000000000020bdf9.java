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
            //int activity_start = start_time[i];
            //int activity_end = end_time[i];
            int c = start_time[i];
            int d = end_time[i];

            for (Map.Entry<Integer, Integer> j_entry : J_activities.entrySet()) {
                //int j_entry_activity_start = j_entry.getKey();
                //int j_entry_activity_end = j_entry.getValue();
                int a = j_entry.getKey();
                int b = j_entry.getValue();
                //boolean start_overlap = j_entry_activity_start >= activity_start && j_entry_activity_start < activity_end;
                //boolean end_overlap = j_entry_activity_end > activity_start && j_entry_activity_end <= activity_end;
                //boolean outbound = j_entry_activity_start < activity_start && j_entry_activity_end > activity_end;
                //boolean start_overlap = a >= c && a < d;
                //boolean end_overlap = b > c && b <= d;
                //boolean outbound = a < c && b > d;
                boolean condition_one = c >= b;
                boolean condition_two = a >= d;
                
                if (condition_one || condition_two) {
                    j_possible = true;
                } else {
                    j_possible = false;
                    break;
                }
            }
            if (j_possible) {
                J_activities.put(c,d);
                schedule += "C";
            } else {
                for (Map.Entry<Integer, Integer> c_entry : C_activities.entrySet()) {
                    //int c_entry_activity_start = c_entry.getKey();
                    //int c_entry_activity_end = c_entry.getValue();
                    int a = c_entry.getKey();
                    int b = c_entry.getValue();
                    //boolean start_overlap = c_entry_activity_start >= activity_start && c_entry_activity_start < activity_end;
                    //boolean end_overlap = c_entry_activity_end > activity_start && c_entry_activity_end <= activity_end;
                    //boolean outbound = c_entry_activity_start < activity_start && c_entry_activity_end > activity_end;
                    //boolean start_overlap = a >= c && a < d;
                    //boolean end_overlap = b > c && b <= d;
                    //boolean outbound = a < c && b > d;
                    boolean condition_one = c >= b;
                    boolean condition_two = a >= d;
                    if (condition_one || condition_two) {
                        c_possible = true;
                    } else {
                        c_possible = false;
                        break;
                    }
                }
                if (c_possible) {
                    C_activities.put(c,d);
                    schedule += "J";
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