import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static class Schedule implements Comparable<Schedule> {
        int s;
        int e;
        int index;

        public Schedule(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.s == o.s) {
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int test = 1; test <= T; ++test) {
            int N = in.nextInt();
            int[] ans = new int[N];
            Schedule[] schedules = new Schedule[N];

            for (int i = 0; i < N; ++i) {
                int s = in.nextInt();
                int e = in.nextInt();

                schedules[i] = new Schedule(s,e,i);
            }

            Arrays.sort(schedules);

            int[] person = new int[2];
            boolean isPossible = true;

            for (Schedule schedule: schedules) {
                isPossible = false;

                for (int i = 0; i < 2; ++i) {
                    if (person[i] <= schedule.s) {
                        isPossible = true;
                        person[i] = schedule.e;
                        ans[schedule.index] = i;
                        break;
                    }
                }

                if (!isPossible) {
                    break;
                }
            }

            if (isPossible) {
                System.out.print("Case #" + test + ": ");
                for (int i = 0; i < N; ++i) {
                    System.out.print(ans[i] == 0 ? 'C' : 'J');
                }
                System.out.println();
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}
