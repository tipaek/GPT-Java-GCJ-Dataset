import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        String output = "";
        List<int[]> cameron = new LinkedList<>();
        List<int[]> jamie = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int[] event = new int[] {scanner.nextInt(), scanner.nextInt()};
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
