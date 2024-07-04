import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine().trim());
        Activity[] activities = new Activity[1000];
        for (int i = 0; i < 1000; i++) {
            activities[i] = new Activity();
        }
        char[] scheduledActivities = new char[1000];
        for(int caseNumber = 0, activityCount, cFinish, jFinish; caseNumber<cases; caseNumber++){
            activityCount = Integer.parseInt(bufferedReader.readLine().trim());
            activities = getActivities(bufferedReader, activities, activityCount);
            Arrays.sort(activities, 0, activityCount, Comparator.comparing(activity -> activity.finish));
            cFinish = 0;
            jFinish = 0;


            boolean impossible = false;
            for (int i = 0; i < activityCount; i++) {
                if(activities[i].start >= cFinish){
                    cFinish = activities[i].finish;
                    scheduledActivities[activities[i].index] = 'C';
                }else if(activities[i].start >= jFinish){
                    jFinish = activities[i].finish;
                    scheduledActivities[activities[i].index] = 'J';
                }else{
                    impossible = true;
                    break;
                }
            }

            if(impossible){
                System.out.println("Case #" + (caseNumber+1) + ": IMPOSSIBLE");
            }else{
                System.out.println("Case #" + (caseNumber+1) + ": " + new String(scheduledActivities, 0, activityCount));
            }
        }
    }

    private static Activity[] getActivities(BufferedReader bufferedReader, Activity[] activities, int activityCount) throws IOException {
        String[] activity;
        for(int i=0;i<activityCount;i++){
            activity = bufferedReader.readLine().trim().split(" ");
            activities[i].start = Integer.parseInt(activity[0]);
            activities[i].finish = Integer.parseInt(activity[1]);
            activities[i].index = i;
        }
        return activities;
    }

}

class Activity {
    int finish;
    int start;
    int index;
    Activity(){

    }
    Activity(int s, int f, int i){
        start = s;
        index = i;
        finish = f;
    }
}