// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9?show=progress

import java.util.*;

class Activity {
    int startTime;
    int endTime;
    
    public Activity(int s, int e) {
        startTime = s;
        endTime = e;
    }
    
    public static boolean isOverlapping(Activity a1, Activity a2) {
        return (a1.endTime > a2.startTime); 
    }
    
    public static int getIndex(char person) {
        if (person == 'C') {
            return 0;
        } else if (person == 'J') {
            return 1;
        } else {
            return -1;
        }
    }
    
    public static char getOther(char c) {
        if (c == 'C') {
            return 'J';
        } else if (c == 'J') {
            return 'C';
        } else {
            System.out.println("Invalid person char");
            return '0';
        }
    }
}

class ActivityComparator implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2) {
        if (a1.startTime < a2.startTime) {
            return -1;
        } else if (a1.startTime > a2.startTime) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Solution{
    private static boolean assignment(Activity[] activities, int N, char assignment[]){
        int endTime[] = {0 , 0};
        
        char currentPerson = 'J';
        assignment[0] = currentPerson;
        endTime[Activity.getIndex(currentPerson)] = activities[0].endTime;
        
        for (int i = 1; i < N; ++i) {
            char previous = assignment[i - 1];
            
            // not overlapping with previous assign same person
            if (!Activity.isOverlapping(activities[i - 1], activities[i])) {
                assignment[i] = previous;
                endTime[Activity.getIndex(previous)] = activities[i].endTime;
            } else {
                // if overlappig with previous
                char other = Activity.getOther(previous);
                
                if (endTime[Activity.getIndex(other)] <= activities[i].startTime) {
                    assignment[i] = other;
                    endTime[Activity.getIndex(other)] = activities[i].endTime;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void assignment(Activity[] activities, int N, int t) {
        Arrays.sort(activities, new ActivityComparator());
        char assignment[] = new char[N];
        boolean isValid = assignment(activities, N, assignment);
        
        System.out.print("Case #" + t + ": ");

        if (isValid) {
            for (char a : assignment) {
                System.out.print(a);
            }
            System.out.println("");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
    
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            
            Activity activities[] = new Activity[n];
            
            for (int j = 0; j < n; ++j) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                
                activities[j] = new Activity(start, end);
            }
            
            assignment(activities, n, i);
        }
     }
}