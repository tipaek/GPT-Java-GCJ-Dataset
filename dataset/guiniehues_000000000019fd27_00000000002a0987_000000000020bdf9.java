import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        int n = scanner.nextInt();

        List<int[]> events = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            events.add(new int[] {scanner.nextInt(), scanner.nextInt()});
        }
        Collections.sort(events, (o1, o2) -> {
            int i = Integer.valueOf(o1[0]).compareTo(o2[0]);
            if (i != 0) {
                return i;
            }
            return Integer.valueOf(o1[1]).compareTo(o2[1]);
        });

        String output = "";
        List<int[]> cameron = new LinkedList<>();
        List<int[]> jamie = new LinkedList<>();
        for (int[] event : events) {
            if (cameron.stream().allMatch(event1 -> event[0] >= event1[1] || event[1] <= event1[0])) {
                cameron.add(event);
                output += "C";
            } else if (jamie.stream().allMatch(event1 -> event[0] >= event1[1] || event[1] <= event1[0])) {
                jamie.add(event);
                output += "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output;
    }

}
