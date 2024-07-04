import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] startTimes = new int[1000];
        int[] endTimes = new int[1000];
        char[] persons = new char[1000];

        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                char assignedPerson = 'C';
                char conflictingPerson = 'C';
                boolean conflictDetected = false;

                for (int k = 0; k < i; k++) {
                    if (endTimes[k] <= startTimes[i] || startTimes[k] >= endTimes[i]) {
                        // No conflict
                    } else {
                        if (!conflictDetected) {
                            conflictingPerson = persons[k];
                            conflictDetected = true;
                            assignedPerson = (persons[k] == 'C') ? 'J' : 'C';
                        } else if (persons[k] != conflictingPerson) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    continue;
                }

                result.append(assignedPerson);
                persons[i] = assignedPerson;
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