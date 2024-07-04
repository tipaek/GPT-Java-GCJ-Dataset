import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            boolean[] occupiedByCameron = new boolean[1440];
            boolean[] occupiedByJamie = new boolean[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
                intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
            }

            Arrays.fill(occupiedByCameron, false);
            Arrays.fill(occupiedByJamie, false);

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                for (int j = start; j < end; j++) {
                    if (occupiedByCameron[j]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    for (int j = start; j < end; j++) {
                        occupiedByCameron[j] = true;
                    }
                    result.append("C");
                } else {
                    for (int j = start; j < end; j++) {
                        if (occupiedByJamie[j]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        for (int j = start; j < end; j++) {
                            occupiedByJamie[j] = true;
                        }
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}