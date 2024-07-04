import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static String expand(String s, int offset) {
        if (offset > 9) {
            return s;
        } else if ("".equals(s)) {
            return "";
        }
        String offsetString = String.valueOf(offset);
        int start = 0;
        List<String> subs = new ArrayList<>();
        while (start <= s.length()) {
            int first = s.substring(start).indexOf(offsetString);
            if (first != -1) {
                subs.add(s.substring(start, start + first));
                start = start + first + 1;
            } else {
                subs.add(s.substring(start));
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < subs.size(); ++i) {
            String meat = expand(subs.get(i), offset + 1);
            if (!"".equals(meat)) {
                result.append('(').append(meat).append(')');
            }
            if (i < subs.size() - 1) {
                result.append(offset);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = Integer.valueOf(scanner.nextLine());
        for (int i = 1; i <= nCases; ++i) {
            String s = scanner.nextLine();
            System.out.println(String.format("Case #%d: %s", i, expand(s, 0)));
        }
    }

}
