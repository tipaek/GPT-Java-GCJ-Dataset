import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<String> patterns = new ArrayList<>();
            String maxLength = "";
            for (int j = 0; j < n; j++) {
                String s = new StringBuilder(in.next()).reverse().toString();
                patterns.add(s);
                if (maxLength.length() < s.length()) {
                    maxLength = s;
                }
            }
            String finalMaxLength = maxLength;
            if (patterns.stream().filter(s -> finalMaxLength.
                    startsWith(s.replace("*", "")))
                    .count() == patterns.size()) {
                System.out.println(String.format("Case #%d: %s", i + 1,
                        new StringBuilder(maxLength).reverse().toString().replace("*", "")));
            } else {
                String answer = "*";
                System.out.println(String.format("Case #%d: %s", i + 1, answer));
            }
        }
    }
}
