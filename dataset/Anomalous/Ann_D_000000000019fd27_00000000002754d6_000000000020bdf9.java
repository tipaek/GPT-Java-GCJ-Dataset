import java.util.*;

class Activity {
    int start;
    int end;
    int index;
}

class Person {
    char name;
    Activity activity = new Activity();
    
    Person(char name) {
        this.name = name;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            Person cameron = new Person('C');
            Person jamie = new Person('J');
            
            for (int j = 0; j < n; j++) {
                activities[j] = new Activity();
                activities[j].start = sc.nextInt();
                activities[j].end = sc.nextInt();
                activities[j].index = j;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
            
            char[] assignments = new char[n];
            Arrays.fill(assignments, ' ');
            assignments[0] = 'C';
            cameron.activity = activities[0];
            if (n > 1) {
                assignments[1] = 'J';
                jamie.activity = activities[1];
            }
            
            int count = Math.min(n, 2);
            for (int j = 2; j < n; j++) {
                if (activities[j].start >= cameron.activity.end) {
                    cameron.activity = activities[j];
                    assignments[j] = 'C';
                    count++;
                } else if (activities[j].start >= jamie.activity.end) {
                    jamie.activity = activities[j];
                    assignments[j] = 'J';
                    count++;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                result.append(assignments[activities[j].index]);
            }
            
            if (count == n) {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}