import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Solution {
    static Scanner in;
    //static final String cameron = "C";
    //static final String jamie = "J";
    
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
        int[] allMinutes = new int[24 * 60 + 2];
        
        for (Activity activity: activities) {
            allMinutes[activity.start] += 1;
            allMinutes[activity.end] -= 1;
        }
        
        List<Activity> jActivities = new ArrayList();
        Map<Integer, Activity> byStart = activities.stream()
            .collect(Collectors.toMap(
                a -> a.start,
                a -> a,
                (s, a) -> {
                    if (s.duration > a.duration) {
                        jActivities.add(a);
                        return s;
                    } else {
                        jActivities.add(s);
                        return a;
                    }
                }
            ));
            
        
        int currentActivities = 0;
        for (int i = 0; i < allMinutes.length; i++) {
            currentActivities += allMinutes[i];
            allMinutes[i] = currentActivities;
            
            if (currentActivities > 2) {
                return "IMPOSSIBLE";
            }
        }
        
        for (int i = 0; i < allMinutes.length; i++) {
            
            
            if (allMinutes[i] == 2) {
                Activity startingAct = byStart.get(i);
                jActivities.add(startingAct);
                for (int j = i; j <= startingAct.end; j++) {
                    allMinutes[j] -= 1;
                }
                if (byStart.containsKey(startingAct.end)) {
                    allMinutes[startingAct.end] += 1;
                }
            }
        }
        
        jActivities.forEach(a -> a.assignedTo = "J");
        
        return activities.stream()
            .map(a -> a.assignedTo)
            .collect(Collectors.joining());
    }
    
    static class Activity {
        int start;
        int end;
        int duration;
        String assignedTo = "C";
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.duration = end - start;
        }
    }
  
}
  