import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] p, Point x) {
        for (int i = 0; i < p.length && p[i] != null; i++) {
            if ((x.x < p[i].y && x.y > p[i].x) || (x.x < p[i].x && x.y > p[i].x)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            Point[] tasks = new Point[n];
            Point[] cTasks = new Point[n];
            Point[] jTasks = new Point[n];

            for (int j = 0; j < n; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                tasks[j] = new Point(x, y);
            }

            StringBuilder schedule = new StringBuilder();
            int cSize = 0, jSize = 0;

            for (int j = 0; j < n; j++) {
                if (check(cTasks, tasks[j])) {
                    cTasks[cSize++] = tasks[j];
                    schedule.append("C");
                } else if (check(jTasks, tasks[j])) {
                    jTasks[jSize++] = tasks[j];
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + schedule.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }

        in.close();
    }
}