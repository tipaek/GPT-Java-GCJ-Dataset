import java.util.*;
import java.io.*;
public class Solution {
    private static int TIME = 24*60;
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
                int beforeActivity = -1;
                for (int time = start; time<end; time++) {
                    if (oneday[time]==SCHEDULED) {
                        impossible = true;
                        break;
                    } else if (oneday[time]!=0) {
                        int existActivity = oneday[time];
                        oneday[time] = SCHEDULED;
                        if ( beforeActivity != existActivity) {
                            beforeActivity = existActivity;
                            if ( !opposites.contains(existActivity)) {
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
                    Iterator<Integer> itr = activities[activity].opposite.iterator();
                    while(itr.hasNext()) {
                        ansChars[itr.next()] = myOpposite;
                    }
                }
                ans = String.valueOf(ansChars).substring(1);
            }

            System.out.println("Case #" + ti + ": " + ans);
        }
    }
}
class Schedule {
    protected Set<Integer> opposite;
    public Schedule (Set<Integer> opposite) {
        this.opposite = opposite;
    }

    public static void main(String[] args) {
        char[] ansChars = new char[2];
        ansChars[1] = 'F';
        String ans = String.valueOf(ansChars).substring(1);
        System.out.println(ans);
    }
}