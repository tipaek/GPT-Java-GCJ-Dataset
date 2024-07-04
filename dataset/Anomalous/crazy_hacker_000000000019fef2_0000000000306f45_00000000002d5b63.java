import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean hitFound = false;

            for (int x = -50; x <= 50 && !hitFound; x++) {
                for (int y = -50; y <= 50 && !hitFound; y++) {
                    System.out.println(x + " " + y);
                    String response = reader.readLine();

                    if ("HIT".equalsIgnoreCase(response)) {
                        System.out.println(x + " " + y);
                        hitFound = true;
                    }
                }
            }
            reader.readLine();  // Consume the remaining input for the current test case
        }
    }
}