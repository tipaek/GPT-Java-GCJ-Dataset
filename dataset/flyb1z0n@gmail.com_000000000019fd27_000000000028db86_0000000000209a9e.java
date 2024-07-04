import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static final int FLAG_SAME = 1;
    private static final int FLAG_DIFFERENT = 0;
    private static final int UNDEFINED = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();
        int bitsCount = sc.nextInt();
        PrintWriter pr = new PrintWriter(System.out, true);
        for (int t = 1; t <= testCaseCount; t++) {
            boolean isSuccess = solve(sc, pr, bitsCount);
            if (!isSuccess) {
                System.exit(0);
            }
        }
    }

    private static boolean solve(Scanner sc, PrintWriter pr, int bitsCount) {
        int[] flag = new int[bitsCount / 2 + 1];
        int[] arr = new int[bitsCount / 2 + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = UNDEFINED;
            flag[i] = UNDEFINED;
        }

        int requestCount = 0;
        int pointer = 1;

        while (pointer <= bitsCount / 2) {
            if (requestCount != 0 && requestCount % 10 == 0) {
                requestCount += reCalc(sc, pr, flag, arr);
                continue;
            }

            final int leftValue = request(sc, pr, pointer);
            final int rightValue = request(sc, pr, bitsCount - pointer + 1);
            arr[pointer] = leftValue;
            flag[pointer] = leftValue == rightValue ? FLAG_SAME : FLAG_DIFFERENT;
            requestCount += 2;
            pointer++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            int val = flag[i] == FLAG_SAME ? arr[i] : invert(arr[i]);
            sb.append(val);
        }
        pr.println(sb.toString());
        pr.flush();
        final String result = sc.next();
        return "Y".equals(result);
    }

    private static int reCalc(Scanner sc, PrintWriter pr, int[] flag, int[] arr) {
        int requestCount = 0;
        int idx_same = findFist(flag, FLAG_SAME);
        if (idx_same > 0) {
            final int res_same = request(sc, pr, idx_same);
            if (arr[idx_same] != res_same) {
                invertValues(flag, arr, FLAG_SAME);
            }
            requestCount++;
        }

        int idx_diff = findFist(flag, FLAG_DIFFERENT);
        if (idx_diff > 0) {
            final int res_same = request(sc, pr, idx_diff);
            if (arr[idx_same] != res_same) {
                invertValues(flag, arr, FLAG_DIFFERENT);
            }
            requestCount++;
        }
        return requestCount;
    }


    private static void invertValues(int[] flag, int[] arr, int value) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == value) {
                arr[i] = invert(arr[i]);
            }
        }
    }

    private static int invert(int i) {
        return i == 1 ? 0 : 1;
    }

    private static int findFist(int[] flag, int value) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == value) {
                return i;
            }
        }
        return UNDEFINED;
    }

    private static int request(Scanner sc, PrintWriter pr, int index) {
        pr.println(index);
        pr.flush();
        return sc.nextInt();
    }


    private static boolean solveInit(Scanner sc, PrintWriter pr, int bitsCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= bitsCount; i++) {
            pr.println(i);
            pr.flush();
            final int bitVal = sc.nextInt();
            sb.append(bitVal);
        }

        pr.println(sb.toString());
        pr.flush();
        final String result = sc.next();
        return "Y".equals(result);
    }

}
