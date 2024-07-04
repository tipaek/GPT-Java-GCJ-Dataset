import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            String[] input = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int sumOfAbs = Math.abs(x) + Math.abs(y);

            if (sumOfAbs % 2 == 1) {
                int highestBit = Integer.highestOneBit(sumOfAbs - 1);
                while (x != 0 || y != 0) {
                    if (Math.abs(x) > Math.abs(y)) {
                        if (x > 0) {
                            result.append("E");
                            x -= highestBit;
                        } else {
                            result.append("W");
                            x += highestBit;
                        }
                    } else {
                        if (y > 0) {
                            result.append("N");
                            y -= highestBit;
                        } else {
                            result.append("S");
                            y += highestBit;
                        }
                    }
                    highestBit /= 2;
                }
                System.out.println("Case #" + t + ": " + result.reverse().toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}