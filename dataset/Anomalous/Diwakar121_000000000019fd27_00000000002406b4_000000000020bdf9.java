import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] persons = new char[n];
            boolean isPossible = true;
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                char currentPerson = 'C';
                boolean conflictFound = false;

                for (int j = 0; j < i; j++) {
                    if ((startTimes[i] < endTimes[j] && startTimes[i] >= startTimes[j]) || 
                        (endTimes[i] <= endTimes[j] && endTimes[i] > startTimes[j])) {
                        if (!conflictFound) {
                            currentPerson = persons[j] == 'C' ? 'J' : 'C';
                            conflictFound = true;
                        } else if (persons[j] != currentPerson) {
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (!isPossible) {
                    break;
                }

                answer.append(currentPerson);
                persons[i] = currentPerson;
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + answer);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}