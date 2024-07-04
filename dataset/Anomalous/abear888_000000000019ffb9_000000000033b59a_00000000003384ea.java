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

            long total = left + 1;
            boolean leftLarger = l >= r;
            long difference = Math.abs(l - r);
            left = 0;
            right = difference;

            while (left + 1 < right) {
                mid = (left + right) / 2;
                if ((mid * (mid + 1)) / 2 <= difference) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            long firstBlock = left;
            if (leftLarger) {
                l -= (firstBlock * (firstBlock + 1)) / 2;
            } else {
                r -= (firstBlock * (firstBlock + 1)) / 2;
            }

            long remaining = total - firstBlock;
            leftLarger = l >= r;
            long halfRemaining = remaining / 2;
            firstBlock++;

            if (leftLarger) {
                l -= (halfRemaining * firstBlock + halfRemaining * (halfRemaining - 1));
                r -= (halfRemaining * (firstBlock + 1) + halfRemaining * (halfRemaining - 1));
                if (remaining % 2 == 1) l -= total;
            } else {
                l -= (halfRemaining * (firstBlock + 1) + halfRemaining * (halfRemaining - 1));
                r -= (halfRemaining * firstBlock + halfRemaining * (halfRemaining - 1));
                if (remaining % 2 == 1) r -= total;
            }

            if (l >= total + 1) {
                l -= total + 1;
                total++;
            } else if (r >= total + 1) {
                r -= total + 1;
                total++;
            }

            System.out.println("Case #" + caseNumber + ": " + total + " " + l + " " + r);
        }
    }
}