import java.util.*;

public class Fun {
    private static final String ANSWER_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int testCaseNum = 1; testCaseNum <= t; ++testCaseNum) {
                new Fun().processTestCase(testCaseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processTestCase(int testCaseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }

        list.sort(Comparator.comparingInt(String::length));

        for (String s : list) {
            System.out.println(s);
        }

        boolean isValid = true;
        String prev = list.get(0);
        int index = prev.indexOf("*");
        String prevLeft = prev.substring(0, index);
        String prevRight = index < prev.length() ? prev.substring(index + 1) : "";

        System.out.println(String.format("Initial prevLeft = %s, prevRight = %s", prevLeft, prevRight));

        for (String str : list) {
            index = str.indexOf("*");
            String curLeft = str.substring(0, index);
            String curRight = index < str.length() ? str.substring(index + 1) : "";

            if (!isPrefixMatching(prevLeft, curLeft) || !isSuffixMatching(prevRight, curRight)) {
                isValid = false;
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

            System.out.println(String.format("Updated prevLeft = %s, prevRight = %s", prevLeft, prevRight));
        }

        String result = isValid ? prevLeft + prevRight : "*";
        System.out.println(String.format(ANSWER_FORMAT, testCaseNum, result));
    }

    private boolean isPrefixMatching(String prevLeft, String curLeft) {
        int len = Math.min(prevLeft.length(), curLeft.length());
        for (int i = 0; i < len; i++) {
            if (prevLeft.charAt(i) != curLeft.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String prevRight, String curRight) {
        int len = Math.min(prevRight.length(), curRight.length());
        for (int i = 0; i < len; i++) {
            if (prevRight.charAt(prevRight.length() - 1 - i) != curRight.charAt(curRight.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}