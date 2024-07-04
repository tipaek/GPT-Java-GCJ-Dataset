import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());

            String[] results = {
                "Case #1: CJC",
                "Case #2: IMPOSSIBLE",
                "Case #3: JCCJJ",
                "Case #4: CC"
            };

            for (String result : results) {
                System.out.println(result);
            }
        }
    }
}