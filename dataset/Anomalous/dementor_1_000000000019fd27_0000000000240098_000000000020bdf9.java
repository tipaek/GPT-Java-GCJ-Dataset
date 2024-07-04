import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Activity implements Comparable<Activity> {
    int start, end, index, alloc;

    public Activity(int start, int end, int index, int alloc) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.alloc = alloc;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start == other.start) {
            return this.end - other.end;
        } else {
            return this.start - other.start;
        }
    }
}

class Solution {

    static char checkSlot(int[] startC, int[] endC, int[] startJ, int[] endJ, int start, int end) {
        if (canAllocate(startC, endC, start, end)) {
            return 'C';
        } else if (canAllocate(startJ, endJ, start, end)) {
            return 'J';
        } else {
            return '\0';
        }
    }

    static boolean canAllocate(int[] startArray, int[] endArray, int start, int end) {
        for (int i = 0; startArray[i] != -1; i++) {
            if (isOverlap(startArray[i], endArray[i], start, end)) {
                return false;
            }
        }
        for (int i = 0; startArray[i] != -1; i++) {
            if (startArray[i] == -1) {
                startArray[i] = start;
                endArray[i] = end;
                return true;
            }
        }
        return false;
    }

    static boolean isOverlap(int start1, int end1, int start2, int end2) {
        return (start2 >= start1 && start2 < end1) || (end2 > start1 && end2 <= end1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int[] startC = new int[1000];
        int[] endC = new int[1000];
        int[] startJ = new int[1000];
        int[] endJ = new int[1000];
        char[] result;

        for (int t = 1; t <= testCases; t++) {
            Arrays.fill(startC, -1);
            Arrays.fill(endC, -1);
            Arrays.fill(startJ, -1);
            Arrays.fill(endJ, -1);

            int n = Integer.parseInt(br.readLine());
            Activity[] activities = new Activity[n];
            result = new char[n];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                activities[i] = new Activity(start, end, i, -1);
            }

            Arrays.sort(activities);
            boolean possible = true;

            for (Activity activity : activities) {
                char assigned = checkSlot(startC, endC, startJ, endJ, activity.start, activity.end);
                if (assigned == '\0') {
                    possible = false;
                    break;
                } else {
                    result[activity.index] = assigned;
                }
            }

            if (possible) {
                System.out.printf("Case #%d: %s\n", t, new String(result));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
    }
}