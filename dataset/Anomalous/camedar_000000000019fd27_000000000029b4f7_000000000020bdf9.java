import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static boolean isOverlapped(List<Integer> ranges, int from, int until) {
        for (int i = 0; i < ranges.size(); i += 2) {
            int start = ranges.get(i);
            int end = ranges.get(i + 1);
            if ((from > start && from < end) || (until > start && until < end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; i++) {
            List<Integer> cameron = new ArrayList<>();
            List<Integer> jaimie = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            int n = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < n; j++) {
                String[] rangeInMinutes = scanner.nextLine().split(" ");
                int startingTime = Integer.parseInt(rangeInMinutes[0]);
                int endingTime = Integer.parseInt(rangeInMinutes[1]);

                if (!isOverlapped(cameron, startingTime, endingTime)) {
                    cameron.add(startingTime);
                    cameron.add(endingTime);
                    result.append("C");
                } else if (!isOverlapped(jaimie, startingTime, endingTime)) {
                    jaimie.add(startingTime);
                    jaimie.add(endingTime);
                    result.append("J");
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", i, result);
        }

        scanner.close();
    }
}