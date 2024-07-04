import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();

        int a = Math.abs(x);
        int b = Math.abs(y);

        int ha = firstHigher(a);
        int hb = firstHigher(b);

        int sa = ha - a;
        int sb = hb - b;

        int len = Math.max(log2(ha), log2(hb));

        List<String> results = new ArrayList<>();

        if (isValid(a + b)) {
            String result = calculateSteps(a, len);
            System.out.println(convert(result, x, y));
            return;
        }

        if (isValid(hb + sb + a)) {
            String result = calculateSteps(a, len);
            result = convert(result, x, -y);
            result = appendDirection(result, b, a, y > 0 ? 'N' : 'S', y > 0 ? 'S' : 'N');
            results.add(result);
        }

        if (isValid(ha + sa + b)) {
            String result = calculateSteps(sa, len);
            result = convert(result, -x, y);
            result = appendDirection(result, a, b, x > 0 ? 'E' : 'W', x > 0 ? 'W' : 'E');
            results.add(result);
        }

        if (isValid(ha + sa + hb + sb)) {
            String result = calculateSteps(sa, len);
            result += ha > hb ? (x > 0 ? 'E' : 'W') : (y > 0 ? 'N' : 'S');
            results.add(result);
        }

        if (results.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            String minResult = results.stream().min(Comparator.comparingInt(String::length)).orElse("");
            System.out.println(minResult);
        }
    }

    private String appendDirection(String result, int major, int minor, char majorDir, char minorDir) {
        if (major > minor) {
            result += majorDir;
        } else {
            result = replaceLast(result, minorDir == 'N' ? 'S' : 'N', majorDir);
        }
        return result;
    }

    private String replaceLast(String s, char orig, char replace) {
        int pos = s.lastIndexOf(orig);
        if (pos != -1) {
            return s.substring(0, pos) + replace + s.substring(pos + 1);
        }
        throw new RuntimeException("replace last failed");
    }

    private String convert(String orig, int x, int y) {
        char xc = x >= 0 ? 'E' : 'W';
        char yc = y >= 0 ? 'N' : 'S';
        return orig.replace('1', xc).replace('0', yc);
    }

    private String calculateSteps(int x, int len) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append((x & 1) == 1 ? "1" : "0");
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
        return (int) (Math.log(x) / Math.log(2));
    }

    private int firstHigher(int x) {
        int result = 1;
        while (result < x) {
            result *= 2;
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