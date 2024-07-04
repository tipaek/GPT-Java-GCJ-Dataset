import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String s = in.next();
            StringBuilder result = new StringBuilder();
            for (char ch : s.toCharArray()) {
                int num = ch - '0';
                for (int j = 0; j < num; j++) {
                    result.append('(');
                }
                result.append(ch);
                for (int j = 0; j < num; j++) {
                    result.append(')');
                }
            }
            String answer = result.toString().replace(")(", "");
            while(answer.length() != answer.replace(")(", "").length());
            System.out.println(String.format("Case #%d: %s", i + 1, answer));
        }
    }
}
