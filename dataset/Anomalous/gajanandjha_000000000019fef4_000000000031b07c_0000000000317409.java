import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            char[] directions = input[2].toCharArray();

            int[] distances = new int[directions.length + 1];
            distances[0] = Math.abs(X) + Math.abs(Y);

            for (int i = 0; i < directions.length; i++) {
                switch (directions[i]) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }
                distances[i + 1] = Math.abs(X) + Math.abs(Y);
            }

            int result = -1;
            for (int i = 0; i < distances.length; i++) {
                if (i >= distances[i]) {
                    result = i;
                    break;
                }
            }

            if (result != -1) {
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}