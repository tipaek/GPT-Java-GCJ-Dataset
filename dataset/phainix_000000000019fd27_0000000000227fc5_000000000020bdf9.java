import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int i = 0; i < testCase; i++) {
            // System.out.println("Starting test case "+(i+1));
            int n = scan.nextInt();
            ArrayList<Activity> activities = new ArrayList<Activity>();

            scan.nextLine();
            for(int j = 0; j < n; j++) {
                String s = scan.nextLine();
                // System.out.println(s);
                String[] arr = s.split(" ");
                activities.add(new Activity(arr, j));
            }

            String result = compute(n, activities);

            System.out.printf("Case #%d: %s", i+1, result);
            System.out.println("");
        }
}

    private static String compute(int n, ArrayList<Activity> activities) {
        Collections.sort(activities);
        int j_end = 0;
        int c_end = 0;
        String[] res = new String[n];
        String result = "";
        for(Activity activity: activities){
            // System.out.println(activity);
            if(activity.start >= j_end) {
                result += "J";
                res[activity.initial_position] = "J";
                j_end = activity.end;
            } else if(activity.start >= c_end) {
                result += "C";
                res[activity.initial_position] = "C";
                c_end = activity.end;
            } else {
                return  "IMPOSSIBLE";
            }
        }
        // System.out.println(result);
        return String.join("", res);
    }

}

class Activity implements Comparable {
    public int start;
    public int end;
    public int initial_position;

    public Activity(String[] activity, int position) {
        start = Integer.parseInt(activity[0]);
        end = Integer.parseInt(activity[1]);
        initial_position = position;
    }

    @Override
    public int compareTo(Object o) {
        return this.start - ((Activity)o).start;
    }

    @Override
    public String toString() {
        return "[ start=" + start + ", end=" + end + ", initial_position=" + initial_position + "]";
    }
}