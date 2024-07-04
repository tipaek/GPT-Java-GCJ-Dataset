import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initialLine = br.readLine().split(" ");
        int testCases = Integer.parseInt(initialLine[0]);
        int bits = Integer.parseInt(initialLine[1]);

        for (int testCase = 0; testCase < testCases; testCase++) {
            StringBuilder resultRow = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                String cur = br.readLine();
                resultRow.append(cur);
            }
            System.out.println(resultRow);
            String result = br.readLine();
        }
    }
}