import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isValidAssignment(Point[] assignments, Point newAssignment) {
        if (newAssignment.x > newAssignment.y) {
            return false;
        }

        for (Point assignment : assignments) {
            if (assignment == null) {
                break;
            }
            if ((newAssignment.x < assignment.x && newAssignment.y > assignment.x) ||
                (newAssignment.x > assignment.x && newAssignment.x < assignment.y) ||
                (newAssignment.x == assignment.x && newAssignment.y == assignment.y) ||
                (newAssignment.x == assignment.x && newAssignment.x != newAssignment.y) ||
                (newAssignment.y == assignment.y && newAssignment.y != newAssignment.y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            Point[] cAssignments = new Point[n];
            Point[] jAssignments = new Point[n];

            for (int l = 0; l < n; l++) {
                intervals[l] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0, jSize = 0;

            for (Point interval : intervals) {
                if (isValidAssignment(cAssignments, interval)) {
                    cAssignments[cSize++] = new Point(interval);
                    result.append("C");
                } else if (isValidAssignment(jAssignments, interval)) {
                    jAssignments[jSize++] = new Point(interval);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}