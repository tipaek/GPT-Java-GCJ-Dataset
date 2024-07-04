import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();

        int a = Math.abs(x);
        int b = Math.abs(y);

        int ha = getNextPowerOfTwo(a);
        int hb = getNextPowerOfTwo(b);

        int sa = ha - a;
        int sb = hb - b;

        int len = Math.max(getLogBase2(ha), getLogBase2(hb));

        List<String> results = new ArrayList<>();

        if (isValidMove(a + b)) {
            String result = calculatePath(a, len);
            System.out.println(convertPath(result, x, y));
            return;
        }

        if (isValidMove(hb + sb + a)) {
            String result = calculatePath(a, len);
            result = convertPath(result, x, -y);
            result = adjustPath(result, b, a, y, 'N', 'S');
            results.add(result);
        }

        if (isValidMove(ha + sa + b)) {
            String result = calculatePath(sa, len);
            result = convertPath(result, -x, y);
            result = adjustPath(result, a, b, x, 'E', 'W');
            results.add(result);
        }

        if (isValidMove(ha + sa + hb + sb)) {
            String result = calculatePath(sa, len);
            result = appendDirection(result, ha, hb, x, y);
            results.add(result);
        }

        if (results.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            String shortestResult = results.stream().min(Comparator.comparingInt(String::length)).orElse("");
            System.out.println(shortestResult);
        }
    }

    private String adjustPath(String result, int primary, int secondary, int coordinate, char positive, char negative) {
        if (primary > secondary) {
            result += (coordinate > 0) ? positive : negative;
        } else {
            result = replaceLastCharacter(result, (coordinate > 0) ? negative : positive, (coordinate > 0) ? positive : negative);
        }
        return result;
    }

    private String appendDirection(String result, int ha, int hb, int x, int y) {
        if (ha > hb) {
            result += (x > 0) ? 'E' : 'W';
        } else {
            result += (y > 0) ? 'N' : 'S';
        }
        return result;
    }

    private String replaceLastCharacter(String str, char target, char replacement) {
        int index = str.lastIndexOf(target);
        if (index >= 0) {
            return str.substring(0, index) + replacement + str.substring(index + 1);
        }
        throw new RuntimeException("replaceLastCharacter failed");
    }

    private String convertPath(String path, int x, int y) {
        char xChar = x >= 0 ? 'E' : 'W';
        char yChar = y >= 0 ? 'N' : 'S';
        return path.replace('1', xChar).replace('0', yChar);
    }

    private String calculatePath(int value, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append((value & 1) == 1 ? "1" : "0");
            value >>= 1;
        }
        return result.toString();
    }

    private boolean isValidMove(int... values) {
        int max = Arrays.stream(values).max().orElse(0);
        int highestPower = getNextPowerOfTwo(max);
        int stop = getLogBase2(highestPower);
        for (int i = 0; i < stop; i++) {
            long count = Arrays.stream(values).filter(v -> ((v >> i) & 1) == 1).count();
            if (count != 1) {
                return false;
            }
        }
        return true;
    }

    private int getNextPowerOfTwo(int x) {
        int result = 1;
        while (result <= x) {
            result <<= 1;
        }
        return result;
    }

    private int getLogBase2(int x) {
        return (int) (Math.log(x) / Math.log(2));
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