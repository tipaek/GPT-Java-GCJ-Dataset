import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader) throws IOException {
        String digits = reader.readLine();
        int opening = 0;
        StringBuilder result = new StringBuilder();
        for (char c : digits.toCharArray()) {
            int i = Character.getNumericValue(c);
            while (opening < i) {
                opening++;
                result.append('(');
            }
            while (opening > i) {
                opening--;
                result.append(')');
            }
            result.append(i);
        }
        while (opening > 0) {
            opening--;
            result.append(')');
        }
        System.out.println("Case #" + caseId + ": " + result);
    }
}