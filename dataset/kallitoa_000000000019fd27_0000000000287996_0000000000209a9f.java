import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int t = Integer.valueOf(input.nextLine());
        int caseNumber = 1;
        List<String> results = new ArrayList<>();

        while (t > 0) {
            String s = input.nextLine();
            results.add(String.format("Case #%d: %s", caseNumber, getResult(s)));
            caseNumber++;
            t--;
        }

        for (String r : results) {
            System.out.println(r);
        }

    }

    private static String getResult(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (i == 0 || s.charAt(i - 1) == '0') {
                    res.append("(");
                }

                res.append("1");

                if (i + 1 == s.length() || s.charAt(i + 1) == '0') {
                    res.append(")");
                }
            } else {
                res.append("0");
            }
        }

        return res.toString();
    }

}
