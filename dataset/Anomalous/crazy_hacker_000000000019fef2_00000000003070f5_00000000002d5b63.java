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

        for (int t = 0; t < testCases; t++) {
            boolean hitFound = false;

            for (int x = -50; x <= 50 && !hitFound; x++) {
                for (int y = -50; y <= 50 && !hitFound; y++) {
                    System.out.println((1000000000 - x) + " " + (1000000000 - y));
                    String response = reader.readLine();

                    if (response.equalsIgnoreCase("HIT")) {
                        System.out.println(x + " " + y);
                        hitFound = true;
                    }
                }
            }

            reader.readLine(); // To consume the remaining input
        }
    }
}