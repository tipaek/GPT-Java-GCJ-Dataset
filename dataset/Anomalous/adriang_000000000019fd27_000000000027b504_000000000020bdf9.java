import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            char[] schedule = new char[1440]; // 1440 minutes in a day
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;
            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                boolean assigned = false;
                for (int i = start; i < end; i++) {
                    if (schedule[i] == 'C') {
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) {
                    for (int i = start; i < end; i++) {
                        schedule[i] = 'C';
                    }
                    result.append('C');
                } else {
                    assigned = false;
                    for (int i = start; i < end; i++) {
                        if (schedule[i] == 'J') {
                            assigned = true;
                            break;
                        }
                    }

                    if (!assigned) {
                        for (int i = start; i < end; i++) {
                            schedule[i] = 'J';
                        }
                        result.append('J');
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}