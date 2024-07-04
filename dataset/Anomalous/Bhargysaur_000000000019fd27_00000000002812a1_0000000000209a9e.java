import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < t; i++) {
            if (b == 10) {
                handleBaseCase(sc);
            } else {
                handleGeneralCase(sc, b);
            }
        }
    }

    private static void handleBaseCase(Scanner sc) {
        int[] l = new int[10];
        for (int j = 0; j < l.length; j++) {
            System.out.println(j + 1);
            l[j] = sc.nextInt();
        }

        StringBuilder str = new StringBuilder();
        for (int j : l) {
            str.append(j == 1 ? "1" : "0");
        }

        System.out.println(str);
        String correct = sc.next();
    }

    private static void handleGeneralCase(Scanner sc, int b) {
        boolean[] same = new boolean[b / 2];
        int[] nums = new int[b];

        for (int j = 0; j < b / 2; j++) {
            nums[j] = queryAndRead(sc, j + 1);
            nums[b - j - 1] = queryAndRead(sc, b - j);
            same[j] = nums[j] == nums[b - j - 1];
        }

        int rows = b / 20;
        String[] status = new String[rows];
        int[] indices = new int[rows * 2];

        determineStatusAndIndices(same, rows, status, indices);

        int[] current = new int[indices.length];
        for (int j = 0; j < indices.length / 2; j++) {
            current[2 * j] = queryAndRead(sc, indices[2 * j]);
            current[2 * j + 1] = queryAndRead(sc, indices[2 * j + 1]);
        }

        String[] rowOp = determineRowOperations(nums, current, status, indices, rows);

        int[] result = calculateResult(nums, same, rowOp, rows, b);

        printResult(result);

        String correct = sc.next();
        System.out.println(correct);
    }

    private static int queryAndRead(Scanner sc, int index) {
        System.out.println(index);
        return sc.nextInt();
    }

    private static void determineStatusAndIndices(boolean[] same, int rows, String[] status, int[] indices) {
        for (int j = 0; j < rows; j++) {
            boolean hasSame = false;
            boolean hasDiff = false;
            int indexSame = -1;
            int indexDiff = -1;

            for (int k = 0; k < 10; k++) {
                int index = rows * 10 + k;
                if (same[index]) {
                    hasSame = true;
                    indexSame = index;
                } else {
                    hasDiff = true;
                    indexDiff = index;
                }
            }

            if (hasSame && hasDiff) {
                status[j] = "both";
                indices[2 * j] = indexSame;
                indices[2 * j + 1] = indexDiff;
            } else if (hasSame) {
                status[j] = "same";
                indices[2 * j] = indices[2 * j + 1] = indexSame;
            } else {
                status[j] = "diff";
                indices[2 * j] = indices[2 * j + 1] = indexDiff;
            }
        }
    }

    private static String[] determineRowOperations(int[] nums, int[] current, String[] status, int[] indices, int rows) {
        String[] rowOp = new String[rows];

        for (int j = 0; j < rows; j++) {
            int sBefore = nums[indices[2 * j]];
            int dBefore = nums[indices[2 * j + 1]];
            int sNow = current[2 * j];
            int dNow = current[2 * j + 1];

            if (status[j].equals("both")) {
                rowOp[j] = determineBothOperation(sBefore, dBefore, sNow, dNow);
            } else if (status[j].equals("diff")) {
                rowOp[j] = dBefore == dNow ? "flip" : "none";
            } else {
                rowOp[j] = sBefore == sNow ? "none" : "flip";
            }
        }

        return rowOp;
    }

    private static String determineBothOperation(int sBefore, int dBefore, int sNow, int dNow) {
        if (sBefore == sNow && dBefore == dNow) {
            return "none";
        } else if (sBefore != sNow && dBefore != dNow) {
            return "flip";
        } else if (sBefore == sNow) {
            return "reverse";
        } else {
            return "both";
        }
    }

    private static int[] calculateResult(int[] nums, boolean[] same, String[] rowOp, int rows, int b) {
        int[] result = new int[b];

        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < 10; k++) {
                int index = j * 10 + k;
                result[index] = nums[index];
                applyOperation(result, index, rowOp[j], same);
            }
        }

        int c = rows * 10;
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < 10; k++) {
                int index = c + j * 10 + k;
                result[index] = nums[nums.length - 1 - index];
                if (!same[nums.length - 1 - index]) {
                    result[index] = 1 - result[index];
                }
            }
        }

        return result;
    }

    private static void applyOperation(int[] result, int index, String operation, boolean[] same) {
        if (operation.equals("flip")) {
            result[index] = 1 - result[index];
        } else if (operation.equals("reverse") && !same[index]) {
            result[index] = 1 - result[index];
        } else if (operation.equals("both") && same[index]) {
            result[index] = 1 - result[index];
        }
    }

    private static void printResult(int[] result) {
        StringBuilder str = new StringBuilder();
        for (int value : result) {
            str.append(value == 1 ? "1" : "0");
        }
        System.out.println(str);
    }
}