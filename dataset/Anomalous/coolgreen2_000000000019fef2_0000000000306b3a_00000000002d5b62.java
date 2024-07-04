import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String result = solve(a, b);
            System.out.println(result);
        }
    }

    private static String solve(int a, int b) {
        boolean multA = a < 0;
        boolean multB = b < 0;
        String first = Integer.toBinaryString(Math.abs(a));
        String second = Integer.toBinaryString(Math.abs(b));

        first = padWithZeros(first, second.length());
        second = padWithZeros(second, first.length());

        String ans = findPath(first, second, multA, multB);
        if (ans != null) return ans;

        boolean thing = false;
        boolean twosCompA = false;
        boolean twosCompB = false;

        if (Math.abs(a) > Math.abs(b)) {
            twosCompB = true;
            thing = true;
            second = toTwosComplement(Math.abs(b));
            first = Integer.toBinaryString(Math.abs(a));
        } else {
            twosCompA = true;
            thing = true;
            first = toTwosComplement(Math.abs(a));
            second = Integer.toBinaryString(Math.abs(b));
        }

        first = padWithZeros(first, second.length());
        second = padWithZeros(second, first.length());

        ans = findPath(first, second, multA, multB, twosCompA, twosCompB, thing);
        if (ans != null) return ans;

        if (Math.abs(a) < Math.abs(b)) {
            twosCompB = true;
            thing = true;
            second = toTwosComplement(Math.abs(b));
            first = Integer.toBinaryString(Math.abs(a));
        } else {
            twosCompA = true;
            thing = true;
            first = toTwosComplement(Math.abs(a));
            second = Integer.toBinaryString(Math.abs(b));
        }

        first = padWithZeros(first, second.length());
        second = padWithZeros(second, first.length());

        ans = findPath(first, second, multA, multB, twosCompA, twosCompB, thing);
        if (ans != null) return ans;

        ans = findPath(toTwosComplement(Math.abs(a)), toTwosComplement(Math.abs(b)), multA, multB, true, true, true);
        return (a == 0 && b == 0) ? "" : (ans != null ? ans : "IMPOSSIBLE");
    }

    private static String padWithZeros(String str, int length) {
        while (str.length() < length) str = "0" + str;
        return str;
    }

    private static String toTwosComplement(int value) {
        int temp = value * -1;
        if (temp == -1) return "1";
        if (temp == 0) return "0";
        String binary = Integer.toBinaryString(temp);
        return binary.substring(binary.indexOf('0') - 1);
    }

    private static String findPath(String first, String second, boolean multA, boolean multB) {
        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) break;
            if (first.charAt(j) == '1') {
                ans.append(multA ? "W" : "E");
            }
            if (second.charAt(j) == '1') {
                ans.append(multB ? "S" : "N");
            }
            if (j == first.length() - 1) return ans.toString();
        }
        return null;
    }

    private static String findPath(String first, String second, boolean multA, boolean multB, boolean twosCompA, boolean twosCompB, boolean thing) {
        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) break;
            if (first.charAt(j) == '1') {
                ans.insert(0, (twosCompA && multA && thing || !twosCompA && multA || twosCompA && !multA && !thing) ? "W" : "E");
                if (thing) thing = false;
            }
            if (second.charAt(j) == '1') {
                ans.insert(0, (twosCompB && multB && thing || !twosCompB && multB || twosCompB && !multB && !thing) ? "S" : "N");
                if (thing) thing = false;
            }
            if (j == first.length() - 1) return ans.toString();
        }
        return null;
    }
}