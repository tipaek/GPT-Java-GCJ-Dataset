import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = reader.readLine().split(" ");
            long left = Long.parseLong(input[0]);
            long right = Long.parseLong(input[1]);
            int i = 0;

            while (true) {
                if (i <= right || i <= left) {
                    if (left < right) {
                        right -= i;
                    } else {
                        left -= i;
                    }
                } else {
                    System.out.println("Case #" + testCase + ": " + (i - 1) + " " + left + " " + right);
                    break;
                }
                i++;
            }
        }
    }
}