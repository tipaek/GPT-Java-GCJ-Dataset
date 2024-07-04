import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Activity(start, end, j);
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a.start, b.start));

            int endC = 0, endJ = 0;
            StringBuilder result = new StringBuilder("CJ".substring(0, Math.min(n, 2)));

            boolean possible = true;
            if (n > 2) {
                endC = activities[0].end;
                endJ = activities[1].end;

                for (int j = 2; j < n; j++) {
                    if (endC <= activities[j].start) {
                        endC = activities[j].end;
                        result.append('C');
                    } else if (endJ <= activities[j].start) {
                        endJ = activities[j].end;
                        result.append('J');
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                char[] resArr = new char[n];
                for (int j = 0; j < n; j++) {
                    resArr[activities[j].index] = result.charAt(j);
                }
                result = new StringBuilder(new String(resArr));
            } else {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}