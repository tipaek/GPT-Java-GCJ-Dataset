import java.util.Scanner;
import java.util.Stack;

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
            Stack<String> result = new Stack<>();

            Stack<Pair> cameron = new Stack<>();
            Stack<Pair> jamie = new Stack<>();

            duplicate = getDuplicate(schedulCount[tc], scheduleInfo[tc], duplicate);

            if (duplicate <= 1)
                makeSchedule(scheduleInfo[tc], cameron, jamie, result, schedulCount[tc]);

            String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";

            if (duplicate > 1)
                System.out.printf("Case #%d: IMPOSSIBLE", tc + 1);
            else
                System.out.printf("Case #%d: %s", tc + 1, result.toString().replaceAll(match, "").replaceAll(" ", ""));

            tc++;

            if (tc != testCase)
                System.out.println();
        }
    }

    private static void makeSchedule(int[][] scheduleInfo, Stack<Pair> cameron, Stack<Pair> jamie, Stack<String> result, int count) {
        int dupTmp = 0;
        for (int i = 0; i < count; ) {
            if (dupTmp < 1 && scheduleCheck(scheduleInfo[i], cameron)) {
                cameron.push(new Pair(scheduleInfo[i][0], scheduleInfo[i][1]));
                result.push("C");
                i++;
            } else if (scheduleCheck(scheduleInfo[i], jamie)) {
                jamie.push(new Pair(scheduleInfo[i][0], scheduleInfo[i][1]));
                result.push("J");
                i++;
            } else if (dupTmp >= 1 && scheduleCheck(scheduleInfo[i], cameron)) {
                jamie.push(new Pair(scheduleInfo[i][0], scheduleInfo[i][1]));
                result.push("C");
                i++;
                dupTmp--;
            }
            else if (!(scheduleCheck(scheduleInfo[i], cameron) && scheduleCheck(scheduleInfo[i], jamie))) {
                dupTmp++;
                for (int j = 0; j < dupTmp; j++) {
                    String tmp = result.pop();
                    if (tmp.equals("C")) cameron.pop();
                    else jamie.pop();
                }
                i -= dupTmp;
            }
        }
    }


    private static int getDuplicate(int i1, int[][] longs, int duplicate) {
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

    private static boolean duplicateCheck(int[] first, int[] second) {
        if ((second[0] < first[0] && second[1] > first[0]) ||
                (second[0] > first[0] && first[1] > second[0]) ||
                (second[0] == first[0]) ||
                (second[1] == first[1])) {
            return true;
        }
        return false;
    }

    private static boolean scheduleCheck(int[] ints, Stack<Pair> who) {
        for (Pair o : who) {
            if ((o.left < ints[0] && o.right > ints[0]) ||
                    (o.left > ints[0] && ints[1] > o.left) ||
                    (o.left == ints[0]) ||
                    (o.right == ints[1])) {
                return false;
            }
        }
        return true;
    }

    private static class Pair {
        public long left;
        public long right;

        public Pair(long left, long right) {
            this.left = left;
            this.right = right;
        }
    }
}