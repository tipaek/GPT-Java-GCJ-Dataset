import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ParentingPartnering {

    private static final boolean DEBUG = false;
    private static final int CAMERON = 0;
    private static final int JAMIE = 1;

    private static class Activity {
        int begin;
        int end;
        int partner;

        Activity(int begin, int end, int partner) {
            this.begin = begin;
            this.end = end;
            this.partner = partner;
        }
    }

    private static class FreeTime {
        int begin;
        int length;
        int before;
        int after;

        FreeTime(int begin, int length, int before, int after) {
            this.begin = begin;
            this.length = length;
            this.before = before;
            this.after = after;
        }
    }

    private static int solve(Activity[] activities) {
        Arrays.sort(activities, (a, b) -> Integer.compare(a.begin, b.begin));
        int[] parentingTimes = { 720, 720 };
        FreeTime[] freeTimes = new FreeTime[activities.length];

        for (int i = 0; i < activities.length; i++) {
            int nextBegin = (i < activities.length - 1) ? activities[i + 1].begin : activities[0].begin + 1440;
            int nextPartner = (i < activities.length - 1) ? activities[i + 1].partner : activities[0].partner;
            freeTimes[i] = new FreeTime(activities[i].end, nextBegin - activities[i].end, activities[i].partner, nextPartner);
            parentingTimes[activities[i].partner] -= (activities[i].end - activities[i].begin);
        }

        Arrays.sort(freeTimes, (a, b) -> Integer.compare(a.length, b.length));
        int exchangeCount = 0;

        for (FreeTime ft : freeTimes) {
            if (ft.before == ft.after && parentingTimes[ft.before] < ft.length) {
                exchangeCount += 2;
            }
            int timeBefore = Math.min(parentingTimes[ft.before], ft.length);
            parentingTimes[ft.before] -= timeBefore;
            parentingTimes[ft.before ^ 1] -= (ft.length - timeBefore);
        }

        for (FreeTime ft : freeTimes) {
            if (ft.before != ft.after) {
                exchangeCount++;
                int timeBefore = Math.min(parentingTimes[ft.before], ft.length);
                parentingTimes[ft.before] -= timeBefore;
                parentingTimes[ft.before ^ 1] -= (ft.length - timeBefore);
            }
        }

        return exchangeCount;
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        InputStream inputStream = DEBUG ? new FileInputStream("resources/codejam2017/round1c/B-large-practice.in") : System.in;

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int cameronCount = scanner.nextInt();
                int jamieCount = scanner.nextInt();
                Activity[] activities = new Activity[cameronCount + jamieCount];

                for (int i = 0; i < cameronCount; i++) {
                    activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), JAMIE);
                }
                for (int i = 0; i < jamieCount; i++) {
                    activities[i + cameronCount] = new Activity(scanner.nextInt(), scanner.nextInt(), CAMERON);
                }

                int exchangeCount = solve(activities);
                System.out.println("Case #" + testCase + ": " + exchangeCount);
            }
        }

        System.err.println("Execution time: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}