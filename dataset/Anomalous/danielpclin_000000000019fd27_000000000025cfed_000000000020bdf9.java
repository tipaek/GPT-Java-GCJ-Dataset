import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                System.out.print("Case #" + t + ": ");
                int activities = scanner.nextInt();
                boolean[] cameron = new boolean[1440];
                boolean[] jamie = new boolean[1440];
                boolean isImpossible = false;
                StringBuilder schedule = new StringBuilder();

                for (int i = 0; i < activities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    if (isImpossible) {
                        continue;
                    }

                    boolean canAssignCameron = true;
                    boolean canAssignJamie = true;

                    for (int j = start; j < end; j++) {
                        if (cameron[j]) {
                            canAssignCameron = false;
                            break;
                        }
                    }

                    if (!canAssignCameron) {
                        for (int j = start; j < end; j++) {
                            if (jamie[j]) {
                                canAssignJamie = false;
                                break;
                            }
                        }
                    }

                    if (canAssignCameron) {
                        for (int j = start; j < end; j++) {
                            cameron[j] = true;
                        }
                        schedule.append("C");
                    } else if (canAssignJamie) {
                        for (int j = start; j < end; j++) {
                            jamie[j] = true;
                        }
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                    }
                }

                if (isImpossible) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(schedule.toString());
                }
            }
        }
    }
}