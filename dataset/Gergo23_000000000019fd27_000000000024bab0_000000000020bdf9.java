import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    
    public static Comparator<Activity> ActivityReorder = new Comparator<Activity>() {
        @Override
        public int compare(Activity o1, Activity o2) {
            return Integer.compare(o1.ID, o2.ID);
        }
    };
    
    public static Comparator<Activity> ActivityTimeOrder = new Comparator<Activity>() {
        @Override
        public int compare(Activity o1, Activity o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };
    
    
    
    static class Activity {
        public int start;
        public int end;
        public int ID;
        public char person;
    
        public Activity(int start, int end, int ID) {
            this.start = start;
            this.end = end;
            this.ID = ID;
        }
    
        @Override
        public String toString() {
            return start + "";
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            Activity[] activities = new Activity[n];
            for(int i = 0; i < n; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            solve(activities, ks);
        }
    }
    
    public static void solve(Activity[] activities, int ks) {
        Arrays.sort(activities, ActivityTimeOrder);
        boolean[] doneTasks = new boolean[activities.length];
        Arrays.fill(doneTasks, false);
        
        int concurrentTasks = 0;
        boolean COccupied = false;
        
        for(int i = 0; i < activities.length; i++) {
            concurrentTasks++;
            for(int j = 0; j < i; j++) {
                if(!doneTasks[j] && activities[j].end <= activities[i].start) {
                    System.out.println("finished");
                    doneTasks[j] = true;
                    if(activities[j].person == 'C') COccupied = false;
                    concurrentTasks--;
                }
            }
            if(concurrentTasks > 2) {
                System.out.println("Case #" + ks + ": " + "IMPOSSIBLE");
                return;
            }
            
    
            if(!COccupied) {
                activities[i].person = 'C';
                COccupied = true;
            } else {
                activities[i].person = 'J';
            }
        }
        Arrays.sort(activities, ActivityReorder);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < activities.length; i++) {
            sb.append(activities[i].person);
        }
        System.out.println("Case #" + ks + ": " + sb.toString());
    }
    
}