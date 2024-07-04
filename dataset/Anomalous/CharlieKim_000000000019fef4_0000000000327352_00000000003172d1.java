import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numOfCases; caseIndex++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Long> angles = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                angles.add(scanner.nextLong());
            }

            int result = solve(n, d, angles);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static int solve(int n, int d, List<Long> angles) {
        Map<Long, Integer> angleFrequencyMap = new HashMap<>();

        for (Long angle : angles) {
            angleFrequencyMap.merge(angle, 1, Integer::sum);
        }

        if (angleFrequencyMap.containsValue(d)) {
            return 0;
        }

        if (d == 2) {
            return 1;
        }

        angles.sort(Comparator.naturalOrder());

        for (int i = 0; i < angles.size(); i++) {
            for (int j = i + 1; j < angles.size(); j++) {
                if (angles.get(i) * 2 == angles.get(j)) {
                    return 1;
                }
            }
        }

        return 2;
    }
}