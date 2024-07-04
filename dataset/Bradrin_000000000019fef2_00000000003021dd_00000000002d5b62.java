import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        int len = Math.max(log(ha), log(hb));

        List<String> results = new ArrayList<>();

        if (isValid(a + b)) {
            String result = calc(a, len);
            System.out.println(convert(result, x, y));
            return;
        }

        if (b != 0 && isValid(hb + sb + a)) {
//            System.out.println(hb + " " + sb + " " + a);
            String result = calc(a, len);
            result = convert(result, x, -y);
            if (b > a) {
                if (y > 0) {
                    result += 'N';
                } else {
                    result += 'S';
                }
            } else {
                if (y > 0) {
                    result = replace(result, log(hb), 'N');
                } else {
                    result = replace(result, log(hb), 'S');
                }
            }
            results.add(result);
        }

        if (a != 0 && isValid(ha + sa + b)) {
//            System.out.println(ha + " " + sa + " " + b);
            String result = calc(sa, len);
            result = convert(result, -x, y);
            if (a > b) {
                if (x > 0) {
                    result += 'E';
                } else {
                    result += 'W';
                }
            } else {
                if (x > 0) {
                    result = replace(result, log(ha), 'E');
                } else {
                    result = replace(result, log(ha), 'W');
                }
            }
            results.add(result);
        }

        if (a != 0 && b != 0 && isValid(ha + sa + hb + sb)) {
//            System.out.println(ha + " " + sa + " " + hb + " " + sb);
            String result = calc(sa, len);
            result = convert(result, -x, -y);
            if (ha > hb) {
                if (x > 0) {
                    result += 'E';
                } else {
                    result += 'W';
                }
                if (y > 0) {
                    result = replace(result, log(hb), 'N');
                } else {
                    result = replace(result, log(hb), 'S');
                }
            } else {
                if (y > 0) {
                    result += 'N';
                } else {
                    result += 'S';
                }
                if (x > 0) {
                    result = replace(result, log(ha), 'E');
                } else {
                    result = replace(result, log(ha), 'W');
                }
            }
            results.add(result);
        }

        if (results.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            int minLength = 100;
            String min = "";
            for (String s : results) {
                if (s.length() < minLength) {
                    min = s;
                    minLength = s.length();
                }
            }
            System.out.println(min);
            verify(min, x, y);
        }
    }

    private void verify(String min, int x, int y) {
        int diff = 1;
        int a = 0;
        int b = 0;
        for (char c : min.toCharArray()) {
            if (c == 'N') {
                b += diff;
            } else if (c == 'S') {
                b -= diff;
            } else if (c == 'W') {
                a -= diff;
            } else {
                a += diff;
            }
            diff *= 2;
        }
        if (a != x || b != y) {
            throw new RuntimeException(x + " " + y + " " + a + " " + b);
        }
    }

    private String replace(String result, int index, char c) {
        return result.substring(0, index) + c + result.substring(index + 1);
    }

    String convert(String orig, int x, int y) {
        char xc = x >= 0 ? 'E' : 'W';
        char yc = y >= 0 ? 'N' : 'S';
        return orig.replace('1', xc).replace('0', yc);
    }

    String calc(int x, int len) {
        String result = "";
        for (int i = 0; i < len; i++) {
            if ((x & 1) == 1) {
                result += "1";
            } else {
                result += "0";
            }
            x = x >> 1;
        }
        return result;
    }

    boolean isValid(int... values) {
        int max = 0;
        for (int v : values) {
            max = Math.max(max, v);
        }

        int higher = firstHigher(max);
        int stop = log(higher);
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

    int pow(int x) {
        int result = 1;
        for (int i = 0; i < x; i++) {
            result *= 2;
        }
        return result;
    }

    int log(int x) {
        for (int i = 0; i < 31; i++) {
            if (pow(i) == x) {
                return i;
            }
        }
        throw new RuntimeException("log " + x + " failed");
    }

    int firstHigher(int x) {
        int result = 1;
        while (result <= x) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
//            for (int i = -100; i <= 100; i++) {
//                for (int j = -100; j <= 100; j++) {
//                    if (i == 0 && j == 0) {
//                        continue;
//                    }
//                    new A().solve(scan, i, j);
//                }
//            }
            new Solution().solve(scan);
        }
        scan.close();
    }
}
