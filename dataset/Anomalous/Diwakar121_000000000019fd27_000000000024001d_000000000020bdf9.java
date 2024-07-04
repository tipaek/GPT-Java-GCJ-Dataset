import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] startTimes = new int[1000];
        int[] endTimes = new int[1000];
        char[] persons = new char[1000];

        for (int testCase = 0; testCase < testCases; testCase++) {
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                char currentPerson = 'C';
                char otherPerson = 'C';
                boolean conflictDetected = false;

                for (int j = 0; j < i; j++) {
                    if ((startTimes[i] < endTimes[j] && startTimes[i] >= startTimes[j]) ||
                        (endTimes[i] <= endTimes[j] && endTimes[i] > startTimes[j])) {

                        if (!conflictDetected) {
                            otherPerson = persons[j];
                            conflictDetected = true;
                            currentPerson = (persons[j] == 'C') ? 'J' : 'C';
                        } else if (conflictDetected && persons[j] != otherPerson) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    break;
                }

                result.append(currentPerson);
                persons[i] = currentPerson;
            }

            if (isImpossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (testCase + 1) + ": " + result);
            }
        }

        scanner.close();
    }
}