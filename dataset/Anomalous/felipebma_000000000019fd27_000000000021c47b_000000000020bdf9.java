import java.util.*;

public class Solution {

    static class Activity {
        int id, start, end;

        Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i);
        }
    }

    private static void processTestCase(int testCaseNumber) {
        int n = scanner.nextInt();
        Activity[] activities = new Activity[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

        int endC = 0, endJ = 0;

        for (Activity activity : activities) {
            if (activity.start >= endC) {
                endC = activity.end;
                result[activity.id] = 'C';
            } else if (activity.start >= endJ) {
                endJ = activity.end;
                result[activity.id] = 'J';
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCaseNumber);
                return;
            }
        }

        System.out.printf("Case #%d: ", testCaseNumber);
        for (char ch : result) {
            System.out.print(ch);
        }
        System.out.println();
    }
}