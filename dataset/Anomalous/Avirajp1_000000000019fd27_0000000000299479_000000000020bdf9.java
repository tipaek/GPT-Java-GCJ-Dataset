import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ts = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.printf("Case #%d: %s\n", ts++, result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int[] c = new int[9999];
        int[] h = new int[9999];
        int x = 0, y = 0;
        StringBuilder str = new StringBuilder();
        boolean impossible = false;

        for (int j = intervals[0][0]; j < intervals[0][1]; j++) {
            c[x++] = j;
        }
        str.append('c');

        for (int j = 1; j < intervals.length; j++) {
            int inc = 0, inj = 0;

            for (int k = 0; k < c.length; k++) {
                if (intervals[j][0] == c[k] || intervals[j][1] - 1 == c[k]) {
                    inc++;
                }
                if (intervals[j][0] == h[k] || intervals[j][1] - 1 == h[k]) {
                    inj++;
                }
            }

            if (inc > 0 && inj == 0) {
                str.append('j');
                for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                    h[y++] = l;
                }
            } else if (inc == 0 && inj > 0) {
                str.append('c');
                for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                    c[x++] = l;
                }
            } else if (inc == 0 && inj == 0) {
                str.append('c');
                for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                    c[x++] = l;
                }
            } else if (inc > 0 && inj > 0) {
                impossible = true;
                break;
            }
        }

        return impossible ? "IMPOSSIBLE" : str.toString();
    }
}