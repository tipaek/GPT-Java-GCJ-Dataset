import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            String input = br.readLine();
            int currentDepth = 0;
            StringBuilder output = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                int digit = input.charAt(j) - '0';

                if (digit > currentDepth) {
                    output.append(repeatChar('(', digit - currentDepth));
                } else if (digit < currentDepth) {
                    output.append(repeatChar(')', currentDepth - digit));
                }

                output.append(digit);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                output.append(repeatChar(')', currentDepth));
            }

            results.add(output.toString());
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}