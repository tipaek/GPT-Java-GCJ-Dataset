import java.util.*;

public class Solution {

    static class Activity {
        public int start;
        public int end;

        public Activity (int start, int end) {
            this.start = start;
            this.end = end;
        }
    } 

  
    static class SortByStart implements Comparator<Activity> 
    { 
        // Used for sorting in ascending order of 
        // start time
        public int compare(Activity a, Activity b) 
        { 
            return a.start - b.start; 
        } 
    } 
      
    public static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        
        int numBooked = 0;
        int cEnd = 0;
        int jEnd = 0;
        String ans = "";
        boolean imps = false;

        List<Activity> sortedActivities = new ArrayList<Activity>();
        List<Activity> unsortedActivities = new ArrayList<Activity>();
        Map<Activity, String> map = new HashMap<>();

        for (int i = 0; i < n;i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            
            Activity act = new Activity(start, end);
            unsortedActivities.add(act);
            sortedActivities.add(act);
        }

        Collections.sort(sortedActivities, new SortByStart());

        for (int i = 0; i < n;i++) {
            Activity act = sortedActivities.get(i);
            int start = act.start;
            int end = act.end;

            if (start >= cEnd) {
                map.put(act, "C");
                 cEnd = end;
            } else if (start >= jEnd) {
                map.put(act, "J");
                jEnd = end;
            } else {
                imps = true;
            }
        }
        if (imps) { return "IMPOSSIBLE"; }
        for (Activity act: unsortedActivities) {
            ans += map.get(act);
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, solve(input)));
        }

        
    }
}