import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder binaryString = new StringBuilder();
            int queryCount = 1;

            while (binaryString.length() < bitLength) {
                System.out.println(binaryString.length() + 1);
                int bit = Integer.parseInt(reader.readLine());

                if (queryCount % 10 != 1) {
                    binaryString.append(bit);
                }
                queryCount++;
            }

            System.out.println(binaryString.toString());
            reader.readLine(); // Read the response line
        }
    }
}