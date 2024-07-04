import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            long sum = l + r;
            long left = 0;
            long right = 2_000_000_000L;
            long mid;

            while (left + 1 < right) {
                mid = (left + right) / 2;
                if (sum >= (mid * (mid + 1)) / 2 + 2 * (mid + 1)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            long totalBlocks = left + 1;
            boolean isLeftLarger = l >= r;
            long difference = Math.abs(l - r);
            left = 0;
            right = difference + 1;

            while (left + 1 < right) {
                mid = (left + right) / 2;
                if ((mid * (mid + 1)) / 2 <= difference) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            long firstBlock = left;

            if (isLeftLarger) {
                l -= (firstBlock * (firstBlock + 1)) / 2;
            } else {
                r -= (firstBlock * (firstBlock + 1)) / 2;
            }

            if (firstBlock > totalBlocks) {
                System.out.println("Case #" + caseNumber + ": " + firstBlock + " " + l + " " + r);
            } else {
                long remainingBlocks = totalBlocks - firstBlock;
                if (l == r) {
                    isLeftLarger = true;
                }

                long num = remainingBlocks / 2;
                firstBlock++;

                if (isLeftLarger) {
                    l -= (num * firstBlock + num * (num - 1));
                    r -= (num * (firstBlock + 1) + num * (num - 1));
                    if (remainingBlocks % 2 == 1) {
                        l -= totalBlocks;
                    }
                } else {
                    l -= (num * (firstBlock + 1) + num * (num - 1));
                    r -= (num * firstBlock + num * (num - 1));
                    if (remainingBlocks % 2 == 1) {
                        r -= totalBlocks;
                    }
                }

                if (l >= totalBlocks + 1) {
                    l -= totalBlocks + 1;
                    totalBlocks++;
                } else if (r >= totalBlocks + 1) {
                    r -= totalBlocks + 1;
                    totalBlocks++;
                }

                System.out.println("Case #" + caseNumber + ": " + totalBlocks + " " + l + " " + r);
            }
        }
    }
}