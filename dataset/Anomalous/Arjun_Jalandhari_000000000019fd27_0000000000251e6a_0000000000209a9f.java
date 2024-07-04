import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int z = 0; z < T; z++) {
            result.append("Case #").append(z + 1).append(": ");

            String input = reader.readLine();
            StringBuilder[] filled = new StringBuilder[input.length()];

            for (int i = 0; i < input.length(); i++) {
                int n = Character.getNumericValue(input.charAt(i));
                StringBuilder strB = new StringBuilder();

                strB.append("(".repeat(n)).append(n).append(")".repeat(n));
                filled[i] = strB;
            }

            result.append(filled[0]);

            for (int i = 1; i < input.length(); i++) {
                int total = 0, l = result.length() - 1;

                while (l > 0 && result.charAt(l - total) == ')' && filled[i].charAt(total) == '(') {
                    total++;
                    l--;
                }

                for (int r = 0; r < total; r++) {
                    result.deleteCharAt(result.length() - 1);
                    filled[i].deleteCharAt(0);
                }

                result.append(filled[i]);
            }

            result.append("\n");
        }

        System.out.print(result.toString().trim());
    }
}