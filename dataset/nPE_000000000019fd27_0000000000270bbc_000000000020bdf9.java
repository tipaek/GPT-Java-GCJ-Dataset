import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String planning = "";
            List<Period> cameron = new ArrayList<Period>();
            List<Period> jamie = new ArrayList<Period>();
            cameron.add(new Period(0, 24 * 60));
            jamie.add(new Period(0, 24 * 60));
            for (int j = 1; j <= n; ++j) {
                int start = in.nextInt();
                int end = in.nextInt();
                Period activity = new Period(start, end);
                if (isAvailable(cameron, activity)) planning += 'C';
                else if (isAvailable(jamie, activity)) planning += 'J';
                else {
                    planning = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + planning);
        }
    }

    public static boolean isAvailable(List<Period> periodList, Period period) {
        for (int i = 0; i < periodList.size(); i++) {
            if (periodList.get(i).include(period)) {
                int end = periodList.get(i).end;
                periodList.get(i).end = period.start;
                periodList.add(new Period(period.end, end));
                return true;
            }
        }

        return false;
    }
   static class Period {
        int start;
        int end;

        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean include(Period period) {
            return (this.start <= period.start) && (this.end >= period.end);
        }
    }
}

