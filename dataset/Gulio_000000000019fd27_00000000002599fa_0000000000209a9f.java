import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= T; ++t) {
            String line = in.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            int parenthesisCount = 0;
            for (int a = 0; a < line.length(); ++a) {
                int number = Character.getNumericValue(line.charAt(a));
                while (number > parenthesisCount) {
                    stringBuilder.append('(');
                    ++parenthesisCount;
                }
                while (number < parenthesisCount) {
                    stringBuilder.append(')');
                    --parenthesisCount;
                }
                stringBuilder.append(line.charAt(a));
            }
            while (parenthesisCount > 0) {
                stringBuilder.append(')');
                --parenthesisCount;
            }
            System.out.println("Case #" + t + ": " + stringBuilder);
        }
    }
}
