import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String PLACEHOLDER = "x";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            String s = reader.readLine();
            String result = getResult(s);

            int index = 0;
            for (int i = 0; i < result.length(); i++) {
                if (String.valueOf(result.charAt(i)).equals(PLACEHOLDER)) {
                    result = result.replaceFirst(PLACEHOLDER, String.valueOf(s.charAt(index++)));
                }
            }

            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }

    private static String getResult(String s) {
        if (checkAllZeros(s)) {
            return String.join("", Collections.nCopies(s.length(), PLACEHOLDER));
        }

        if (s.length() == 1) {
            int number = Integer.parseInt(s);
            return String.join("", Collections.nCopies(number, "("))
                    + PLACEHOLDER
                    + String.join("", Collections.nCopies(number, ")"));
        }

        if (s.contains("0")) {
            Pattern p = Pattern.compile("0+|[1-9]+");
            Matcher m = p.matcher(s);
            ArrayList<String> groups = new ArrayList<>();
            while (m.find()) {
                groups.add(m.group());
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < groups.size(); i++) {
                String group = groups.get(i);
                result.append(getResult(group));
            }
            return result.toString();
        }

        int minimum = 10;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' < minimum) {
                minimum = s.charAt(i) - '0';
            }
        }

        s = subtractFromString(s, minimum);

        return String.join("", Collections.nCopies(minimum, "("))
                + getResult(s)
                + String.join("", Collections.nCopies(minimum, ")"));
    }

    private static boolean checkAllZeros(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private static String subtractFromString(String s, int num) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            r.append(Integer.parseInt(String.valueOf(s.charAt(i))) - num);
        }
        return r.toString();
    }
}
