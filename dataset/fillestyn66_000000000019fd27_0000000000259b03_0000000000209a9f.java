import java.util.*;
import java.io.*;

public class Solution {

    private static final String L_PARE = "(";
    private static final String R_PARE = ")";
    private static Integer position = 0;
    private static Integer depth = 0;

    private static void addPare(StringBuilder result, String bracket, int amount) {
        for (int x = 0; x < amount; x++) {
            result.append(bracket);
        }
    }

    private static void process(StringBuilder result, int value) {
        int p = position;
        if (depth == value) {
            result.insert(p, value);
            position = position + 1;
        } else if (depth < value) {
            addPare(result, L_PARE, value);
            result.append(value);
            position = result.length() - 1;
            addPare(result, R_PARE, value);
            depth = value;
        } else {
            int offset = depth - value + p + 1;
            result.insert(offset, value);
            position = offset;
            depth = value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String charLine = in.nextLine();
            StringBuilder result = new StringBuilder(500);
            depth = 0;
            position = 0;
            charLine.chars().forEach(c -> process(result, Character.getNumericValue(c)));
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}