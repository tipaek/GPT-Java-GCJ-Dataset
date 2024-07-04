import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];

            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            Set<Integer> setC = new HashSet<>();
            int lastEndC = activities[0][1];
            setC.add(activities[0][2]);

            for (int i = 1; i < n; i++) {
                if (lastEndC <= activities[i][0]) {
                    setC.add(activities[i][2]);
                    lastEndC = activities[i][1];
                }
            }

            Set<Integer> setJ = new HashSet<>();
            int lastEndJ = -1;

            for (int i = 0; i < n; i++) {
                if (!setC.contains(activities[i][2])) {
                    if (lastEndJ == -1 || lastEndJ <= activities[i][0]) {
                        setJ.add(activities[i][2]);
                        lastEndJ = activities[i][1];
                    }
                }
            }

            if (setC.size() + setJ.size() == n) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (setC.contains(i)) {
                        result.append('C');
                    } else {
                        result.append('J');
                    }
                }
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}