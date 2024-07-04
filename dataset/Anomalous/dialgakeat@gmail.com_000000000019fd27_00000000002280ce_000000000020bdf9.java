import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int k = start; k < end; k++) {
                    if (cSchedule[k]) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    for (int k = start; k < end; k++) {
                        cSchedule[k] = true;
                    }
                    result.append('C');
                } else {
                    for (int k = start; k < end; k++) {
                        if (jSchedule[k]) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    if (canAssignJ) {
                        for (int k = start; k < end; k++) {
                            jSchedule[k] = true;
                        }
                        result.append('J');
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.print("Case #" + i + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }

        scanner.close();
    }
}