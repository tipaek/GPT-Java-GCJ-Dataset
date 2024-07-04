import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            String result = processCase(reader);
            System.out.format("Case #%d: %s%n", i, result);
        }
    }

    private static String processCase(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split(" ");

        long R = Long.parseLong(input[0]);
        long S = Long.parseLong(input[1]);

        long remainingRanks = R;
        long remainingTemp = R * S - R - 1;

        StringBuilder result = new StringBuilder();
        int steps = 0;

        for (int i = 0; remainingTemp >= 1; remainingTemp--) {
            long currentRank = remainingRanks - (i / (S - 1));
            long currentTemp = remainingTemp;

            if (currentRank == 1) {
                break;
            }

            result.append("\n").append(currentRank).append(" ").append(currentTemp);
            i++;
            steps++;
        }

        return steps + result.toString();
    }
}