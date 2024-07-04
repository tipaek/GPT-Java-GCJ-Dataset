import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignedPerson = new char[n];

            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();

                char currentPerson = 'C';
                boolean conflictFound = false;

                for (int j = 0; j < i; j++) {
                    if (startTimes[i] < endTimes[j] && startTimes[i] >= startTimes[j]) {
                        if (!conflictFound) {
                            conflictFound = true;
                            currentPerson = (assignedPerson[j] == 'C') ? 'J' : 'C';
                        } else if (assignedPerson[j] == currentPerson) {
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (!isPossible) {
                    break;
                }

                result.append(currentPerson);
                assignedPerson[i] = currentPerson;
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}