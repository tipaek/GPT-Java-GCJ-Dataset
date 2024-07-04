import java.util.*;
import java.io.*;
public class Solution {
    private static int START = 0;
    private static int END = 0;
    private static int TIME = 24*60 + 1;
    private static int SCHEDULED = Integer.MAX_VALUE;
    private static char CAMERON = 'C';
    private static char JAMIE = 'J';
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ti = 1; ti <= t; ++ti) {
            int n = in.nextInt();
            int[] oneday = new int[TIME];
            boolean impossible = false;
            Schedule[] activities = new Schedule[n+1];
            for(int scheduleIndex=1; scheduleIndex<=n; scheduleIndex++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Set<Integer> opposites = new HashSet<>();
                for (int time = start; time<end; time++) {
                    int existActivity = 0;
                    if (oneday[time]==SCHEDULED) {
                        impossible = true;
                        break;
                    } else if (oneday[time]!=0) {
                        int currentActivity = oneday[time];
                        oneday[time] = SCHEDULED;
                        if ( existActivity != currentActivity) {
                            existActivity = currentActivity;
                            if (!opposites.contains(existActivity)) {
                                opposites.add(existActivity);
                            }
                        }
                    } else {
                        oneday[time] = scheduleIndex;
                    }
                }
                if(impossible) break;
                activities[scheduleIndex] = new Schedule(opposites);
            }
            String ans = null;
            if (impossible) {
                ans = "IMPOSSIBLE";
            } else {
                char[] ansChars = new char[n+1];
                for(int activity=n; activity>0; activity--) {
                    char myOpposite = JAMIE;
                    if (ansChars[activity] == Character.MIN_VALUE) {
                        ansChars[activity] = CAMERON;
                    } else if (ansChars[activity] == JAMIE) {
                        myOpposite = CAMERON;
                    }
                    Iterator<Integer> itr = activities[activity].getOpposite().iterator();
                    while(itr.hasNext()) {
                        ansChars[itr.next()] = myOpposite;
                    }
                }
                ans = String.valueOf(ansChars);
                ans = ans.substring(1);
            }

            System.out.println("Case #" + ti + ": " + ans);
        }
    }
}
class Schedule {
    private Set<Integer> opposite;
    public Schedule (Set<Integer> opposite) {
        this.opposite = opposite;
    }
    public Set<Integer> getOpposite() {
        return this.opposite;
    }
}