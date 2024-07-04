import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine());
        int caseCounter = 0;

        while (caseCounter++ < testCases) {
            int n = sc.nextInt();


            int[] day = new int[24 * 60 + 1];
            int[] starts = new int[n];
            int[] ends = new int[n];
            boolean impossible = false;

            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                starts[i] = sc.nextInt();
                ends[i] = sc.nextInt();
                intervals.add(new Interval(starts[i], ends[i], i));
                if(!impossible) {
                    for (int j = starts[i]; j < ends[i]; j++) {
                        day[j]++;
                        if(day[j] > 2) {
                            impossible = true;
                            break;
                        }
                    }
                }
            }

            intervals.sort((a, b) -> a.s == b.s ? a.e - b.e : a.s - b.s);

            String result;
            if (impossible) {
                result = "IMPOSSIBLE";
            } else {
                char[] who = new char[n];

                for (Interval interval : intervals) {
                    boolean isC = true;

                    // check for negatives
                    for (int j = interval.s; j < interval.e; j++) {
                        if(day[j] < 0) {
                            isC = false;
                            break;
                        }
                    }

                    // if C will do it, set negatives
                    if (isC) {
                        for (int j = interval.s; j < interval.e; j++) {
                            day[j] *= -1;
                        }
                    }

                    // construct answer
                    who[interval.ind] = isC ? 'C' : 'J';
                }

                result = new String(who);
            }

            System.out.printf("Case #%d: %s\n", caseCounter, result);
        }
    }

    static class Interval {
        int s;
        int e;
        int ind;

        public Interval(int s, int e, int ind) {
            this.s = s;
            this.e = e;
            this.ind = ind;
        }
    }
}
