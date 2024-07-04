import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int numberOfTestCases = Integer.parseInt(input[0]);
            int bitCount = Integer.parseInt(input[1]);

            for (int test = 0; test < numberOfTestCases; test++) {
                StringBuilder result = new StringBuilder();
                for (int index = 1; index <= 10; index++) {
                    System.out.println(index);
                    String response = reader.readLine();
                    result.append(response);
                }
                System.out.println(result.toString());
            }
        }
    }
}