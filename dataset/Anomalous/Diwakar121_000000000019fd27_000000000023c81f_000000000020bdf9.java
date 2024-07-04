import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            char[] person = new char[n];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
                char assignedPerson = 'C';
                boolean conflictDetected = false;

                for (int j = 0; j < i; j++) {
                    if ((start[i] < end[j] && start[i] >= start[j]) || (end[i] <= end[j] && end[i] > start[j])) {
                        if (!conflictDetected) {
                            conflictDetected = true;
                            assignedPerson = (person[j] == 'C') ? 'J' : 'C';
                        } else if (assignedPerson == person[j]) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    break;
                }

                result.append(assignedPerson);
                person[i] = assignedPerson;
            }

            if (isImpossible) {
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (z + 1) + ": " + result);
            }
        }

        scanner.close();
    }
}