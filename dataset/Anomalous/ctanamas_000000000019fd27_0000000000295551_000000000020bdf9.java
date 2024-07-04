import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = sc.nextInt();
        StringBuilder out = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            int activities = sc.nextInt();
            int[][] times = new int[activities][2];

            for (int i = 0; i < activities; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();
            }

            boolean[] cam = new boolean[activities];
            boolean[] jam = new boolean[activities];
            StringBuilder assignments = new StringBuilder();

            for (int x = 0; x < activities; x++) {
                if (isAvailable(cam, times, x, activities)) {
                    cam[x] = true;
                    assignments.append("C");
                } else if (isAvailable(jam, times, x, activities)) {
                    jam[x] = true;
                    assignments.append("J");
                } else {
                    assignments = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            out.append("Case #").append(c + 1).append(": ").append(assignments);
            if (c != numCases - 1) {
                out.append("\n");
            }
        }

        System.out.print(out);
    }

    public static boolean isAvailable(boolean[] assigned, int[][] times, int indexToAssign, int numAct) {
        for (int i = 0; i < numAct; i++) {
            if (assigned[i]) {
                if (times[indexToAssign][0] < times[i][1] && times[indexToAssign][1] > times[i][0]) {
                    return false;
                }
            }
        }
        return true;
    }
}