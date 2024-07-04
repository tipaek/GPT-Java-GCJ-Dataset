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
        int numberOfTests = Integer.parseInt(tokenizer.nextToken());
        int boundary = Integer.parseInt(tokenizer.nextToken());

        for (int testCase = 0; testCase < numberOfTests; testCase++) {
            StringBuilder result = new StringBuilder();
            int queryIndex = 1;

            for (int i = 1; i <= boundary; queryIndex++) {
                System.out.println(i);
                String response = getResponse(reader);
                if (queryIndex % 10 != 1) {
                    result.append(response);
                    i++;
                }
            }
            System.out.println(result.toString());
            getResponse(reader);
        }
    }

    private String getResponse(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        if ("N".equals(input)) System.exit(0);
        return input;
    }
}