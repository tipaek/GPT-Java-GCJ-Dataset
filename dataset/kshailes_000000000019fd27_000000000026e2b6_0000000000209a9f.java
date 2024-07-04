import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int t = 0;
        int caseNumber = 1;
        Scanner scanner = new Scanner(System.in);
        t = Integer.parseInt(scanner.nextLine());
        while (caseNumber <= t) {
            String s;
            s = scanner.nextLine();
            boolean hasOne = false;
            List<Character> chars = new LinkedList();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1' && !hasOne) {
                    hasOne = true;
                    chars.add('(');
                } else if (s.charAt(i) == '0') {
                    if (hasOne) {
                        chars.add(')');
                    }
                    hasOne = false;
                }
                chars.add(s.charAt(i));
                if (i == s.length() - 1 && s.charAt(i) == '1') {
                    chars.add(')');
                }

            }


            String ans = chars.stream().map(e -> e.toString()).collect(Collectors.joining());
            System.out.println("Case #" + caseNumber + ": " + ans);

            caseNumber++;
        }
    }
}
