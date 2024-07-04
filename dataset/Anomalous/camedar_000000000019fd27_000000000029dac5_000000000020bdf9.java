import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static boolean isOverlapped(List<Integer> ranges, int from, int until) {
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
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Integer> cameron = new ArrayList<>();
            List<Integer> jaimie = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scanner.nextLine();

                if (!isOverlapped(cameron, start, end)) {
                    cameron.add(start);
                    cameron.add(end);
                    result.append("C");
                } else if (!isOverlapped(jaimie, start, end)) {
                    jaimie.add(start);
                    jaimie.add(end);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    scanner.nextLine(); // Skip the remaining input for this case
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", i, result.toString());
        }
    }
}