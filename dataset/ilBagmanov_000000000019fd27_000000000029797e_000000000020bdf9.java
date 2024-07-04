import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
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
                times[i] = new Time(start, end, i);
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
            boolean answerCout = true;
            for (int i = 0; i < n; i++) {
                if (C == false || cEnd <= times[i].start) {
                    C = true;
                    cEnd = times[i].end;
                    times[i].person = 'C';
                    continue;
                }
                if (J == false || jEnd <= times[i].start) {
                    J = true;
                    jEnd = times[i].end;
                    times[i].person = 'J';
                    continue;
                }
                System.out.println("IMPOSSIBLE");
                answerCout = false;
                break;
            }
            if (!answerCout)
                continue;
            Arrays.sort(times, new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    if(o1.index > o2.index) return  1;
                    if (o1.index == o2.index) return 0;
                    return -1;
                }
            });
            for(int i = 0; i < n; i++) {
                System.out.print(times[i].person);
            }
            System.out.println();
        }
    }

    static class Time {
        int start;
        int end;
        int index;
        char person;

        Time(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

}
