import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bits = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] bitArray = new int[bits + 1];

            for (int i = 1; i <= bits; i++) {
                System.out.println(i);
                bitArray[i] = Integer.parseInt(reader.readLine());
            }

            for (int i = 1; i <= bits; i++) {
                System.out.print(bitArray[i]);
            }
            System.out.println();

            char verdict = reader.readLine().charAt(0);
            if (verdict == 'Y') {
                break;
            }
        }
    }
}