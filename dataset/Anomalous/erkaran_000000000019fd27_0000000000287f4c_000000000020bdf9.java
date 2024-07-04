import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= testcase; i++) {
            int n = sc.nextInt();
            TreeSet<Activity> activities = new TreeSet<>();
            
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt(), j));
            }
            
            Activity[] arr = activities.toArray(new Activity[0]);
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            int cEnd = 0, jEnd = 0;
            cEnd = arr[0].end;
            schedule.append("C");
            
            for (int j = 1; j < n; j++) {
                if (cEnd <= arr[j].start) {
                    cEnd = arr[j].end;
                    schedule.append("C");
                } else if (jEnd <= arr[j].start) {
                    jEnd = arr[j].end;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                char[] result = new char[n];
                for (int j = 0; j < n; j++) {
                    result[arr[j].index] = schedule.charAt(j);
                }
                System.out.println("Case #" + i + ": " + String.valueOf(result));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}

class Activity implements Comparable<Activity> {
    public int start, end, index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}