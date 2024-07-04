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

            String result = calculatePath(a, b);
            System.out.println(result);
        }
    }

    private static String calculatePath(int a, int b) {
        String first = Integer.toBinaryString(Math.abs(a));
        String second = Integer.toBinaryString(Math.abs(b));
        boolean multA = a < 0;
        boolean multB = b < 0;

        first = padWithZeros(first, second.length());
        second = padWithZeros(second, first.length());

        StringBuilder ans = new StringBuilder();
        boolean finished = false;

        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) break;

            if (first.charAt(j) == '1') {
                ans.append(multA ? "W" : "E");
            }
            if (second.charAt(j) == '1') {
                ans.append(multB ? "S" : "N");
            }
            if (j == first.length() - 1) finished = true;
        }

        if (finished) return ans.toString();

        boolean thing = false;
        boolean twosCompA = false;
        boolean twosCompB = false;

        if (Math.abs(a) > Math.abs(b)) {
            twosCompB = true;
            thing = true;
            b = -Math.abs(b);
            second = Integer.toBinaryString(b).substring(Integer.toBinaryString(b).indexOf('0') - 1);
            first = Integer.toBinaryString(Math.abs(a));
        } else {
            twosCompA = true;
            thing = true;
            a = -Math.abs(a);
            first = Integer.toBinaryString(a).substring(Integer.toBinaryString(a).indexOf('0') - 1);
            second = Integer.toBinaryString(Math.abs(b));
        }

        first = padWithZeros(first, second.length());
        second = padWithZeros(second, first.length());

        ans.setLength(0);
        finished = false;

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
            if (j == first.length() - 1) finished = true;
        }

        if (finished) return ans.toString();

        thing = false;
        twosCompA = false;
        twosCompB = false;

        if (Math.abs(a) < Math.abs(b)) {
            twosCompB = true;
            thing = true;
            b = -Math.abs(b);
            second = Integer.toBinaryString(b).substring(Integer.toBinaryString(b).indexOf('0') - 1);
            first = Integer.toBinaryString(Math.abs(a));
        } else {
            twosCompA = true;
            thing = true;
            a = -Math.abs(a);
            first = Integer.toBinaryString(a).substring(Integer.toBinaryString(a).indexOf('0') - 1);
            second = Integer.toBinaryString(Math.abs(b));
        }

        first = padWithZeros(first, second.length());
        second = padWithZeros(second, first.length());

        ans.setLength(0);

        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) == second.charAt(j)) return "IMPOSSIBLE";

            if (first.charAt(j) == '1') {
                ans.insert(0, (twosCompA && multA && thing || !twosCompA && multA || twosCompA && !multA && !thing) ? "W" : "E");
                if (thing) thing = false;
            }
            if (second.charAt(j) == '1') {
                ans.insert(0, (twosCompB && multB && thing || !twosCompB && multB || twosCompB && !multB && !thing) ? "S" : "N");
                if (thing) thing = false;
            }
        }

        return ans.toString();
    }

    private static String padWithZeros(String str, int length) {
        while (str.length() < length) {
            str = "0" + str;
        }
        return str;
    }
}