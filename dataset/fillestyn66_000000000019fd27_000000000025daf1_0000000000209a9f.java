import java.util.*;
import java.io.*;

public class Solution {

    private static final String L_PARE = "(";
    private static final String R_PARE = ")";
    private static Integer position = 0;
    private static Integer depth = 0;

    private static void addPare(StringBuilder result, String bracket, int amount, int p) {
        for (int x = 0; x < amount; x++) {
            result.insert(p, bracket);
        }
    }

    private static void process(StringBuilder result, int value) {
        if (depth == value) {
            result.insert(position.intValue(), value);
            position = position + 1;
        } else if (depth < value) {
            int offset = value - depth;
            addPare(result, L_PARE, offset, position);
            position += offset;
            result.insert(position.intValue(), value);
            position++;
            addPare(result, R_PARE, offset, position);
            depth = value;
        } else {
            int offset = depth - value + position;
            result.insert(offset, value);
            position = offset + 1;
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