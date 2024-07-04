import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bits = Integer.parseInt(input[1]);

        for (int t = 1; t <= testCases; t++) {
            int[] bitsArray = new int[bits + 1];

            for (int i = 1; i <= bits; i++) {
                System.out.println(i);
                bitsArray[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i <= bits; i++) {
                System.out.print(bitsArray[i]);
            }
            System.out.println();

            char response = br.readLine().charAt(0);
            if (response == 'N') {
                break;
            }
        }
    }
}