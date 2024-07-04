import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            StringBuilder output = new StringBuilder("CJ");

            String[] task1 = scanner.nextLine().split(" ");
            String[] task2 = scanner.nextLine().split(" ");
            
            int start1 = Integer.parseInt(task1[0]);
            int end1 = Integer.parseInt(task1[1]);
            int start2 = Integer.parseInt(task2[0]);
            int end2 = Integer.parseInt(task2[1]);

            Arrays.fill(cTime, start1, end1 == 1440 ? end1 : end1 + 1, true);
            Arrays.fill(jTime, start2, end2 == 1440 ? end2 : end2 + 1, true);

            boolean possible = true;

            for (int i = 2; i < n; i++) {
                String[] task = scanner.nextLine().split(" ");
                int start = Integer.parseInt(task[0]);
                int end = Integer.parseInt(task[1]);

                boolean cAvailable = !cTime[start] && !cTime[end - 1];
                boolean jAvailable = !jTime[start] && !jTime[end - 1];

                if (cAvailable) {
                    output.append("C");
                    Arrays.fill(cTime, start, end == 1440 ? end : end + 1, true);
                } else if (jAvailable) {
                    output.append("J");
                    Arrays.fill(jTime, start, end == 1440 ? end : end + 1, true);
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + output.toString());
        }

        scanner.close();
    }
}