import java.util.*;

public class Solution {
    
    static class Activity implements Comparable<Activity> {
        Integer start;
        Integer end;
        Integer pos;
        int person;
        
        public Activity (Integer start, Integer end, Integer pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
        
        @Override
        public int compareTo(Activity that) {
            return this.start.compareTo(that.start);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            for(int a = 1; a <= n; a++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt(), a));
            }
            Collections.sort(activities);
            
            boolean flag = false;
            int cameron = -1;
            int jamie = -1;
            char[] result = new char[n];
            
            for(Activity activity:activities) {
                if (cameron == -1 || cameron <= activity.start) {
                    cameron = activity.end;
                    activity.person = 0;
                } else if (jamie == -1 || jamie <= activity.start) {
                    jamie = activity.end;
                    activity.person = 1;
                } else {
                    flag = true;
                    break;
                }
                result[activity.pos-1] = (activity.person == 0) ? 'C' : 'J';
            }
            
            
            System.out.println("Case #" + testCase + ": " +
            (flag ? "IMPOSSIBLE" : String.valueOf(result)));
        }
    }
}
