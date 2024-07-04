import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;

public class Solution { 
    public static void main(String[] args) throws IOException { 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int x = 1; x <= T; ++x) {
            System.out.println("Case #"+x+": " + solve(reader));
        }
    }
    
    private static String solve(BufferedReader reader) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        Activity[] activities = new Activity[N];
        String[] schedule = new String[N];
        for (int i=0; i<N; ++i){
            String[] row = reader.readLine().split(" ");
            Integer start_time = Integer.parseInt(row[0]);
            Integer end_time = Integer.parseInt(row[1]);
            activities[i] = new Activity(i, start_time, end_time);
        }
        Arrays.sort(activities);
        int free_c = 0;
        int free_j = 0;
        
        for(Activity activity : activities) {
            int start_time = activity.start_time;
            int end_time = activity.end_time;
            if (start_time < free_j) {
                if (start_time < free_c) {
                    return "IMPOSSIBLE";
                } else {
                    free_c = end_time;
                    schedule[activity.index] = "C";
                }
            } else {
                free_j = end_time;
                schedule[activity.index] = "J";
            }
        }
        
        StringBuilder sb = new StringBuilder(N+1);
        for (String s : schedule) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    private static class Activity implements Comparable<Activity> {
        public final int index;
        public final int start_time;
        public final int end_time;
        
        public Activity(int index, int start_time, int end_time) {
            this.index = index;
            this.start_time = start_time;
            this.end_time = end_time;
        }
        
        public int compareTo(Activity ac) {
            return start_time - ac.start_time;
        }
    }
} 