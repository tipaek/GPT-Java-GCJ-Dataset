import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignedPerson = new char[n];
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                char assigned = 'C';
                boolean conflict = false;

                for (int j = 0; j < i; j++) {
                    if (startTimes[i] < endTimes[j] && startTimes[i] >= startTimes[j]) {
                        if (!conflict) {
                            assigned = (assignedPerson[j] == 'C') ? 'J' : 'C';
                            conflict = true;
                        } else if (assignedPerson[j] == assigned) {
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (!isPossible) {
                    break;
                }

                result.append(assigned);
                assignedPerson[i] = assigned;
            }

            if (isPossible) {
                System.out.println("Case #" + (z + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}