import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int foo = -5;
        int bar = 5;
        System.out.println(foo + " " + bar);

        String[] input = reader.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        for (int t = 0; t < testCases; t++) {
            int leftBound = -1000000000;
            int upperBound = 1000000000;
            int rightBound = 1000000000;
            int lowerBound = -1000000000;

            boolean foundLeft = false;
            boolean foundUp = false;
            boolean foundRight = false;
            boolean foundDown = false;

            String response = "";
            while (!response.equals("CENTER")) {
                for (int i = 0; i < 50; i++) {
                    if (!foundLeft) {
                        System.out.println((leftBound + i) + " " + 0);
                        String leftResponse = reader.readLine();
                        if (leftResponse.equals("HIT")) {
                            leftBound += i;
                            foundLeft = true;
                        }
                    }

                    if (!foundUp) {
                        System.out.println((upperBound - i) + " " + 0);
                        String upResponse = reader.readLine();
                        if (upResponse.equals("HIT")) {
                            upperBound -= i;
                            foundUp = true;
                        }
                    }

                    if (!foundRight) {
                        System.out.println((rightBound - i) + " " + 0);
                        String rightResponse = reader.readLine();
                        if (rightResponse.equals("HIT")) {
                            rightBound -= i;
                            foundRight = true;
                        }
                    }

                    if (!foundDown) {
                        System.out.println((lowerBound + i) + " " + 0);
                        String downResponse = reader.readLine();
                        if (downResponse.equals("HIT")) {
                            lowerBound += i;
                            foundDown = true;
                        }
                    }

                    if (foundLeft && foundRight && foundUp && foundDown) {
                        int centerX = (leftBound + rightBound) / 2;
                        int centerY = (upperBound + lowerBound) / 2;
                        System.out.println(centerX + " " + centerY);
                        response = reader.readLine();
                    }
                }
            }
        }
    }
}