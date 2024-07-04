import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int numberOfTests = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        for (int test = 0; test < numberOfTests; test++) {
            boolean foundCenter = false;
            for (int x = -5; x < 5 && !foundCenter; x++) {
                for (int y = -5; y < 5 && !foundCenter; y++) {
                    System.out.println(x + " " + y);
                    String response = reader.readLine();
                    if (response.equals("CENTER")) {
                        foundCenter = true;
                    }
                }
            }
        }
    }

}