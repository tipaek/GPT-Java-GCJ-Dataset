import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int z = 1; z <= t; z++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignedPersons = new char[n];
            StringBuilder answer = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                char assignedPerson = 'C';
                boolean conflictFound = false;

                for (int j = 0; j < i; j++) {
                    if ((startTimes[i] < endTimes[j] && startTimes[i] >= startTimes[j]) ||
                        (endTimes[i] <= endTimes[j] && endTimes[i] > startTimes[j])) {
                        if (!conflictFound) {
                            assignedPerson = assignedPersons[j] == 'C' ? 'J' : 'C';
                            conflictFound = true;
                        } else if (assignedPersons[i] != assignedPersons[j]) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    break;
                }

                assignedPersons[i] = assignedPerson;
                answer.append(assignedPerson);
            }

            if (isImpossible) {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + z + ": " + answer.toString());
            }
        }
    }
}