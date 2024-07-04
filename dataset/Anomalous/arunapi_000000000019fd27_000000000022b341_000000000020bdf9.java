import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            Person cameron = new Person();
            Person jamie = new Person();
            StringBuilder schedule = new StringBuilder();
            
            boolean possible = true;
            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (cameron.addActivity(start, end)) {
                    schedule.append("C");
                } else if (jamie.addActivity(start, end)) {
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }

    static class Person {
        private Diary diary;
        
        Person() {
            diary = new Diary();
        }
        
        boolean addActivity(int start, int end) {
            Activity activity = new Activity(start, end);
            return diary.addActivity(activity);
        }
    }

    static class Diary {
        private List<Activity> activities;
        
        Diary() {
            activities = new ArrayList<>();
        }
        
        boolean addActivity(Activity activity) {
            if (isOccupied(activity)) {
                return false;
            }
            activities.add(activity);
            return true;
        }
        
        private boolean isOccupied(Activity activity) {
            for (Activity existingActivity : activities) {
                if (!(existingActivity.end <= activity.start || existingActivity.start >= activity.end)) {
                    return true;
                }
            }
            return false;
        }
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