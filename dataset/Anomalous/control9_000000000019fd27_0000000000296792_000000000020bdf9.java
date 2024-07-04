import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                activities.add(new Activity(nextInt(), nextInt(), i));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            boolean isPossible = true;
            int cEnd = 0, jEnd = 0;
            char[] schedule = new char[n];

            for (Activity activity : activities) {
                if (cEnd <= activity.start) {
                    schedule[activity.order] = 'C';
                    cEnd = activity.end;
                } else if (jEnd <= activity.start) {
                    schedule[activity.order] = 'J';
                    jEnd = activity.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #");
            System.out.print(testCase);
            System.out.print(": ");

            if (isPossible) {
                System.out.println(new String(schedule));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static class Activity {
        int start, end, order;

        Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}