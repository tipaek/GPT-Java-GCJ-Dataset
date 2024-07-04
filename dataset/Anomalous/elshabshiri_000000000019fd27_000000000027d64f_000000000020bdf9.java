import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Parenting Partnering problem from Round 1C of Code Jam 2017.
 * https://codejam.withgoogle.com/codejam/contest/3274486/dashboard#s=p1
 * 
 * Let's consider a distribution of activities like: C.....CJ..J...J.J..C 
 * (sample case 5), where we know that the other partner must be parenting during 
 * activities: J.....JC..C...C.C..J, and we need to fill the interval of free 
 * times using up 12 hours per partner (with wrap-around).
 * 
 * To minimize the number of exchanges, we should first attempt to coalesce 
 * intervals of free times where the same partner parents before and after, 
 * that is between C and C and between J and J. Each coalesced interval results 
 * in no exchanges. If the coalescing partner has not enough parenting time 
 * to fill the interval, we need to handle the baby to the other partner 
 * for a while (for example J.....J can become JJJJCCJ), resulting in two 
 * exchanges. Thus, it is optimal to coalesce smaller free time intervals first.
 * 
 * For intervals of free time where two different partners parent before and 
 * after (as in C..J), we need to add an exchange in any case, so we just 
 * fill the free time interval from left to right with the remaining parenting 
 * time (for example CCCJ or CCJJ or CJJJ, depending on how much time C has). 
 * It is very important to do this scan after coalescing interval in the 
 * previous scan, and not doing both in parallel, otherwise different-parent 
 * intervals could steal useful parenting time to coalesce same-parent intervals 
 * (I initially got the large dataset wrong due to this mistake...).
 * 
 * The O(n*log2(n)) of activities and free time intervals sorting dominates 
 * the linear scan of intervals described above.
 * 
 */
public class ParentingPartnering {

    private static final boolean DEBUG = false;
    private static final int CAMERON = 0;
    private static final int JAMIE = 1;
    
    private static class Activity {
        public final int begin;
        public final int end;
        public final int parentingPartner;

        public Activity(int begin, int end, int parentingPartner) {
            this.begin = begin;
            this.end = end;
            this.parentingPartner = parentingPartner;
        }
    }

    private static class FreeTime {
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
        Arrays.sort(activities, (a, b) -> Integer.compare(a.begin, b.begin));
        FreeTime[] freeTimes = new FreeTime[activities.length];
        int[] parentingTimes = { 720, 720 };
        
        for (int i = 0; i < activities.length; i++) {
            int nextBegin = (i < activities.length - 1) ? activities[i + 1].begin : activities[0].begin + 1440;
            int nextPartner = (i < activities.length - 1) ? activities[i + 1].parentingPartner : activities[0].parentingPartner;
            freeTimes[i] = new FreeTime(activities[i].end, nextBegin - activities[i].end, activities[i].parentingPartner, nextPartner);
            parentingTimes[activities[i].parentingPartner] -= (activities[i].end - activities[i].begin);
        }
        
        Arrays.sort(freeTimes, (a, b) -> Integer.compare(a.length, b.length));
        int exchangeCount = 0;
        
        for (FreeTime fi : freeTimes) {
            if (fi.parentingBefore == fi.parentingAfter) {
                if (parentingTimes[fi.parentingBefore] < fi.length) {
                    exchangeCount += 2;
                }
                int partnerBeforeTime = Math.min(parentingTimes[fi.parentingBefore], fi.length);
                parentingTimes[fi.parentingBefore] -= partnerBeforeTime;
                parentingTimes[fi.parentingBefore ^ 1] -= (fi.length - partnerBeforeTime);
            }
        }
        
        for (FreeTime fi : freeTimes) {
            if (fi.parentingBefore != fi.parentingAfter) {
                exchangeCount++;
                int partnerBeforeTime = Math.min(parentingTimes[fi.parentingBefore], fi.length);
                parentingTimes[fi.parentingBefore] -= partnerBeforeTime;
                parentingTimes[fi.parentingBefore ^ 1] -= (fi.length - partnerBeforeTime);
            }
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