import java.util.*;

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
        String[] res = new String[activities.length];
        Arrays.sort(activities);

        int cLast = 0;
        int jLast = 0;

        for (int idx = 0; idx < activities.length; idx++) {
            if(cLast <= activities[idx].start){
                cLast = activities[idx].end;
                res[activities[idx].index] = "C";
            }else if(jLast <= activities[idx].start){
                jLast = activities[idx].end;
                res[activities[idx].index] = "J";
            }else {
                return "Case #" + no + ": IMPOSSIBLE";
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
        return this.start - act.start;
    }
}