import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();

        int absX = Math.abs(x);
        int absY = Math.abs(y);

        int firstHigherX = firstHigher(absX);
        int firstHigherY = firstHigher(absY);

        int diffX = firstHigherX - absX;
        int diffY = firstHigherY - absY;

        int maxLen = Math.max(log2(firstHigherX), log2(firstHigherY));

        List<String> results = new ArrayList<>();

        if (isValid(absX + absY)) {
            String result = calculate(absX, maxLen);
            System.out.println(convert(result, x, y));
            return;
        }

        if (absY != 0 && isValid(firstHigherY + diffY + absX)) {
            String result = calculate(absX, maxLen);
            result = convert(result, x, -y);
            if (absY > absX) {
                result += (y > 0) ? 'N' : 'S';
            } else {
                result = replace(result, log2(firstHigherY), (y > 0) ? 'N' : 'S');
            }
            results.add(result);
        }

        if (absX != 0 && isValid(firstHigherX + diffX + absY)) {
            String result = calculate(diffX, maxLen);
            result = convert(result, -x, y);
            if (absX > absY) {
                result += (x > 0) ? 'E' : 'W';
            } else {
                result = replace(result, log2(firstHigherX), (x > 0) ? 'E' : 'W');
            }
            results.add(result);
        }

        if (absX != 0 && absY != 0 && isValid(firstHigherX + diffX + firstHigherY + diffY)) {
            String result = calculate(diffX, maxLen);
            result = convert(result, -x, -y);
            if (firstHigherX > firstHigherY) {
                result += (x > 0) ? 'E' : 'W';
                result = replace(result, log2(firstHigherY), (y > 0) ? 'N' : 'S');
            } else {
                result += (y > 0) ? 'N' : 'S';
                result = replace(result, log2(firstHigherX), (x > 0) ? 'E' : 'W');
            }
            results.add(result);
        }

        if (results.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            String minResult = results.stream().min(Comparator.comparingInt(String::length)).orElse("");
            System.out.println(minResult);
            verify(minResult, x, y);
        }
    }

    private void verify(String result, int x, int y) {
        int step = 1;
        int posX = 0;
        int posY = 0;
        for (char c : result.toCharArray()) {
            switch (c) {
                case 'N': posY += step; break;
                case 'S': posY -= step; break;
                case 'E': posX += step; break;
                case 'W': posX -= step; break;
            }
            step *= 2;
        }
        if (posX != x || posY != y) {
            throw new RuntimeException("Verification failed: " + x + " " + y + " " + posX + " " + posY);
        }
    }

    private String replace(String result, int index, char c) {
        return result.substring(0, index) + c + result.substring(index + 1);
    }

    private String convert(String orig, int x, int y) {
        char xChar = x >= 0 ? 'E' : 'W';
        char yChar = y >= 0 ? 'N' : 'S';
        return orig.replace('1', xChar).replace('0', yChar);
    }

    private String calculate(int x, int len) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append((x & 1) == 1 ? '1' : '0');
            x >>= 1;
        }
        return result.toString();
    }

    private boolean isValid(int... values) {
        int max = Arrays.stream(values).max().orElse(0);
        int higher = firstHigher(max);
        int stop = log2(higher);

        for (int i = 0; i < stop; i++) {
            int count = 0;
            for (int v : values) {
                if (((v >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count != 1) {
                return false;
            }
        }
        return true;
    }

    private int log2(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    private int firstHigher(int x) {
        return Integer.highestOneBit(x) << 1;
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