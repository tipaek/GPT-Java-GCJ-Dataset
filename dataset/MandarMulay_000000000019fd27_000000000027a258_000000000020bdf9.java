import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Parent {
    char name;
    Activity activity;

    public Parent(char name){
        this.name = name;
        this.activity = null;
    }

    public boolean canBeAssigned(Activity activity){
        return this.activity == null || this.activity.endsBefore(activity);
    }

    public String toString(){
        return "{" + "name: " + name + ", " + "activity: " + activity + "}";
    }

    public void assignActivity(Activity activity){
        this.activity = activity;
    }
}

class Activity {
    int index;
    int startTime;
    int endTime;

    public Activity(int index, int startTime, int endTime){
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toString(){
        return "{" + "index: " + index + ", " + "startTime: " + startTime + ", " + "endTime: " + endTime + "}";
    }

    public boolean endsBefore(Activity activity){
        return this.endTime <= activity.startTime;
    }
}

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        int testCasesCount = scanner.nextInt();
        while(i <= testCasesCount){
            int activityCount = scanner.nextInt();
            List<Activity> activities = solution.parseActivities(scanner, activityCount);
            Parent p1 = new Parent('C');
            Parent p2 = new Parent('J');

            String output = solution.generateActivitySequence(activities, p1, p2);
            System.out.print("Case #" + i + ": " + output);
            System.out.println();
            i++;
        }
    }

    public List<Activity> parseActivities(Scanner scanner, int count){
        List<Activity> activities = new ArrayList<Activity>();
        int index = 0;
        while(index < count){
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();

            Activity activity = new Activity(index, startTime, endTime);
            activities.add(activity);
            index++;
        }
        return activities;
    }

    public String generateActivitySequence(List<Activity> activities, Parent p1, Parent p2){
        PriorityQueue<Activity> pq = orderActivitiesByStartTime(activities);
        char[] resultSequence = new char[activities.size()];

        while(!pq.isEmpty()){
            Activity activity = pq.poll();

            if(p1.canBeAssigned(activity)){
                p1.assignActivity(activity);
                resultSequence[activity.index] = p1.name;
            } else if(p2.canBeAssigned(activity)){
                p2.assignActivity(activity);
                resultSequence[activity.index] = p2.name;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(resultSequence);
    }

    public PriorityQueue<Activity> orderActivitiesByStartTime(List<Activity> activities){
        PriorityQueue<Activity> pq = new PriorityQueue<Activity>((a,b) -> {
            if(a.startTime == b.startTime){
                return a.endTime - b.endTime;
            }
            return a.startTime - b.startTime;
        });

        for(Activity activity : activities){
            pq.offer(activity);
        }

        return pq;
    }
}
