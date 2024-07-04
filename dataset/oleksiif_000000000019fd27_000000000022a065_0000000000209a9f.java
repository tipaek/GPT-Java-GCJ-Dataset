import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            String line = in.next();
            StringBuilder output = new StringBuilder();
            int firstInteger = Character.getNumericValue(line.charAt(0));
            for (int i = 0; i < firstInteger; i++) {
                output.append("(");
            }
            for (int i = 0; i < line.length() - 1; i++) {
                int current = Character.getNumericValue(line.charAt(i));
                output.append(current);
                int next = Character.getNumericValue(line.charAt(i + 1));
                int difference = next - current;
                if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        output.append(")");
                    }
                } else {
                    for (int j = 0; j < difference; j++) {
                        output.append("(");
                    }
                }
            }
            int lastInteger = Character.getNumericValue(line.charAt(line.length() - 1));
            output.append(lastInteger);
            for (int i = 0; i < lastInteger; i++) {
                output.append(")");
            }
            System.out.println(String.format("Case #%s: %s", caseIndex, output));
        }
    }
}