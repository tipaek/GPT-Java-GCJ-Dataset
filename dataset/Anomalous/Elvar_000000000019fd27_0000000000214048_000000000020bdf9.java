import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            int[][] J = new int[activitiesCount + 1][2];
            int JIndex = 0;
            int[][] C = new int[activitiesCount + 1][2];
            int CIndex = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!result.toString().equals("IMPOSSIBLE")) {
                    boolean canAssignToJ = true;
                    for (int k = 0; J[k][1] > 0; k++) {
                        int jStart = J[k][0];
                        int jEnd = J[k][1];
                        if ((jStart <= start && start < jEnd) || (jStart < end && end <= jEnd) || (start <= jStart && jEnd <= end)) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    boolean canAssignToC = true;
                    for (int k = 0; C[k][1] > 0; k++) {
                        int cStart = C[k][0];
                        int cEnd = C[k][1];
                        if ((cStart <= start && start < cEnd) || (cStart < end && end <= cEnd) || (start <= cStart && cEnd <= end)) {
                            canAssignToC = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        J[JIndex][0] = start;
                        J[JIndex][1] = end;
                        JIndex++;
                        result.append("J");
                    } else if (canAssignToC) {
                        C[CIndex][0] = start;
                        C[CIndex][1] = end;
                        CIndex++;
                        result.append("C");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
        scanner.close();
    }
}