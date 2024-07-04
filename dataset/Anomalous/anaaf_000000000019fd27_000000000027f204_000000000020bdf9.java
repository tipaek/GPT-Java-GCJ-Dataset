import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 1; k <= t; k++) {
            int activities = in.nextInt();

            List<int[]> slots = new ArrayList<>();
            for (int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                slots.add(new int[]{start, stop});
            }

            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
            StringBuilder outputStr = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < activities; i++) {
                int[] current = slots.get(i);
                int currentStart = current[0];
                int currentEnd = current[1];
                boolean inserted = false;

                if (C.isEmpty() && J.isEmpty()) {
                    C.add(current);
                    outputStr.append("C");
                    inserted = true;
                } else {
                    if (!inserted && canInsert(C, currentStart, currentEnd)) {
                        C.add(current);
                        outputStr.append("C");
                        inserted = true;
                    }
                    if (!inserted && canInsert(J, currentStart, currentEnd)) {
                        J.add(current);
                        outputStr.append("J");
                        inserted = true;
                    }
                    if (!inserted) {
                        outputStr = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + k + ": " + outputStr.toString());
        }
    }

    private static boolean canInsert(List<int[]> list, int start, int end) {
        for (int[] interval : list) {
            if (!(end <= interval[0] || start >= interval[1])) {
                return false;
            }
        }
        return true;
    }
}