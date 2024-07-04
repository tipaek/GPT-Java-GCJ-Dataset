import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String result = solveCase(a, b);
            System.out.println(result);
        }
    }

    private static String solveCase(int a, int b) {
        String first = Integer.toBinaryString(Math.abs(a));
        String second = Integer.toBinaryString(Math.abs(b));
        boolean multA = a < 0;
        boolean multB = b < 0;

        first = padBinaryString(first, second.length());
        second = padBinaryString(second, first.length());

        StringBuilder ans = new StringBuilder();
        boolean finished = false;

        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) {
                break;
            }
            if (first.charAt(j) == '1') {
                ans.append(multA ? "W" : "E");
            }
            if (second.charAt(j) == '1') {
                ans.append(multB ? "S" : "N");
            }
            if (j == first.length() - 1) {
                finished = true;
            }
        }

        if (finished) {
            return ans.toString();
        }

        boolean twosCompA = false;
        boolean twosCompB = false;
        boolean thing = false;

        if (Math.abs(a) > Math.abs(b)) {
            twosCompB = true;
            thing = true;
            b = -Math.abs(b);
            second = toTwosComplementBinaryString(b);
        } else {
            twosCompA = true;
            thing = true;
            a = -Math.abs(a);
            first = toTwosComplementBinaryString(a);
        }

        first = padBinaryString(first, second.length());
        second = padBinaryString(second, first.length());

        ans = new StringBuilder();
        finished = false;

        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) {
                break;
            }
            if (first.charAt(j) == '1') {
                ans.insert(0, shouldPrependWest(twosCompA, multA, thing) ? "W" : "E");
                thing = false;
            }
            if (second.charAt(j) == '1') {
                ans.insert(0, shouldPrependSouth(twosCompB, multB, thing) ? "S" : "N");
                thing = false;
            }
            if (j == first.length() - 1) {
                finished = true;
            }
        }

        if (finished) {
            return ans.toString();
        }

        if (Math.abs(a) < Math.abs(b)) {
            twosCompB = true;
            thing = true;
            b = -Math.abs(b);
            second = toTwosComplementBinaryString(b);
        } else {
            twosCompA = true;
            thing = true;
            a = -Math.abs(a);
            first = toTwosComplementBinaryString(a);
        }

        first = padBinaryString(first, second.length());
        second = padBinaryString(second, first.length());

        ans = new StringBuilder();

        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) {
                return "IMPOSSIBLE";
            }
            if (first.charAt(j) == '1') {
                ans.insert(0, shouldPrependWest(twosCompA, multA, thing) ? "W" : "E");
                thing = false;
            }
            if (second.charAt(j) == '1') {
                ans.insert(0, shouldPrependSouth(twosCompB, multB, thing) ? "S" : "N");
                thing = false;
            }
        }

        return ans.toString();
    }

    private static String padBinaryString(String binary, int length) {
        while (binary.length() < length) {
            binary = "0" + binary;
        }
        return binary;
    }

    private static String toTwosComplementBinaryString(int num) {
        if (num == -1) return "1";
        if (num == 0) return "0";
        String binary = Integer.toBinaryString(num);
        return binary.substring(binary.indexOf('0') - 1);
    }

    private static boolean shouldPrependWest(boolean twosCompA, boolean multA, boolean thing) {
        return (twosCompA && multA && thing) || (!twosCompA && multA) || (twosCompA && !multA && !thing);
    }

    private static boolean shouldPrependSouth(boolean twosCompB, boolean multB, boolean thing) {
        return (twosCompB && multB && thing) || (!twosCompB && multB) || (twosCompB && !multB && !thing);
    }
}