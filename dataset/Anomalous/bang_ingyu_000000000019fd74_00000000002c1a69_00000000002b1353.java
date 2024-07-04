import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultBuilder = new StringBuilder();

        int testCases = parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int N = parseInt(reader.readLine());
            resultBuilder.append(String.format("Case #%d:\n", t));

            int currentSum = 1;
            int[] rowPath = new int[500];
            int[] colPath = new int[500];
            rowPath[0] = 1;
            colPath[0] = 1;
            int index = 1;

            for (index = 1; index < 500 && currentSum + index < N; index++) {
                currentSum += index;
                rowPath[index] = index + 1;
                colPath[index] = 2;
            }

            while (index < 500 && currentSum < N) {
                rowPath[index] = index + 1;
                colPath[index] = 1;
                currentSum++;
                index++;
            }

            if (currentSum == N) {
                for (int k = 0; k < index; k++) {
                    resultBuilder.append(String.format("%d %d\n", rowPath[k], colPath[k]));
                }
            } else {
                resultBuilder.append("1 1\n");
            }
        }

        writer.write(resultBuilder.toString());
        writer.flush();
        writer.close();
    }
}