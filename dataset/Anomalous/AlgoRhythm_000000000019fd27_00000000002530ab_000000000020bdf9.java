import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] jamieSchedule = new int[1440];
            int[] cameronSchedule = new int[1440];
            StringBuilder result = new StringBuilder();

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (!possible) {
                    continue;
                }

                boolean canAssignToJamie = true;
                for (int j = start; j < end; j++) {
                    if (jamieSchedule[j] == 1) {
                        canAssignToJamie = false;
                        break;
                    }
                }

                if (canAssignToJamie) {
                    for (int j = start; j < end; j++) {
                        jamieSchedule[j] = 1;
                    }
                    result.append("J");
                } else {
                    boolean canAssignToCameron = true;
                    for (int j = start; j < end; j++) {
                        if (cameronSchedule[j] == 1) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        for (int j = start; j < end; j++) {
                            cameronSchedule[j] = 1;
                        }
                        result.append("C");
                    } else {
                        possible = false;
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        scanner.close();
    }
}