import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        for (int testCase = 0; testCase < testCases; testCase++) {
            StringBuilder result = new StringBuilder();
            int queryIndex = 1;

            for (int i = 1; i <= b; queryIndex++) {
                System.out.println(i);
                String response = reader.readLine();
                
                if ("N".equals(response)) {
                    System.exit(0);
                }
                
                if (queryIndex % 10 != 1) {
                    result.append(response);
                    i++;
                }
            }

            while (queryIndex <= 150) {
                System.out.println(1);
                String response = reader.readLine();
                
                if ("N".equals(response)) {
                    System.exit(0);
                }
                
                queryIndex++;
            }

            System.out.println(result.toString());
        }
    }
}