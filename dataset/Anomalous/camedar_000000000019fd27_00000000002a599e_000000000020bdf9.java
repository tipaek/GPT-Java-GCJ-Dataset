import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static boolean isOverlapping(List<Integer> ranges, int from, int until) {
        for (int i = 0; i < ranges.size(); i += 2) {
            if ((from > ranges.get(i) && from < ranges.get(i + 1)) || (until > ranges.get(i) && until < ranges.get(i + 1))) {
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
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < n; j++) {
                String[] rangeInMinutes = scanner.nextLine().split(" ");
                int start = Integer.parseInt(rangeInMinutes[0]);
                int end = Integer.parseInt(rangeInMinutes[1]);

                if (!isOverlapping(cameron, start, end)) {
                    cameron.add(start);
                    cameron.add(end);
                    result.append("C");
                } else if (!isOverlapping(jaimie, start, end)) {
                    jaimie.add(start);
                    jaimie.add(end);
                    result.append("J");
                }
            }

            if (result.length() < n) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}