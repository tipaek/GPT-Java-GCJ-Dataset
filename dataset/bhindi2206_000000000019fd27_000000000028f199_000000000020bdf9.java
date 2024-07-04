import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;



public class Solution{

    private static final boolean DEBUG = false;
    private static final int CAMERON = 0;
    private static final int JAMIE = 1;
    
    private static final class Activity {
        public final int begin;
        public final int end;
        public final int parentingPartner;

        public Activity(int begin, int end, int parentingPartner) {
            this.begin = begin;
            this.end = end;
            this.parentingPartner = parentingPartner;
        }
    }

    private static final class FreeTime {
        public final int begin;
        public final int length;
        public final int parentingBefore;
        public final int parentingAfter;

        public FreeTime(int begin, int length, int parentingBefore, int parentingAfter) {
            this.begin = begin;
            this.length = length;
            this.parentingBefore = parentingBefore;
            this.parentingAfter = parentingAfter;
        }
    }

    private static int solve(Activity[] activities) {
        // Construct the intervals of free time and compute partners' parenting time
        Arrays.sort(activities, (a, b) -> a.begin - b.begin);
        FreeTime[] freeTimes = new FreeTime[activities.length];
        int[] parentingTimes = { 720, 720 }; // for each partner
        for (int i = 0; i < activities.length; i++) {
            int nextBegin;
            int nextPartner;
            if (i < activities.length - 1) {
                nextBegin = activities[i + 1].begin;
                nextPartner = activities[i + 1].parentingPartner;
            } else {
                nextBegin = activities[0].begin + 1440;
                nextPartner = activities[0].parentingPartner;
            }
            freeTimes[i] = new FreeTime(activities[i].end, nextBegin - activities[i].end, activities[i].parentingPartner, nextPartner);
            parentingTimes[activities[i].parentingPartner] -= activities[i].end - activities[i].begin;
        }
        Arrays.sort(freeTimes, (a, b) -> a.length - b.length);
        // Attempt to coalesce same-parent free time intervals (0 or 2 exchanges per interval)
        int exchangeCount = 0;
        for (FreeTime fi : freeTimes) {
            if (fi.parentingBefore != fi.parentingAfter) continue;
            if (parentingTimes[fi.parentingBefore] < fi.length) {
                exchangeCount += 2;
            }
            int partnerBeforeTime = Math.min(parentingTimes[fi.parentingBefore], fi.length);
            parentingTimes[fi.parentingBefore] -= partnerBeforeTime;
            parentingTimes[fi.parentingBefore ^ 1] -= fi.length - partnerBeforeTime;
        }
        // Fill different-parent free time intervals with the remaining parenting time (1 exchange per interval)
        for (FreeTime fi : freeTimes) {
            if (fi.parentingBefore == fi.parentingAfter) continue;
            exchangeCount++;
            int partnerBeforeTime = Math.min(parentingTimes[fi.parentingBefore], fi.length);
            parentingTimes[fi.parentingBefore] -= partnerBeforeTime;
            parentingTimes[fi.parentingBefore ^ 1] -= fi.length - partnerBeforeTime;
        }
        return exchangeCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2017/round1c/B-large-practice.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int cameronActivityCount = scanner.nextInt();
                int jamieActivityCount = scanner.nextInt();
                Activity[] activities = new Activity[cameronActivityCount + jamieActivityCount];
                // Cameron's activities, Jamie's parenting
                for (int i = 0; i < cameronActivityCount; i++) {
                    activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), JAMIE);
                }
                // Jamie's activities, Cameron's parenting
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