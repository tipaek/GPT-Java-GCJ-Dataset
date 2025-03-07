import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int testCase = 0;
        int roofTestCase = 0;
        int tc = 0;
        int schedulCount[] = new int[100];
        long scheduleInfo[][][] = new long[100][1000][2];

        Scanner sc = new Scanner(System.in);

        testCase = Integer.parseInt(sc.nextLine());

        roofTestCase = testCase;

        while (roofTestCase-- > 0) {
            schedulCount[tc] = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                Arrays.fill(scheduleInfo[tc][i], -1);
            }

            for (int i = 0; i < schedulCount[tc]; i++) {
                for (int j = 0; j < 2; j++) {
                    scheduleInfo[tc][i][j] = sc.nextLong();
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

            long cameron[][] = new long[1000][2];
            long jamie[][] = new long[1000][2];

            for (int i = 0; i < 1000; i++) {
                Arrays.fill(cameron[i], -1);
                Arrays.fill(jamie[i], -1);
            }

            duplicate = getDuplicate(schedulCount[tc], scheduleInfo[tc], duplicate);

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

    private static int getDuplicate(int i1, long[][] longs, int duplicate) {
        for (int i = 0; i < i1 - 2; i++) {
            for (int j = i + 1; j < i1 - 1; j++) {
                if (duplicateCheck(longs[i], longs[j])) {
                    for (int k = j + 1; k < i1; k++) {
                        if (duplicateCheck(longs[j], longs[k])) {
                            if (duplicateCheck(longs[k], longs[i])) {
                                duplicate = 2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return duplicate;
    }

    private static boolean duplicateCheck(long[] first, long[] second) {
        if ((second[0] < first[0] && second[1] > first[0]) ||
                (second[0] > first[0] && first[1] > second[0]) ||
                (second[0] == first[0]) ||
                (second[1] == first[1])) {
            return true;
        }
        return false;
    }

    private static boolean scheduleCheck(long[] ints, long[][] who) {
        int next = 0;
        for (int i = 0; i < who.length-1; i++) {
            if ((who[i][0] < ints[0] && who[i][1] > ints[0]) ||
                    (who[i][0] > ints[0] && ints[1] > who[i][0]) ||
                    (who[i][0] == ints[0]) ||
                    (who[i][1] == ints[1])) {
                return false;
            }
            if ((who[i + 1][0] == -1)) {
                next = i + 1;
                break;
            }
        }

        who[next] = ints;

        return true;
    }
}
