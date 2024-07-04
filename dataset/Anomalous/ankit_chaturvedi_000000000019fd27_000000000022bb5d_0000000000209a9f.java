import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int count = 1;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String value = br.readLine();
            int open = 0;
            List<Character> output = new ArrayList<>();

            for (int i = 0; i < value.length(); i++) {
                int digit = Character.getNumericValue(value.charAt(i));

                if (digit == 0) {
                    while (open > 0) {
                        output.add(')');
                        open--;
                    }
                    output.add(value.charAt(i));
                } else if (digit > open) {
                    while (open < digit) {
                        output.add('(');
                        open++;
                    }
                    output.add(value.charAt(i));
                } else if (digit < open) {
                    while (open > digit) {
                        output.add(')');
                        open--;
                    }
                    output.add(value.charAt(i));
                } else {
                    output.add(value.charAt(i));
                }
            }

            while (open > 0) {
                output.add(')');
                open--;
            }

            result.append("Case #").append(count).append(": ");
            for (char ch : output) {
                result.append(ch);
            }
            result.append("\n");
            count++;
        }
        System.out.print(result);
    }
}