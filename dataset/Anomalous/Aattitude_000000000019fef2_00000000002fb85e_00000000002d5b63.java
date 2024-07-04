import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int testCaseCount = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        for (int t = 0; t < testCaseCount; t++) {
            boolean foundCenter = false;

            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    System.out.println(j + " " + i);
                    String response = br.readLine();

                    if ("CENTER".equalsIgnoreCase(response)) {
                        foundCenter = true;
                        break;
                    }
                }
                if (foundCenter) {
                    break;
                }
            }
        }

        br.close();
        bw.close();
    }
}