package codejam2017.round1c;

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
        final int begin;
        final int end;
        final int parentingPartner;

        Activity(int begin, int end, int parentingPartner) {
            this.begin = begin;
            this.end = end;
            this.parentingPartner = parentingPartner;
        }
    }

    private static class FreeTime {
        final int begin;
        final int length;
        final int parentingBefore;
        final int parentingAfter;

        FreeTime(int begin, int length, int parentingBefore, int parentingAfter) {
            this.begin = begin;
            this.length = length;
            this.parentingBefore = parentingBefore;
            this.parentingAfter = parentingAfter;
        }
    }

    private static int solve(Activity[] activities) {
        Arrays.sort(activities, (a, b) -> Integer.compare(a.begin, b.begin));
        FreeTime[] freeTimes = new FreeTime[activities.length];
        int[] parentingTimes = {720, 720};

        for (int i = 0; i < activities.length; i++) {
            int nextBegin = (i < activities.length - 1) ? activities[i + 1].begin : activities[0].begin + 1440;
            int nextPartner = (i < activities.length - 1) ? activities[i + 1].parentingPartner : activities[0].parentingPartner;
            freeTimes[i] = new FreeTime(activities[i].end, nextBegin - activities[i].end, activities[i].parentingPartner, nextPartner);
            parentingTimes[activities[i].parentingPartner] -= (activities[i].end - activities[i].begin);
        }

        Arrays.sort(freeTimes, (a, b) -> Integer.compare(a.length, b.length));
        int exchangeCount = 0;

        for (FreeTime fi : freeTimes) {
            if (fi.parentingBefore != fi.parentingAfter) continue;
            if (parentingTimes[fi.parentingBefore] < fi.length) exchangeCount += 2;
            int partnerBeforeTime = Math.min(parentingTimes[fi.parentingBefore], fi.length);
            parentingTimes[fi.parentingBefore] -= partnerBeforeTime;
            parentingTimes[fi.parentingBefore ^ 1] -= (fi.length - partnerBeforeTime);
        }

        for (FreeTime fi : freeTimes) {
            if (fi.parentingBefore == fi.parentingAfter) continue;
            exchangeCount++;
            int partnerBeforeTime = Math.min(parentingTimes[fi.parentingBefore], fi.length);
            parentingTimes[fi.parentingBefore] -= partnerBeforeTime;
            parentingTimes[fi.parentingBefore ^ 1] -= (fi.length - partnerBeforeTime);
        }

        return exchangeCount;
    }

    public static void main(String[] args) throws Exception {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2017/round1c/B-large-practice.in") : System.in;

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int cameronActivityCount = scanner.nextInt();
                int jamieActivityCount = scanner.nextInt();
                Activity[] activities = new Activity[cameronActivityCount + jamieActivityCount];

                for (int i = 0; i < cameronActivityCount; i++) {
                    activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), JAMIE);
                }

                for (int i = 0; i < jamieActivityCount; i++) {
                    activities[i + cameronActivityCount] = new Activity(scanner.nextInt(), scanner.nextInt(), CAMERON);
                }

                int exchangeCount = solve(activities);
                System.out.println("Case #" + testNumber + ": " + exchangeCount);
            }
        }

        System.err.println("ParentingPartnering done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}