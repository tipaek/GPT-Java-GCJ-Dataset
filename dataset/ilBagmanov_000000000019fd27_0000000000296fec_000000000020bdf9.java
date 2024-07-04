import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int w = 0; w < t; w++) {
            System.out.print("Case #" + (w + 1) + ": ");
            int n = sc.nextInt();
            Time[] times = new Time[n];
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                times[i] = new Time(start, end);
            }
            Arrays.sort(times, new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    if (o1.start > o2.start) return 1;
                    if (o1.start == o2.start) {
                        if (o1.end > o2.end) return 1;
                        if (o1.end == o2.end) return 0;
                        return -1;
                    }
                    return -1;
                }
            });
            boolean C = false;
            int cEnd = 0;
            boolean J = false;
            int jEnd = 0;
            StringBuilder answer = new StringBuilder();
            boolean answerCout = true;
            for (int i = 0; i < n; i++) {
                if (C == false || cEnd <= times[i].start) {
                    C = true;
                    cEnd = times[i].end;
                    answer.append("C");
                    continue;
                }
                if (J == false || jEnd <= times[i].start) {
                    J = true;
                    jEnd = times[i].end;
                    answer.append("J");
                    continue;
                }
                System.out.println("IMPOSSIBLE");
                answerCout = false;
                break;
            }
            if (answerCout) {
                System.out.println(answer.toString());
            }
        }
    }

    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
