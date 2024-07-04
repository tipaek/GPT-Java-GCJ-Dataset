import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int numberOfTestCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int caseIndex = 0; caseIndex < numberOfTestCases; caseIndex++) {
            StringBuilder resultBuilder = new StringBuilder();
            for (int queryIndex = 0; queryIndex < 10; queryIndex++) {
                System.out.println(queryIndex + 1);
                String response = reader.readLine();
                resultBuilder.append(response);
            }
            System.out.println(resultBuilder.toString());
            String finalResult = reader.readLine();
            System.exit(0);
        }
    }
}