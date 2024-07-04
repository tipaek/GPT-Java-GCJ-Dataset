import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] initialInput = br.readLine().split(" ");
            int numberOfTestCases = Integer.parseInt(initialInput[0]);
            int bitLength = Integer.parseInt(initialInput[1]);

            for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                StringBuilder resultBuilder = new StringBuilder();
                for (int queryIndex = 1; queryIndex <= 10; queryIndex++) {
                    System.out.println(queryIndex);
                    String response = br.readLine();
                    resultBuilder.append(response);
                }
                System.out.println(resultBuilder);
                String finalResult = br.readLine();
            }
        }
    }
}