import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            if (bits == 10) {
                int[] bitsArray = new int[10];
                for (int i = 0; i < bitsArray.length; i++) {
                    bitsArray[i] = scanner.nextInt();
                }
                StringBuilder binaryString = new StringBuilder();
                for (int bit : bitsArray) {
                    binaryString.append(bit == 1 ? "1" : "0");
                }
                System.out.println(binaryString);
                String correct = scanner.next();
                continue;
            }

            boolean[] same = new boolean[bits / 2];
            int[] nums = new int[bits];

            for (int i = 0; i < bits / 2; i++) {
                System.out.println(i + 1);
                nums[i] = scanner.nextInt();
                System.out.println(bits - i);
                nums[bits - i - 1] = scanner.nextInt();
                same[i] = nums[i] == nums[bits - i - 1];
            }

            int rows = bits / 20;
            String[] status = new String[rows];
            int[] indices = new int[rows * 2];

            for (int i = 0; i < rows; i++) {
                boolean hasSame = false;
                boolean hasDiff = false;
                int indexSame = -1;
                int indexDiff = -1;

                for (int j = 0; j < 10; j++) {
                    if (same[i * 10 + j]) {
                        hasSame = true;
                        indexSame = i * 10 + j;
                    } else {
                        hasDiff = true;
                        indexDiff = i * 10 + j;
                    }
                }

                if (hasSame && hasDiff) {
                    status[i] = "both";
                    indices[2 * i] = indexSame;
                    indices[2 * i + 1] = indexDiff;
                } else if (hasSame) {
                    status[i] = "same";
                    indices[2 * i] = indexSame;
                    indices[2 * i + 1] = indexSame;
                } else {
                    status[i] = "diff";
                    indices[2 * i] = indexDiff;
                    indices[2 * i + 1] = indexDiff;
                }
            }

            int[] current = new int[indices.length];
            for (int i = 0; i < indices.length / 2; i++) {
                System.out.println(indices[2 * i] + 1);
                current[2 * i] = scanner.nextInt();
                System.out.println(indices[2 * i + 1] + 1);
                current[2 * i + 1] = scanner.nextInt();
            }

            String[] rowOperations = new String[rows];
            for (int i = 0; i < rows; i++) {
                int sBefore = nums[indices[2 * i]];
                int dBefore = nums[indices[2 * i + 1]];
                int sNow = current[2 * i];
                int dNow = current[2 * i + 1];

                if (status[i].equals("both")) {
                    if (sBefore == sNow && dBefore == dNow) {
                        rowOperations[i] = "none";
                    } else if (sBefore != sNow && dBefore != dNow) {
                        rowOperations[i] = "flip";
                    } else if (sBefore == sNow) {
                        rowOperations[i] = "reverse";
                    } else {
                        rowOperations[i] = "both";
                    }
                } else if (status[i].equals("diff")) {
                    rowOperations[i] = dBefore == dNow ? "flip" : "none";
                } else {
                    rowOperations[i] = sBefore == sNow ? "none" : "flip";
                }
            }

            int[] result = new int[bits];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < 10; j++) {
                    result[i * 10 + j] = nums[i * 10 + j];
                    if (rowOperations[i].equals("flip")) {
                        result[i * 10 + j] = result[i * 10 + j] == 1 ? 0 : 1;
                    } else if (rowOperations[i].equals("reverse") && !same[i * 10 + j]) {
                        result[i * 10 + j] = result[i * 10 + j] == 1 ? 0 : 1;
                    } else if (rowOperations[i].equals("both") && same[i * 10 + j]) {
                        result[i * 10 + j] = result[i * 10 + j] == 1 ? 0 : 1;
                    }
                }
            }

            int c = rows * 10;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < 10; j++) {
                    int index = c + i * 10 + j;
                    result[index] = nums[nums.length - 1 - index];
                    if (!same[nums.length - 1 - index]) {
                        result[index] = result[index] == 1 ? 0 : 1;
                    }
                }
            }

            StringBuilder finalString = new StringBuilder();
            for (int bit : result) {
                finalString.append(bit == 1 ? "1" : "0");
            }

            System.out.println(finalString);
            String correct = scanner.next();
            System.out.println(correct);
        }
    }
}