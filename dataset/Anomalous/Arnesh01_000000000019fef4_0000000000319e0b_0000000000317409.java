import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = reader.readLine().split(" ");
            int x = (int) Long.parseLong(input[0]);
            int y = (int) Long.parseLong(input[1]);
            String path = input[2];

            int step;
            for (step = 1; step <= path.length(); step++) {
                char direction = path.charAt(step - 1);
                switch (direction) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                if (step >= Math.abs(x) + Math.abs(y)) {
                    break;
                }
            }

            String result = (step <= path.length()) ? String.valueOf(step) : "IMPOSSIBLE";
            output.append("Case #").append(caseNumber).append(": ").append(result).append("\n");
        }

        System.out.print(output);
    }
}