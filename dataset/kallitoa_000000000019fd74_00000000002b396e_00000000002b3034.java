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
            int k = Integer.valueOf(input.nextLine());
            List<String> patterns = new ArrayList<>();
            while (k > 0) {
                String s = input.nextLine();
                patterns.add(s);
                k--;
            }
            results.add(String.format("Case #%d: %s", caseNumber, getResult(patterns)));
            caseNumber++;
            t--;
        }

        for (String r : results) {
            System.out.println(r);
        }

    }

    private static String getResult(List<String> patterns) {
        String result = "";

        for (String p : patterns) {
            p = p.replaceAll("\\*", "");
            if (result.endsWith(p)) {
                result = result;
            } else if (p.endsWith(result)) {
                result = p;
            } else {
                return "*";
            }
        }

        return "C" + result;
    }
}
