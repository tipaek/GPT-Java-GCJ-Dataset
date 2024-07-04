import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activities = scanner.nextInt();
            int[][] J = new int[activities + 1][2];
            int JIndex = 0;
            int[][] C = new int[activities + 1][2];
            int CIndex = 0;
            String result = "";

            for (int a = 0; a < activities; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!result.equals("IMPOSSIBLE")) {
                    boolean canAssignToJ = true;
                    for (int j = 0; J[j][1] > 0; j++) {
                        int jStart = J[j][0];
                        int jEnd = J[j][1];
                        if ((jStart <= start && start < jEnd) || (jStart < end && end <= jEnd) || (start <= jStart && jEnd <= end)) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    boolean canAssignToC = true;
                    for (int c = 0; C[c][1] > 0; c++) {
                        int cStart = C[c][0];
                        int cEnd = C[c][1];
                        if ((cStart <= start && start < cEnd) || (cStart < end && end <= cEnd) || (start <= cStart && cEnd <= end)) {
                            canAssignToC = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        J[JIndex][0] = start;
                        J[JIndex][1] = end;
                        JIndex++;
                        result += "J";
                    } else if (canAssignToC) {
                        C[CIndex][0] = start;
                        C[CIndex][1] = end;
                        CIndex++;
                        result += "C";
                    } else {
                        result = "IMPOSSIBLE";
                    }
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}