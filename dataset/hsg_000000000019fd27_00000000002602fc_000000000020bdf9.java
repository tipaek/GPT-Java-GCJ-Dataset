import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Solution {
    static Scanner in;
    static final String Cameron = "C";
    static final String Jamie = "J";
    
    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> activities = load(n);
            String schedule = assign(activities);
            System.out.println(String.format(
                "Case #%d: %s",
                i, schedule));
        }
    }
    
    static List<Activity> load(int n) {
        return IntStream.range(0, n)
            .mapToObj(i -> new Activity(in.nextInt(), in.nextInt()))
            .collect(Collectors.toList());
    }
    
    static String assign(List<Activity> activities) {
        int[] allMinutes = new int[24 * 60 + 1];
        
        for (Activity activity: activities) {
            allMinutes[activity.start] += 1;
            allMinutes[activity.end] -= 1;
        }
        
        int currentActivities = 0;
        for (int i = 0; i < allMinutes.length; i++) {
            currentActivities += allMinutes[i];
            allMinutes[i] = currentActivities;
            
            if (currentActivities > 2) {
                return "IMPOSSIBLE";
            }
        }
        
        return activities.stream()
            .mapToInt(a -> allMinutes[a.start])
            .mapToObj(current -> current == 1 ? Jamie : Cameron)
            .collect(Collectors.joining());
    }
    
    static class Activity {
        int start;
        int end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
  
}
  