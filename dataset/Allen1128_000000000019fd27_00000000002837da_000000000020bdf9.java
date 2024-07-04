import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Schedule {
        int start;
        int end;
        int index;
        public Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        public int getStart() {
            return start;
        }
    }

    public static String solve(int[][] data) {
        StringBuilder sb = new StringBuilder();
        Schedule[] schedules = new Schedule[data.length];
        if (!possible(data)) {
            return "IMPOSSIBLE";
        }
        char[] seq = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            schedules[i] = new Schedule(data[i][0], data[i][1], i);
        }
        Arrays.sort(schedules, Comparator.comparing(Schedule::getStart));
        int end = schedules[0].end;
        seq[schedules[0].index] = 'C';
        for (int i = 1; i < data.length; i++) {
            if (schedules[i].start >= end) {
                seq[schedules[i].index] = 'C';
                end = schedules[i].end;
            } else {
                seq[schedules[i].index] = 'J';
            }
        }
        return new String(seq);
    }

    private static boolean possible(int[][] data) {
        int[] start = new int[data.length];
        int[] end = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            start[i] = data[i][0];
            end[i] = data[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int ee = 0;
        int rooms = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[ee]) {
                rooms++;
                if (rooms > 2) {
                    return false;
                }
            } else {
                ee++;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int[][] data = new int[N][2];
            for (int i = 0; i < N; i++) {
                data[i][0] = input.nextInt();
                data[i][1] = input.nextInt();
            }
            System.out.println("Case #" + ks + ": " + solve(data));
            System.out.flush();
        }
    }
}