import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int q = 0; q < testCases; q++) {
            String s = reader.readLine();
            int len = s.length();
            StringBuilder sNew = new StringBuilder();
            int brackets = 0;

            for (int i = 0; i < len; i++) {
                int temp = Character.getNumericValue(s.charAt(i));

                if (temp > brackets) {
                    for (int j = 0; j < (temp - brackets); j++) {
                        sNew.append("(");
                    }
                    brackets = temp;
                } else if (temp < brackets) {
                    for (int j = 0; j < (brackets - temp); j++) {
                        sNew.append(")");
                    }
                    brackets = temp;
                }
                sNew.append(s.charAt(i));
            }

            while (brackets != 0) {
                sNew.append(")");
                brackets--;
            }

            System.out.println("Case #" + (q + 1) + ": " + sNew.toString());
        }
    }
}