import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder output = new StringBuilder();
            int testCases = parseStringToInt(reader.readLine());

            for (int i = 1; i <= testCases; i++) {
                int target = parseStringToInt(reader.readLine());
                output.append(String.format("Case #%d:\n", i));

                int sum = 1;
                int[] pathRow = new int[500];
                int[] pathCol = new int[500];
                pathRow[0] = 1;
                pathCol[0] = 1;

                int j;
                for (j = 1; j < 500 && sum + j <= target; j++) {
                    sum += j;
                    pathRow[j] = j + 1;
                    pathCol[j] = 2;
                }

                while (j < 500 && sum < target) {
                    pathRow[j] = j;
                    pathCol[j] = 1;
                    sum++;
                    j++;
                }

                if (sum == target) {
                    for (int k = 0; k < j; k++) {
                        output.append(String.format("%d %d\n", pathRow[k], pathCol[k]));
                    }
                } else {
                    output.append("1 1\n");
                }
            }

            writer.write(output.toString());
        }
    }
}