import java.util.*;

class Activity implements Comparable<Activity> {
    public int start, end, index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        int thisValue = this.start * 1000000 + this.end * 1000 + this.index;
        int otherValue = other.start * 1000000 + other.end * 1000 + other.index;
        return Integer.compare(thisValue, otherValue);
    }
}

class Solution {
    public static String replaceCharAt(String str, int index, char replace) {
        if (str == null || index < 0 || index >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities);

            int cEnd = 0, jEnd = 0;
            char[] schedule = new char[n];
            Arrays.fill(schedule, 'C');

            boolean possible = true;
            for (Activity activity : activities) {
                if (cEnd <= activity.start) {
                    cEnd = activity.end;
                    schedule[activity.index] = 'C';
                } else if (jEnd <= activity.start) {
                    jEnd = activity.end;
                    schedule[activity.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}