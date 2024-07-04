import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder output = new StringBuilder();
            int testCases = parseInt(reader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int targetNumber = parseInt(reader.readLine());
                output.append(String.format("Case #%d:%n", t));

                int currentSum = 1;
                int[] rowPath = new int[500];
                int[] colPath = new int[500];
                rowPath[0] = 1;
                colPath[0] = 1;
                int step = 1;

                for (; step < 500 && currentSum + step < targetNumber; step++) {
                    currentSum += step;
                    rowPath[step] = step + 1;
                    colPath[step] = (step == 1) ? 1 : 2;
                }

                while (step < 500 && currentSum < targetNumber) {
                    rowPath[step] = step + 1;
                    colPath[step] = 1;
                    currentSum++;
                    step++;
                }

                if (currentSum == targetNumber) {
                    for (int i = 0; i < step; i++) {
                        output.append(String.format("%d %d%n", rowPath[i], colPath[i]));
                    }
                } else {
                    output.append("1 1%n");
                }
            }

            writer.write(output.toString());
        }
    }
}