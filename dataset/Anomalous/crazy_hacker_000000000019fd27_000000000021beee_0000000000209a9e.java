import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder bitSequence = new StringBuilder();
            int queryCount = 1;

            while (bitSequence.length() < bitLength) {
                System.out.println(bitSequence.length() + 1);
                int bit = Integer.parseInt(br.readLine());

                if (queryCount % 10 != 1) {
                    bitSequence.append(bit);
                }

                queryCount++;
            }

            System.out.println(bitSequence);
        }
    }
}