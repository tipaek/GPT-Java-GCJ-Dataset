import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();

        int absX = Math.abs(x);
        int absY = Math.abs(y);

        int higherX = firstHigher(absX);
        int higherY = firstHigher(absY);

        int shiftX = higherX - absX;
        int shiftY = higherY - absY;

        int maxLength = Math.max(log(higherX), log(higherY));

        List<String> results = new ArrayList<>();

        if (isValid(absX + absY)) {
            String result = calculate(absX, maxLength);
            System.out.println(convert(result, x, y));
            return;
        }

        if (isValid(higherY + shiftY + absX)) {
            String result = calculate(absX, maxLength);
            result = convert(result, x, -y);
            if (absY > absX) {
                result += (y > 0) ? 'N' : 'S';
            } else {
                result = replace(result, log(higherY), (y > 0) ? 'N' : 'S');
            }
            results.add(result);
        }

        if (isValid(higherX + shiftX + absY)) {
            String result = calculate(shiftX, maxLength);
            result = convert(result, -x, y);
            if (absX > absY) {
                result += (x > 0) ? 'E' : 'W';
            } else {
                result = replace(result, log(higherX), (x > 0) ? 'E' : 'W');
            }
            results.add(result);
        }

        if (isValid(higherX + shiftX + higherY + shiftY)) {
            String result = calculate(shiftX, maxLength);
            result += (higherX > higherY) ? ((x > 0) ? 'E' : 'W') : ((y > 0) ? 'N' : 'S');
            results.add(result);
        }

        if (results.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            String minResult = results.stream().min(Comparator.comparingInt(String::length)).orElse("");
            System.out.println(minResult);
        }
    }

    private String replace(String result, int index, char replacement) {
        return result.substring(0, index) + replacement + result.substring(index + 1);
    }

    private String convert(String orig, int x, int y) {
        char xc = x >= 0 ? 'E' : 'W';
        char yc = y >= 0 ? 'N' : 'S';
        return orig.replace('1', xc).replace('0', yc);
    }

    private String calculate(int x, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append((x & 1) == 1 ? '1' : '0');
            x >>= 1;
        }
        return result.toString();
    }

    private boolean isValid(int... values) {
        int max = Arrays.stream(values).max().orElse(0);
        int higher = firstHigher(max);
        int stop = log(higher);

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

    private int log(int x) {
        int result = 0;
        while ((1 << result) < x) {
            result++;
        }
        if ((1 << result) != x) {
            throw new RuntimeException("log " + x + " failed");
        }
        return result;
    }

    private int firstHigher(int x) {
        int result = 1;
        while (result <= x) {
            result <<= 1;
        }
        return result;
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