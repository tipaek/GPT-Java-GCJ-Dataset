import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                System.out.print("Case #" + t + ": ");
                int activities = scanner.nextInt();
                boolean[] scheduleC = new boolean[1440];
                boolean[] scheduleJ = new boolean[1440];
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < activities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    boolean canAssignC = true;
                    boolean canAssignJ = true;

                    for (int j = start; j < end; j++) {
                        if (scheduleC[j]) {
                            canAssignC = false;
                            break;
                        }
                    }

                    if (!canAssignC) {
                        for (int j = start; j < end; j++) {
                            if (scheduleJ[j]) {
                                canAssignJ = false;
                                break;
                            }
                        }
                    }

                    if (canAssignC) {
                        for (int j = start; j < end; j++) {
                            scheduleC[j] = true;
                        }
                        result.append("C");
                    } else if (canAssignJ) {
                        for (int j = start; j < end; j++) {
                            scheduleJ[j] = true;
                        }
                        result.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(result.toString());
                }
            }
        }
    }
}