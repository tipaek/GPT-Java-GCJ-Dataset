import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] results = new String[size];
        scanner.nextLine();

        for (int idx = 0; idx < size; idx++) {
            int actLen = scanner.nextInt();
            scanner.nextLine();
            Activity[] activities = new Activity[actLen];

            for (int actIdx = 0; actIdx < actLen ; actIdx++) {
                activities[actIdx] = new Activity(scanner.nextInt(), scanner.nextInt(), actIdx);
                scanner.nextLine();
            }

            results[idx] = getActivityPattern(activities, idx + 1);
        }
        scanner.close();

        for (String res: results) {
            System.out.println(res);
        }
    }

    private static String getActivityPattern(Activity[] activities, int no) {
        Arrays.sort(activities);

        String[] res = new String[activities.length];
        boolean[] seen = new boolean[activities.length];

        Activity last = null;
        for (int idx = 0; idx < activities.length; idx++) {
            if(last == null || activities[idx].start >= last.end){
                last = activities[idx];
                res[activities[idx].index] = "C";

                seen[idx] = true;
            }
        }

        last = null;
        for (int idx = 0; idx < activities.length; idx++) {
            if(!seen[idx]){
                if (last != null && activities[idx].start < last.end){
                    return "Case #" + no + ": " + "IMPOSSIBLE";
                }

                last = activities[idx];
                res[activities[idx].index] = "J";
            }
        }

        return "Case #" + no + ": " + getPattern(res);
    }

    private static String getPattern(String[] res) {
        StringBuilder builder = new StringBuilder();
        for(String c : res){
            builder.append(c);
        }
        return builder.toString();
    }
}

class Activity implements Comparable<Activity>{
    int start, end, index;

    Activity(int start, int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity act){
        if(end < act.end || (end == act.end && start > act.start)){
            return -1;
        }
        
        if(start == act.start){
            return 0;
        }
        
        return 1;
        
    }
}