import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            List<Long> angles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                angles.add(scanner.nextLong());
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(n, d, angles));
        }
    }

    private static int solve(int n, int d, List<Long> angels) {
        Map<Long, Integer> angleMap = new HashMap<>();
        for (Long angle : angels) {
            angleMap.merge(angle, 1, Integer::sum);
        }

        if (angleMap.values().stream().anyMatch(item -> item == d)) {
            return 0;
        }

        if (d == 2) {
            return 1;
        }

        angels.sort(Comparator.comparingLong(angle -> angle));
        for (int i = 0; i < angels.size(); i++) {
            for (int j = i + 1; j < angels.size(); j++) {
                if (angels.get(i) * 2 == angels.get(j)) {
                    return 1;
                }
            }
        }

        return 2;
    }
}
