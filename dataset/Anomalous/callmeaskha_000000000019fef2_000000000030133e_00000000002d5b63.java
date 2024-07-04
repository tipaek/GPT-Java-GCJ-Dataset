import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int numberOfTestCases = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);
        boolean continueTesting = true;

        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
            testLoop:
            for (int x = -5; x <= 5; x++) {
                for (int y = -5; y <= 5; y++) {
                    System.out.println(x + " " + y);
                    String response = reader.readLine();
                    if (response.equals("CENTER")) {
                        break testLoop;
                    }
                    if (response.equals("MISS")) {
                        continueTesting = false;
                        break testLoop;
                    }
                }
            }
            if (!continueTesting) {
                break;
            }
        }
    }
}