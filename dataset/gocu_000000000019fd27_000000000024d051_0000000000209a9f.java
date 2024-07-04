import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static final String OPENING_PARAN = "(";
    public static final String CLOSING_PARAN = ")";

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(bi.readLine());

        for (int j = 0; j < numTestCases; j++) {
            String line = bi.readLine();
            int[] digits = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                digits[i] = Integer.parseInt(String.valueOf(line.toCharArray()[i]));
            }
            List<String> list = getDepthString(digits);
            String out = String.join("", list);
            System.out.println("Case #" + (j + 1) + ": " + out);
        }
    }

    private static List<String> getDepthString(int[] digits) {
        List<String> output = new ArrayList<String>();
        int height = 0;
        for (int i = 0; i < digits.length; i++) {
//            if (digits[i] == 0) {
//                output.add("0");
//            } else
            {
                int digit = digits[i];
                if (height == digit) {
//                    output.add(String.valueOf(digits[i]));
                } else if (height > digit) {
                    while (height >= digit + 1) {
                        output.add(")");
                        height = height - 1;
                    }
//                    output.add(String.valueOf(digits[i]));
                } else { //height < digit
                    while (height <= digit - 1) {
                        output.add("(");
                        height = height + 1;
                    }
//                    output.add(String.valueOf(digits[i]));
                }
                output.add(String.valueOf(digits[i]));
            }
        }
        while (height > 0) {
            output.add(")");
            height--;
        }
        return output;
    }
}
