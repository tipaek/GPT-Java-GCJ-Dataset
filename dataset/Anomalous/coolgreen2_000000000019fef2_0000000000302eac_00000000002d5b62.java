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

            boolean aNegative = a < 0;
            boolean bNegative = b < 0;

            String binaryA = Integer.toBinaryString(Math.abs(a));
            String binaryB = Integer.toBinaryString(Math.abs(b));

            binaryA = padBinaryString(binaryA, binaryB.length());
            binaryB = padBinaryString(binaryB, binaryA.length());

            String result = findPath(binaryA, binaryB, aNegative, bNegative);

            if (result.equals("IMPOSSIBLE")) {
                result = findPath(binaryB, binaryA, bNegative, aNegative);
            }

            System.out.println(result);
        }
    }

    private static String padBinaryString(String binary, int length) {
        while (binary.length() < length) {
            binary = "0" + binary;
        }
        return binary;
    }

    private static String findPath(String binaryA, String binaryB, boolean aNegative, boolean bNegative) {
        StringBuilder path = new StringBuilder();
        boolean finished = false;

        for (int j = 0; j < binaryA.length(); j++) {
            if (binaryA.charAt(j) == binaryB.charAt(j)) {
                return "IMPOSSIBLE";
            }
            if (binaryA.charAt(j) == '1') {
                path.append(aNegative ? "W" : "E");
            }
            if (binaryB.charAt(j) == '1') {
                path.append(bNegative ? "S" : "N");
            }
            if (j == binaryA.length() - 1) {
                finished = true;
            }
        }

        return finished ? path.toString() : "IMPOSSIBLE";
    }
}