import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int m = 1; m <= t; m++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            Map<String, String> taskMap = new LinkedHashMap<>();

            for (int j = 0; j < n; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
                taskMap.put(start[j] + " " + end[j], "");
            }

            // Bubble sort to sort tasks by start times
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (start[j] > start[j + 1]) {
                        int tempStart = start[j];
                        start[j] = start[j + 1];
                        start[j + 1] = tempStart;

                        int tempEnd = end[j];
                        end[j] = end[j + 1];
                        end[j + 1] = tempEnd;
                    }
                }
            }

            int cEnd = end[0];
            taskMap.put(start[0] + " " + end[0], "C");
            int jEnd = end[1];
            taskMap.put(start[1] + " " + end[1], "J");
            String result = "";

            for (int k = 2; k < n; k++) {
                if (cEnd <= start[k]) {
                    cEnd = end[k];
                    taskMap.put(start[k] + " " + end[k], "C");
                } else if (jEnd <= start[k]) {
                    jEnd = end[k];
                    taskMap.put(start[k] + " " + end[k], "J");
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder resBuilder = new StringBuilder();
                for (Map.Entry<String, String> entry : taskMap.entrySet()) {
                    resBuilder.append(entry.getValue());
                }
                result = resBuilder.toString();
            }

            System.out.println("Case #" + m + ": " + result);
        }
        sc.close();
    }
}