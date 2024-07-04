import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int time = start; time < end; time++) {
                    if (cSchedule[time]) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    for (int time = start; time < end; time++) {
                        cSchedule[time] = true;
                    }
                    result.append('C');
                } else {
                    for (int time = start; time < end; time++) {
                        if (jSchedule[time]) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        for (int time = start; time < end; time++) {
                            jSchedule[time] = true;
                        }
                        result.append('J');
                    } else {
                        isImpossible = true;
                    }
                }
            }

            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }
}