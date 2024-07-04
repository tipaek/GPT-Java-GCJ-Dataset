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
    
    public static String solution(int[] start_time_new, int[] end_time_new) {
        
        String schedule = "";
        
        int[] start_time = start_time_new.clone();
        int[] end_time = end_time_new.clone();

        HashMap<Integer, Integer> start_end_map = new HashMap<>();
        for(int indx=0; indx < start_time.length; indx++){
            start_end_map.put(start_time[indx], end_time[indx]);
        }
        Arrays.sort(start_time);

        for (int indx=0; indx < start_time.length; indx++){
            end_time[indx] = start_end_map.get(start_time[indx]);
        }

        TreeMap<Integer, Integer> J_activities = new TreeMap<>();
        TreeMap<Integer, Integer> C_activities = new TreeMap<>();

        for (int i = 0; i < start_time.length; i++) {
            int c = start_time[i];
            int d = end_time[i];

            if (addInterval(c,d,J_activities)) {
                J_activities.put(c,d);
                schedule += "J";
            } else if (addInterval(c,d,C_activities)) {
                C_activities.put(c,d);
                schedule += "C";
            } else {
                schedule = "IMPOSSIBLE";
                return schedule;
            }
        }
        String answer = "";
        for (int i = 0; i < start_time_new.length; i++) {
            int element = start_time_new[i];
            for (int j = 0; j < start_time.length; j++) {
                if (start_time[j] == element && end_time[j] == end_time_new[i]) {
                    answer += schedule.charAt(j);
                }
            }
        }
        return answer;
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