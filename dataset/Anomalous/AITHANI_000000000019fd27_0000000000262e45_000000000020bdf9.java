package codejam2017.round1c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        int partnerBefore;
        int partnerAfter;

        FreeTime(int begin, int length, int partnerBefore, int partnerAfter) {
            this.begin = begin;
            this.length = length;
            this.partnerBefore = partnerBefore;
            this.partnerAfter = partnerAfter;
        }
    }

    private static int solve(Activity[] activities) {
        Arrays.sort(activities, (a, b) -> Integer.compare(a.begin, b.begin));
        FreeTime[] freeTimes = new FreeTime[activities.length];
        int[] parentingTimes = { 720, 720 };

        for (int i = 0; i < activities.length; i++) {
            int nextBegin = (i < activities.length - 1) ? activities[i + 1].begin : activities[0].begin + 1440;
            int nextPartner = (i < activities.length - 1) ? activities[i + 1].partner : activities[0].partner;
            freeTimes[i] = new FreeTime(activities[i].end, nextBegin - activities[i].end, activities[i].partner, nextPartner);
            parentingTimes[activities[i].partner] -= (activities[i].end - activities[i].begin);
        }

        Arrays.sort(freeTimes, (a, b) -> Integer.compare(a.length, b.length));
        int exchangeCount = 0;

        for (FreeTime freeTime : freeTimes) {
            if (freeTime.partnerBefore == freeTime.partnerAfter) {
                if (parentingTimes[freeTime.partnerBefore] < freeTime.length) {
                    exchangeCount += 2;
                }
                int partnerTime = Math.min(parentingTimes[freeTime.partnerBefore], freeTime.length);
                parentingTimes[freeTime.partnerBefore] -= partnerTime;
                parentingTimes[freeTime.partnerBefore ^ 1] -= freeTime.length - partnerTime;
            }
        }

        for (FreeTime freeTime : freeTimes) {
            if (freeTime.partnerBefore != freeTime.partnerAfter) {
                exchangeCount++;
                int partnerTime = Math.min(parentingTimes[freeTime.partnerBefore], freeTime.length);
                parentingTimes[freeTime.partnerBefore] -= partnerTime;
                parentingTimes[freeTime.partnerBefore ^ 1] -= freeTime.length - partnerTime;
            }
        }

        return exchangeCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
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
    }
}