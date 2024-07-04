import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 1; k <= t; k++) {
            int activities = in.nextInt();
            List<int[]> slots = new ArrayList<>();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                slots.add(new int[]{start, stop});
            }

            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
            boolean possible = true;

            for (int i = 0; i < activities; i++) {
                int[] current = slots.get(i);
                int currentStart = current[0];
                int currentEnd = current[1];
                boolean assigned = false;

                if (i == 0) {
                    C.add(current);
                    outputStr.append("C");
                    assigned = true;
                } else {
                    if (canAssign(C, currentStart, currentEnd)) {
                        C.add(current);
                        outputStr.append("C");
                        assigned = true;
                    } else if (canAssign(J, currentStart, currentEnd)) {
                        J.add(current);
                        outputStr.append("J");
                        assigned = true;
                    }

                    if (!assigned) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(outputStr.toString());
            }
        }
    }

    private static boolean canAssign(List<int[]> schedule, int start, int end) {
        for (int[] time : schedule) {
            if (!(end <= time[0] || start >= time[1])) {
                return false;
            }
        }
        return true;
    }
}