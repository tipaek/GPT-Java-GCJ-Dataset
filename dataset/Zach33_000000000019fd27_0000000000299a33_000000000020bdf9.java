import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++) {
            System.out.printf("Case #%d: ",i+1);
            int numActivities = scan.nextInt();
            String result = "";
            int p1 = 0;
            int p2 = 0;
            Activity[] activities = new Activity[numActivities];
            for(int k = 0; k < numActivities; k++) {
                int a1start = scan.nextInt();
                int a1end = scan.nextInt();
                activities[k] = new Activity(a1start, a1end);
            }
            Arrays.sort(activities);
            for(int k = 0; k < numActivities; k++) {
                int a1start = activities[k].start;
                int a1end = activities[k].end;
                if(a1start>=p1) {
                    p1=a1end;
                    result+="J";
                } else if(a1start>=p2) {
                    p2 = a1end;
                    result+="C";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println(result);

        }
    }
}
class Activity implements Comparable<Activity>{
    int start;
    int end;
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity activity) {
        return this.start-activity.start;
    }
}