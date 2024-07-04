import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            StringBuilder schedule = new StringBuilder(" ".repeat(n));

            Map<int[], Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(intervals[i], i);
            }

            cameron.add(intervals[0]);
            schedule.setCharAt(0, 'C');
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                int[] current = intervals[i];
                int index = indexMap.get(current);

                if (current[0] >= cameron.get(cameron.size() - 1)[1]) {
                    cameron.add(current);
                    schedule.setCharAt(index, 'C');
                } else if (jamie.isEmpty() || current[0] >= jamie.get(jamie.size() - 1)[1]) {
                    jamie.add(current);
                    schedule.setCharAt(index, 'J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                writer.println("Case #" + t + ": " + schedule.toString());
            } else {
                writer.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        writer.flush();
        scanner.close();
        writer.close();
    }
}