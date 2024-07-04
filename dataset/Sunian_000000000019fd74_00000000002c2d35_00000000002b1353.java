import java.util.*;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(scan.nextLine());
            handle(N, i + 1);
        }
    }

    private static void handle2(long total, int caseNum) {
        int bestRow = 1;
        int bestCol = 1;
        long minRemain = total;
        int bestTailSize = 0;
        for (int row = 1; true; row++) {
            List<Long> nums = computeRow(row);
            if (nums.get(nums.size() - 1) < total / 3) {
                continue;
            }
            for (int col = 1; col <= nums.size(); col++) {
                long sum = nums.get(col - 1) * 2 + (row - col - 1);
                long remain = total - sum;
                if (remain < 0) {
                    continue;
                }
                int tailSize = 0;
                for (int tail = col - 1; tail >= 1; tail--) {
                    if (nums.get(tail - 1) <= remain) {
                        remain -= nums.get(tail - 1);
                        tailSize++;
                    } else {
                        break;
                    }
                }
                if (remain < minRemain) {
                    minRemain = remain;
                    bestRow = row;
                    bestCol = col;
                    bestTailSize = tailSize;
                }
                if (minRemain == 0) {
                    break;
                }
            }
            if (minRemain == 0) {
                break;
            }
            if (nums.get(nums.size() / 2) > total * 5) {
                break;
            }
        }
        Set<Integer> extras = new HashSet<>();
        int col = bestCol - 1;
        for (int row = bestRow - 1; row > bestRow - bestCol; row--) {
            List<Long> nums = computeRow(row);
            if (nums.get(col - 1) <= minRemain) {
                extras.add(row);
                minRemain -= nums.get(col - 1);
            }
        }
        for (int row = bestRow - bestCol; row > 1; row--) {
            if ((row - 1) <= minRemain) {
                extras.add(row);
                minRemain -= row - 1;
            }
        }
        System.out.println("");
    }

    private static void handle(long total, int caseNum) {
        int lastRow = 1;
        long value = 1;
        while (value + (lastRow - 1) <= total) {
            lastRow++;
            value *= 2;
        }
        lastRow--;
        value /= 2;
        boolean[] traverse = new boolean[lastRow + 1];
        traverse[1] = true;
        traverse[lastRow] = true;
        long remain = total - value;
        value /= 2;
        for (int row = lastRow - 1; row >= 1; row--) {
            if (remain == row) {
                remain = 0;
                break;
            }
            if (remain >= value + (row - 1)) {
                traverse[row] = true;
                remain -= value;
            } else {
                remain--;
            }
            value /= 2;
        }
        System.out.printf("Case #%d:\n", caseNum);
        boolean leftSide = true;
        for (int row = 1; row < traverse.length; row++) {
            if (traverse[row]) {
                if (leftSide) {
                    for (int col = 1; col <= row; col++) {
                        System.out.printf("%d %d\n", row, col);
                    }
                } else {
                    for (int col = row; col > 0; col--) {
                        System.out.printf("%d %d\n", row, col);
                    }
                }
                leftSide = !leftSide;
            } else {
                System.out.printf("%d %d\n", row, leftSide ? 1 : row);
            }
        }
//        System.out.println("--");
        for (int i = 0; i < remain; i++) {
            int row = lastRow + 1 + i;
            int col = leftSide ? 1 : row;
            System.out.printf("%d %d\n", row, col);
        }
    }

    private static List<Long> computeRow(int row) {
        row--;
        List<Long> nums = new ArrayList<>(row);
        nums.add(1L);
        for (int i = 0; i < row / 2; i++) {
            nums.add(nums.get(i) * (row - i) / (i + 1));
        }
        return nums;
    }

}
