import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder output = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            output.append("Case #").append(caseNum).append(": ");
            String[] input = reader.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            char[] moves = input[2].toCharArray();

            long steps = 0;
            boolean reached = false;

            for (char move : moves) {
                switch (move) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                steps++;
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    reached = true;
                    break;
                }
            }

            if (reached) {
                output.append(steps).append("\n");
            } else {
                output.append("IMPOSSIBLE\n");
            }
        }

        writer.print(output);
        writer.flush();
        reader.close();
    }
}