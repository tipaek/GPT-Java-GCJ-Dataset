import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            scanner.nextLine();
            StringBuilder schedule = new StringBuilder("0".repeat(1441));
            StringBuilder result = new StringBuilder();

            int conflictStart = -1;
            char currentHandler = 'C';
            char alternateHandler = 'J';

            for (int j = 0; j < n; j++) {
                char taskHandler = currentHandler;
                boolean switchHandler = false;
                String line = scanner.nextLine();
                
                if (line.isEmpty()) {
                    continue;
                }

                String[] timeStamps = line.split("\\s+");
                int start, end;

                try {
                    start = Integer.parseInt(timeStamps[0]);
                    end = Integer.parseInt(timeStamps[1]);
                } catch (NumberFormatException e) {
                    continue;
                }

                for (int k = start; k < end; k++) {
                    if (schedule.charAt(k) == 'B') {
                        taskHandler = 'I';
                        break;
                    }
                    if (schedule.charAt(k) == currentHandler) {
                        schedule.setCharAt(k, 'B');
                        if (conflictStart < 0) {
                            conflictStart = k;
                        }
                        taskHandler = alternateHandler;
                        switchHandler = true;
                    } else {
                        schedule.setCharAt(k, currentHandler);
                    }
                }

                if (conflictStart > start) {
                    for (int l = start; l < conflictStart; l++) {
                        schedule.setCharAt(l, alternateHandler);
                    }
                }

                if (switchHandler) {
                    char temp = currentHandler;
                    currentHandler = alternateHandler;
                    alternateHandler = temp;
                }

                if (taskHandler == 'I') {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    result.append(taskHandler);
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}