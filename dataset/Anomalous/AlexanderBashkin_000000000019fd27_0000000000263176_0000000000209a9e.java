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
        int b = Integer.parseInt(tokenizer.nextToken());

        for (int test = 0; test < numberOfTests; test++) {
            StringBuilder result = new StringBuilder();
            int index = 1;
            for (int i = 1; i <= b; index++) {
                System.out.println(i);
                String response = reader.readLine();
                if ("N".equals(response)) System.exit(0);
                if (index % 10 != 1) {
                    result.append(response);
                    i++;
                }
            }
            System.out.println(result.toString());
        }
    }
}