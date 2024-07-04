import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            TreeMap<Integer, String> scheduleMap = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scheduleMap.put(start, end + "," + j);
            }

            int cameronEnd = -1;
            int jamieEnd = -1;
            char[] assignments = new char[n];
            boolean isImpossible = false;

            for (int start : scheduleMap.keySet()) {
                String[] value = scheduleMap.get(start).split(",");
                int end = Integer.parseInt(value[0]);
                int index = Integer.parseInt(value[1]);

                if (start >= cameronEnd) {
                    cameronEnd = end;
                    assignments[index] = 'C';
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    assignments[index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": Impossible");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + new String(assignments));
            }
        }
    }
}