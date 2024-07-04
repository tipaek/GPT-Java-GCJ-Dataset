import java.util.*;

class Activity {
    int start;
    int end;

    Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static List<Activity> activityJ;
    public static List<Activity> activityC;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        // Testcases loop
        for(int i = 0; i < testcases; i++){
            int testcase = i + 1;
            String output = "";
            activityJ = new LinkedList<Activity>();
            activityC = new LinkedList<Activity>();

            // get schedule
            int n = sc.nextInt();
            int[][] schedule = new int[n][2];
            for(int k = 0; k < n; k++){
                schedule[k][0] = sc.nextInt();
                schedule[k][1] = sc.nextInt();
            }

            // loop over schedule
            for(int k = 0; k < n; k++){
                String ret = scheduledTo(schedule[k][0], schedule[k][1]);
                if(ret=="IMPOSSIBLE"){
                    output = ret;
                    break;
                }
                output+=ret;
            }

            // output the line
            System.out.println("Case #" + testcase + ": " + output);

        }



    }

    public static String scheduledTo(int start, int end){
        boolean toCam = true;
        for(Activity ac: activityC){
            if(end > ac.start && ac.end > start) toCam = false;

        }
        if(toCam){
            activityC.add(new Activity(start, end));
            return "C";
        }

        boolean toJam = true;
        for(Activity ac: activityJ){
            if(end > ac.start && ac.end > start) toJam = false;
        }
        if(toJam){
            activityJ.add(new Activity(start, end));
            return "J";
        }

        return "IMPOSSIBLE";
    }
}
