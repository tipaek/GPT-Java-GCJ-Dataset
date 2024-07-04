import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 4/4/2020 AD
 * Time: 18:07
 */
class Solution {
    static class Interval {
        int index;
        int start;
        int end;

        public Interval() {
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int x = 0;
        while (x < t) {
            int n = s.nextInt();
            Interval[] interval = new Interval[n];
            for (int i = 0; i < n; i++) {
                interval[i] = new Interval();
                interval[i].index = i;
                interval[i].start = s.nextInt();
                interval[i].end = s.nextInt();
            }

            String result = allocateActivity(interval, n);

            System.out.println("Case #" + (x + 1) + ": " + result);
            x++;
        }
    }

    private static String allocateActivity(Interval[] interval, int n) {
        Arrays.sort(interval, (i1, i2) -> (i1.start == i2.start) ? Integer.compare(i1.end, i2.end) : Integer.compare(i1.start, i2.start));
        char[] chars = new char[n];
        chars[interval[0].index] = 'C';
        chars[interval[1].index] = 'J';

        int Cend = (interval[0].end);
        int Jend = interval[1].end;
        for (int i = 2; i < n; i++) {
            if (interval[i].start >= Cend) {
                chars[interval[i].index] = 'C';
                Cend = interval[i].end;
            } else if (interval[i].start >= Jend) {
                chars[interval[i].index] = 'J';
                Jend = interval[i].end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(chars);
    }
}