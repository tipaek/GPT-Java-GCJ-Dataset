import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int testCases = parseInt(bufferedReader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int targetSum = parseInt(bufferedReader.readLine());

            stringBuilder.append(String.format("Case #%d: \n", t));

            int currentSum = 1;
            int[] rowPath = new int[500];
            int[] colPath = new int[500];
            rowPath[0] = 1;
            colPath[0] = 1;
            int steps;

            for (steps = 1; steps < 500 && currentSum + steps < targetSum; steps++) {
                currentSum += steps;
                rowPath[steps] = steps + 1;
                colPath[steps] = 2;
            }

            while (steps < 500 && currentSum < targetSum) {
                rowPath[steps] = steps;
                colPath[steps] = 1;
                currentSum++;
                steps++;
            }

            if (currentSum == targetSum) {
                for (int k = 0; k < steps; k++) {
                    stringBuilder.append(String.format("%d %d\n", rowPath[k], colPath[k]));
                }
            } else {
                stringBuilder.append("1 1\n");
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}