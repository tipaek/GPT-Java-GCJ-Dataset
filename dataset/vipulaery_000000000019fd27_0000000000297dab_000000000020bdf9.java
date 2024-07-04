import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int caseNumber = 0; caseNumber<cases; caseNumber++){
            Activity[] activities = getActivities(bufferedReader);
            Arrays.sort(activities, Comparator.comparing(activity -> activity.finish));
            int cFinish = 0, jFinish = 0;

            char[] scheduledActivities = new char[activities.length];
            boolean impossible = false;
            for (Activity activity: activities) {
                if(activity.start >= cFinish){
                    cFinish = activity.finish;
                    scheduledActivities[activity.index] = 'C';
                }else if(activity.start >= jFinish){
                    jFinish = activity.finish;
                    scheduledActivities[activity.index] = 'J';
                }else{
                    impossible = true;
                    break;
                }
            }

            if(impossible){
                System.out.println("Case #" + (caseNumber+1) + ": IMPOSSIBLE");
            }else{
                System.out.println("Case #" + (caseNumber+1) + ": " + new String(scheduledActivities));
            }
        }
    }

    private static Activity[] getActivities(BufferedReader bufferedReader) throws IOException {
        int activityCount = Integer.parseInt(bufferedReader.readLine().trim());

        Activity[] activities = new Activity[activityCount];
        for(int i=0;i<activityCount;i++){
            String[] activity = bufferedReader.readLine().trim().split(" ");
            activities[i] = new Activity(Integer.parseInt(activity[0]), Integer.parseInt(activity[1]), i);
        }
        return activities;
    }

}

class Activity {
    int finish;
    int start;
    int index;
    Activity(int s, int f, int i){
        start = s;
        index = i;
        finish = f;
    }
}