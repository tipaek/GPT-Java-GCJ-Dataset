package codejam2017.round1c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Parenting Partnering problem from Round 1C of Code Jam 2017.
 * https://codejam.withgoogle.com/codejam/contest/3274486/dashboard#s=p1
 * 
 * This solution aims to minimize the number of exchanges between parenting partners
 * by strategically coalescing intervals of free time.
 * 
 * The O(n*log2(n)) complexity of sorting activities and free time intervals is 
 * the dominant factor in the solution.
 * 
 */
public class ParentingPartnering {

    private static final boolean DEBUG = false;
    private static final int CAMERON = 0;
    private static final int JAMIE = 1;
    
    private static class Activity {
        int begin;
        int end;
        int parentingPartner;

        Activity(int begin, int end, int parentingPartner) {
            this.begin = begin;
            this.end = end;
            this.parentingPartner = parentingPartner;
        }
    }

    private static class FreeTime {
        int begin;
        int length;
        int parentingBefore;
        int parentingAfter;

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
        int[] parentingTimes = { 720, 720 }; // 720 minutes for each partner

        for (int i = 0; i < activities.length; i++) {
            int nextBegin = (i < activities.length - 1) ? activities[i + 1].begin : activities[0].begin + 1440;
            int nextPartner = (i < activities.length - 1) ? activities[i + 1].parentingPartner : activities[0].parentingPartner;

            freeTimes[i] = new FreeTime(activities[i].end, nextBegin - activities[i].end, activities[i].parentingPartner, nextPartner);
            parentingTimes[activities[i].parentingPartner] -= activities[i].end - activities[i].begin;
        }

        Arrays.sort(freeTimes, (a, b) -> Integer.compare(a.length, b.length));
        int exchangeCount = 0;

        for (FreeTime ft : freeTimes) {
            if (ft.parentingBefore == ft.parentingAfter) {
                if (parentingTimes[ft.parentingBefore] < ft.length) {
                    exchangeCount += 2;
                }
                int usedTime = Math.min(parentingTimes[ft.parentingBefore], ft.length);
                parentingTimes[ft.parentingBefore] -= usedTime;
                parentingTimes[ft.parentingBefore ^ 1] -= ft.length - usedTime;
            }
        }

        for (FreeTime ft : freeTimes) {
            if (ft.parentingBefore != ft.parentingAfter) {
                exchangeCount++;
                int usedTime = Math.min(parentingTimes[ft.parentingBefore], ft.length);
                parentingTimes[ft.parentingBefore] -= usedTime;
                parentingTimes[ft.parentingBefore ^ 1] -= ft.length - usedTime;
            }
        }

        return exchangeCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        InputStream inputStream = DEBUG ? new FileInputStream("resources/codejam2017/round1c/B-large-practice.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
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