import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int cases = in.nextInt();
            List<int[]> schedules = new ArrayList<>();

            for (int i = 0; i < cases; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                schedules.add(new int[]{start, end});
            }

            String result = getPossibleCombo(schedules);
            System.out.println("Case #" + x + ": " + result);
        }
    }

    private static String getPossibleCombo(List<int[]> schedules) {
        int[] occupiedUntil = new int[]{0, 0};  // [0] = C, [1] = J
        StringBuilder output = new StringBuilder();
        List<String> order = new ArrayList<>(Collections.nCopies(schedules.size(), null));

        schedules.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < schedules.size(); i++) {
            int[] current = schedules.get(i);
            if (current[0] >= occupiedUntil[0]) {
                occupiedUntil[0] = current[1];
                order.set(i, "C");
            } else if (current[0] >= occupiedUntil[1]) {
                occupiedUntil[1] = current[1];
                order.set(i, "J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (String str : order) {
            output.append(str);
        }

        return output.toString();
    }
}