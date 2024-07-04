import java.util.*;

class Activity {
    int start;
    int end;
    int index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < caseCount; i++) {
            int activityCount = Integer.valueOf(scanner.nextLine());
            int[][] activities = new int[activityCount][2];
            for(int j = 0; j < activityCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities[j][0] = Integer.valueOf(times[0]);
                activities[j][1] = Integer.valueOf(times[1]);
            }
            System.out.println(slove(activities, i + 1));
        }  
    }
    public static String slove(int[][] at, int index) {
        Activity[] activites = new Activity[at.length];
        for(int i = 0; i < at.length; i++) {
            activites[i] = new Activity(at[i][0], at[i][1], i);
        }

        Comparator<Activity> comparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity a, Activity b) {
                if(a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            }
        };
        Arrays.sort(activites, comparator);

        Activity c = null;
        Activity j = null;
        char[] result = new char[at.length];
        for(int i = 0; i < activites.length; i++) {
            if(c == null || activites[i].start >= c.end) {
                c = activites[i];
                result[activites[i].index] = 'C';
            } else if(j == null || activites[i].start >= j.end) {
                j = activites[i];
                result[activites[i].index] = 'J';
            } else {
                return String.format("Case #%d: IMPOSSIBLE", index);
            }
        }
        return String.format("Case #%d: %s",index, new String(result));
    }
}