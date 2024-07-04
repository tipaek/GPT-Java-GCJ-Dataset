import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int testCases = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int index = 1;

            for (int t = 0; t < testCases; t++) {
                StringBuilder result = new StringBuilder();
                for (int i = 1; i <= b; index++) {
                    System.out.println(i);
                    String input = readInput(reader);
                    if (index % 10 != 1) {
                        result.append(input);
                        i++;
                    }
                }
                System.out.println(result.toString());
            }
        }
    }

    private String readInput(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        if ("N".equals(input)) {
            System.exit(0);
        }
        return input;
    }
}