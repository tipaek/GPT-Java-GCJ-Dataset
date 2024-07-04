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
        boolean isNegativeA = a < 0;
        boolean isNegativeB = b < 0;
        String binA = Integer.toBinaryString(Math.abs(a));
        String binB = Integer.toBinaryString(Math.abs(b));

        binA = padBinaryString(binA, binB.length());
        binB = padBinaryString(binB, binA.length());

        String result = calculateDirections(binA, binB, isNegativeA, isNegativeB);
        if (result != null) {
            return result;
        }

        boolean twosCompA = false;
        boolean twosCompB = false;
        boolean isSwapped = false;

        if (Math.abs(a) > Math.abs(b)) {
            twosCompB = true;
            binB = getTwosComplementBinary(Math.abs(b));
            binA = Integer.toBinaryString(Math.abs(a));
        } else {
            twosCompA = true;
            binA = getTwosComplementBinary(Math.abs(a));
            binB = Integer.toBinaryString(Math.abs(b));
        }

        binA = padBinaryString(binA, binB.length());
        binB = padBinaryString(binB, binA.length());

        result = calculateDirections(binA, binB, isNegativeA, isNegativeB, twosCompA, twosCompB, isSwapped);
        if (result != null) {
            return result;
        }

        if (Math.abs(a) < Math.abs(b)) {
            twosCompB = true;
            binB = getTwosComplementBinary(Math.abs(b));
            binA = Integer.toBinaryString(Math.abs(a));
        } else {
            twosCompA = true;
            binA = getTwosComplementBinary(Math.abs(a));
            binB = Integer.toBinaryString(Math.abs(b));
        }

        binA = padBinaryString(binA, binB.length());
        binB = padBinaryString(binB, binA.length());

        result = calculateDirections(binA, binB, isNegativeA, isNegativeB, twosCompA, twosCompB, isSwapped);
        if (result != null) {
            return result;
        }

        return "IMPOSSIBLE";
    }

    private static String padBinaryString(String bin, int length) {
        while (bin.length() < length) {
            bin = "0" + bin;
        }
        return bin;
    }

    private static String getTwosComplementBinary(int value) {
        if (value == 0) {
            return "0";
        }
        String bin = Integer.toBinaryString(value * -1);
        return bin.substring(bin.indexOf('0') - 1);
    }

    private static String calculateDirections(String binA, String binB, boolean isNegativeA, boolean isNegativeB) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < binA.length(); j++) {
            if (binA.charAt(j) == binB.charAt(j)) {
                return null;
            }
            if (binA.charAt(j) == '1') {
                result.append(isNegativeA ? "W" : "E");
            }
            if (binB.charAt(j) == '1') {
                result.append(isNegativeB ? "S" : "N");
            }
        }
        return result.toString();
    }

    private static String calculateDirections(String binA, String binB, boolean isNegativeA, boolean isNegativeB,
                                              boolean twosCompA, boolean twosCompB, boolean isSwapped) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < binA.length(); j++) {
            if (binA.charAt(j) == binB.charAt(j)) {
                return null;
            }
            if (binA.charAt(j) == '1') {
                if ((twosCompA && isNegativeA && isSwapped) || (!twosCompA && isNegativeA) || (twosCompA && !isNegativeA && !isSwapped)) {
                    result.insert(0, "W");
                } else {
                    result.insert(0, "E");
                }
                if (isSwapped) {
                    isSwapped = false;
                }
            }
            if (binB.charAt(j) == '1') {
                if ((twosCompB && isNegativeB && isSwapped) || (!twosCompB && isNegativeB) || (twosCompB && !isNegativeB && !isSwapped)) {
                    result.insert(0, "S");
                } else {
                    result.insert(0, "N");
                }
                if (isSwapped) {
                    isSwapped = false;
                }
            }
        }
        return result.toString();
    }
}