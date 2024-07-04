import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    private void solve(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();

        int absX = Math.abs(x);
        int absY = Math.abs(y);

        int higherX = getFirstHigherPowerOfTwo(absX);
        int higherY = getFirstHigherPowerOfTwo(absY);

        int diffX = higherX - absX;
        int diffY = higherY - absY;

        int maxLen = Math.max(getLogBase2(higherX), getLogBase2(higherY));

        List<String> results = new ArrayList<>();

        if (isValid(absX + absY)) {
            String result = calculateBinaryRepresentation(absX, maxLen);
            System.out.println(adjustDirections(result, x, y));
            return;
        }

        if (isValid(higherY + diffY + absX)) {
            String result = calculateBinaryRepresentation(absX, maxLen);
            result = adjustDirections(result, x, -y);
            if (absY > absX) {
                result += (y > 0) ? 'N' : 'S';
            } else {
                result = replaceLastChar(result, (y > 0) ? 'S' : 'N', (y > 0) ? 'N' : 'S');
            }
            results.add(result);
        }

        if (isValid(higherX + diffX + absY)) {
            String result = calculateBinaryRepresentation(diffX, maxLen);
            result = adjustDirections(result, -x, y);
            if (absX > absY) {
                result += (x > 0) ? 'E' : 'W';
            } else {
                result = replaceLastChar(result, (x > 0) ? 'W' : 'E', (x > 0) ? 'E' : 'W');
            }
            results.add(result);
        }

        if (isValid(higherX + diffX + higherY + diffY)) {
            String result = calculateBinaryRepresentation(diffX, maxLen);
            result += (higherX > higherY) ? (x > 0 ? 'E' : 'W') : (y > 0 ? 'N' : 'S');
            results.add(result);
        }

        if (results.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(results.stream().min(Comparator.comparingInt(String::length)).orElseThrow());
        }
    }

    private String replaceLastChar(String str, char target, char replacement) {
        int lastIndex = str.lastIndexOf(target);
        if (lastIndex == -1) {
            throw new RuntimeException("replace last failed");
        }
        return str.substring(0, lastIndex) + replacement + str.substring(lastIndex + 1);
    }

    private String adjustDirections(String binaryStr, int x, int y) {
        char xChar = x >= 0 ? 'E' : 'W';
        char yChar = y >= 0 ? 'N' : 'S';
        return binaryStr.replace('1', xChar).replace('0', yChar);
    }

    private String calculateBinaryRepresentation(int num, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append((num & 1) == 1 ? '1' : '0');
            num >>= 1;
        }
        return result.toString();
    }

    private boolean isValid(int... values) {
        int max = IntStream.of(values).max().orElseThrow();
        int higherPower = getFirstHigherPowerOfTwo(max);
        int stop = getLogBase2(higherPower);

        for (int i = 0; i < stop; i++) {
            int count = 0;
            for (int value : values) {
                if (((value >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count != 1) {
                return false;
            }
        }
        return true;
    }

    private int getFirstHigherPowerOfTwo(int num) {
        int result = 1;
        while (result < num) {
            result <<= 1;
        }
        return result;
    }

    private int getLogBase2(int num) {
        return 31 - Integer.numberOfLeadingZeros(num);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count + 1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}