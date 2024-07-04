import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }

        list.sort(Comparator.comparingInt(String::length));

        boolean pattern = true;
        String prev = list.get(0);
        int index = prev.indexOf("*");
        String prevLeft = prev.substring(0, index);
        String prevRight = index < prev.length() ? prev.substring(index + 1) : "";

        for (String str : list) {
            index = str.indexOf("*");
            String curLeft = str.substring(0, index);
            String curRight = index < str.length() ? str.substring(index + 1) : "";

            pattern = checkPattern(prevLeft, curLeft) && checkPattern(new StringBuilder(prevRight).reverse().toString(), new StringBuilder(curRight).reverse().toString());

            if (!pattern) break;

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }
        }

        String result = pattern ? prevLeft + prevRight : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean checkPattern(String prev, String cur) {
        int n1 = prev.length(), n2 = cur.length();
        int i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (prev.charAt(i1) != cur.charAt(i2)) {
                return false;
            }
            i1++;
            i2++;
        }
        return true;
    }
}