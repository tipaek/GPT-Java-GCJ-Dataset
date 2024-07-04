import java.util.*;

class Activity {
    int start, end, index;
    String par = "";
}

class Solution {
    static void sortActivitiesByStart(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
    }

    static void sortActivitiesByIndex(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int p = 0; p < t; p++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity();
                activities[i].start = sc.nextInt();
                activities[i].end = sc.nextInt();
                activities[i].index = i;
            }
            
            sortActivitiesByStart(activities);
            boolean conflict = false;
            int cEnd = 0, jEnd = 0;
            
            for (Activity activity : activities) {
                if (activity.start < cEnd && activity.start < jEnd) {
                    conflict = true;
                    break;
                } else if (activity.start >= cEnd) {
                    activity.par = "C";
                    cEnd = activity.end;
                } else {
                    activity.par = "J";
                    jEnd = activity.end;
                }
            }
            
            sortActivitiesByIndex(activities);
            
            if (conflict) {
                System.out.println("Case #" + (p + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.par);
                }
                System.out.println("Case #" + (p + 1) + ": " + result);
            }
        }
        
        sc.close();
    }
}