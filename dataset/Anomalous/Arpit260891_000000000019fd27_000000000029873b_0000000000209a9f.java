import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int count = 1; count <= t; count++) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder();

            int previousDigit = 0;
            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);

                if (currentDigit > previousDigit) {
                    result.append(repeatChar('(', currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(repeatChar(')', previousDigit - currentDigit));
                }

                result.append(ch);
                previousDigit = currentDigit;
            }
            result.append(repeatChar(')', previousDigit));

            System.out.println("Case #" + count + ": " + result.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}