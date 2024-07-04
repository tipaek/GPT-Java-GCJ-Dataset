import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int testCase = 0;
        int roofTestCase = 0;
        int tc = 0;
        int schedulCount[] = new int[100];
        int scheduleInfo[][][] = new int[100][1000][2];

        Scanner sc = new Scanner(System.in);

        testCase = Integer.parseInt(sc.nextLine());

        roofTestCase = testCase;

        while (roofTestCase-- > 0) {
            schedulCount[tc] = sc.nextInt();

            for (int i = 0; i < schedulCount[tc]; i++) {
                for (int j = 0; j < 2; j++) {
                    scheduleInfo[tc][i][j] = sc.nextInt();
                }
            }

            tc++;
        }

        // initialize variable
        tc = 0;
        roofTestCase = testCase;

        while (roofTestCase-- > 0) {

            int duplicate = 0;
            StringBuilder result = new StringBuilder();

            int cameron[][] = new int[1000][2];
            int jamie[][] = new int[1000][2];

            for (int i = 0; i < 1000; i++) {
                Arrays.fill(cameron[i], -1);
                Arrays.fill(jamie[i], -1);
            }

            for (int i = 0; i < schedulCount[tc] - 1; i++) {
                if (scheduleCheck(scheduleInfo[tc][i], scheduleInfo[tc])) {
                    duplicate++;
                    if (duplicate > 1) break;
                }
            }

            for (int i = 0; duplicate < 2 && i < schedulCount[tc]; i++) {
                if (scheduleCheck(scheduleInfo[tc][i], cameron)) {
                    result.append("C");
                } else if (scheduleCheck(scheduleInfo[tc][i], jamie)) {
                    result.append("J");
                }
            }

            if (duplicate > 1)
                System.out.printf("Case #%d: IMPOSSIBLE", tc + 1);
            else
                System.out.printf("Case #%d: %s", tc + 1, result.toString());

            tc++;

            if (tc != testCase)
                System.out.println();
        }
    }

    private static boolean duplicateCheck(int[][] ints, int i) {
        return (ints[i][0] < ints[i + 1][0] && ints[i][1] > ints[i + 1][0]) ||
                (ints[i][0] > ints[i + 1][0] && ints[i + 1][1] > ints[i][0]) ||
                (ints[i][0] == ints[i + 1][0]) ||
                (ints[i][1] == ints[i + 1][1]);
    }

    private static boolean scheduleCheck(int[] ints, int[][] who) {
        int next = 0;
        for (int i = 0; i < who.length; i++) {
            if ((who[i][0] < ints[0] && who[i][1] > ints[0]) ||
                    (who[i][0] > ints[0] && ints[1] > who[i][0]) ||
                    (who[i][0] == ints[0]) ||
                    (who[i][1] == ints[1])) {
                return false;
            }
            if (i + 1 != who.length && (who[i + 1][0] == -1)) {
                next = i + 1;
                break;
            }
        }

        who[next] = ints;

        return true;
    }
}
