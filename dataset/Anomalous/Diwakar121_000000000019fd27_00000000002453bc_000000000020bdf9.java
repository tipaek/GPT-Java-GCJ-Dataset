import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] startTimes = new int[1000];
        int[] endTimes = new int[1000];
        char[] persons = new char[1000];

        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                boolean conflictFound = false;
                char assignedPerson = 'C';
                char currentPerson = 'C';

                if (isImpossible) {
                    continue;
                }

                for (int k = 0; k < i; k++) {
                    boolean isOverlapping = (startTimes[i] < endTimes[k] && startTimes[i] >= startTimes[k]) ||
                                            (endTimes[i] <= endTimes[k] && endTimes[i] > startTimes[k]);

                    if (isOverlapping) {
                        if (!conflictFound) {
                            currentPerson = persons[k];
                            conflictFound = true;
                            assignedPerson = (persons[k] == 'C') ? 'J' : 'C';
                        } else if (persons[k] != currentPerson) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) {
                    continue;
                }

                schedule.append(assignedPerson);
                persons[i] = assignedPerson;
            }

            if (isImpossible) {
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (z + 1) + ": " + schedule);
            }
        }

        scanner.close();
    }
}