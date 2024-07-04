import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] jamie = new int[1440];
            int[] cameron = new int[1440];
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (possible) {
                    boolean canAssignToJamie = true;

                    for (int j = start; j < end; j++) {
                        if (jamie[j] == 1) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        for (int j = start; j < end; j++) {
                            jamie[j] = 1;
                        }
                        result.append("J");
                    } else {
                        boolean canAssignToCameron = true;

                        for (int j = start; j < end; j++) {
                            if (cameron[j] == 1) {
                                canAssignToCameron = false;
                                break;
                            }
                        }

                        if (canAssignToCameron) {
                            for (int j = start; j < end; j++) {
                                cameron[j] = 1;
                            }
                            result.append("C");
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            possible = false;
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}