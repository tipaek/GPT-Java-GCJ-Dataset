import java.util.*;
import java.io.*;

public class Solution {
    
    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for(int j=0; j<n; j++){
                activities.add(new Activity(in.nextInt(), in.nextInt(), j));
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(activities));    
        }
        in.close();
    }
    
    public static String solve(List<Activity> a){
        List<Activity> activities = new ArrayList<>(a);
        Collections.sort(activities);
        int cEndTime = 0;
        int jEndTime = 0;
        
        for(Activity curActivity : activities){
            if(cEndTime <= curActivity.startTime) {
                curActivity.person = 'C';
                cEndTime = curActivity.endTime;
            }else if(jEndTime <= curActivity.startTime) {
                curActivity.person = 'J';
                jEndTime = curActivity.endTime;
            }else {
                return IMPOSSIBLE;
            }
        }
        Collections.sort(activities, new IndexCompare());
        StringBuilder res = new StringBuilder();
        activities.forEach(curActivity -> res.append(curActivity.person));
        return res.toString();
    }
    
    public static class Activity implements Comparable<Activity>  {
        
        public final int startTime;
        public final int endTime;
        public final int index;
        public char person;
        
        public Activity(int startTime, int endTime, int index){
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
        
        @Override
        public int compareTo(Activity a){
            return this.startTime - a.startTime;
        }
        
    }
    
    public static class IndexCompare implements Comparator<Activity> {
        
        public int compare(Activity a1, Activity a2){
            return a1.index - a2.index;
        }
    }
    
    
    
}