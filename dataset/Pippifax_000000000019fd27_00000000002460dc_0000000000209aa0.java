import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<int[]> testcases = new ArrayList<>();

    public static void main(String[] args) {
        readTestCases();

        int testcaseId = 1;

        for (int[] testcase : testcases) {
            cumputeTestcase(testcase[0], testcase[1], testcaseId);
            testcaseId++;
        }
    }

    private static void cumputeTestcase(int size, int trace, int testcaseId) {
        if (trace % size != 0 || trace > size * size) {
            impossible(testcaseId);
        } else {
            possible(testcaseId);

            int seed = (trace / size) - 1;

            StringBuilder stringBuilder = new StringBuilder();

            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    int number = (seed + column + row * (size - 1)) % size + 1;
                    stringBuilder.append(number);
                    stringBuilder.append(' ');
                }
                if (row < size - 1) {
                    stringBuilder.append('\n');
                }
            }

            System.out.println(stringBuilder.toString());
        }
    }

    private static void possible(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": " + "POSSIBLE");
    }

    private static void impossible(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": " + "IMPOSSIBLE");
    }

    public static void readTestCases() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int testCaseId = 1; testCaseId <= numberOfTestCases; testCaseId++) {
                line = in.readLine();

                int[] testCase = new int[2];

                String[] fractals = line.split(" ");

                testCase[0] = Integer.parseInt(fractals[0]);
                testCase[1] = Integer.parseInt(fractals[1]);

                testcases.add(testCase);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
