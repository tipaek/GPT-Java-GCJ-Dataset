import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");

            String[] inputs = reader.readLine().split("\\s+");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            char xDirection = x < 0 ? 'W' : 'E';
            char yDirection = y < 0 ? 'S' : 'N';

            x = Math.abs(x);
            y = Math.abs(y);

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            long ySum = 0;
            int shift = 0;

            if (x != 0) {
                char[] xBinary = Integer.toBinaryString(x).toCharArray();
                char oppositeYDirection = yDirection == 'N' ? 'S' : 'N';

                for (int i = xBinary.length - 1; i >= 0; i--) {
                    if (xBinary[i] == '0') {
                        result.append(oppositeYDirection);
                        ySum -= 1L << shift;
                    } else {
                        result.append(xDirection);
                    }
                    shift++;
                }
            }

            while (ySum < y) {
                result.append(yDirection);
                ySum += 1L << shift++;
            }

            if (ySum == y) {
                output.append(result);
            } else {
                output.append("IMPOSSIBLE");
            }

            output.append('\n');
        }

        writer.print(output);
        reader.close();
        writer.close();
    }
}