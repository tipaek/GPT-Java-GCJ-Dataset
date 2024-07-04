import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                new Solution().processCase(i, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }

        strings.sort(Comparator.comparingInt(String::length));

        for (String str : strings) {
            System.out.println(str);
        }

        boolean isPatternValid = true;
        String prev = strings.get(0);
        int starIndex = prev.indexOf('*');
        String prevLeft = prev.substring(0, starIndex);
        String prevRight = starIndex < prev.length() ? prev.substring(starIndex + 1) : "";

        System.out.printf("Initial prevLeft = %s, prevRight = %s%n", prevLeft, prevRight);

        for (String str : strings) {
            starIndex = str.indexOf('*');
            String curLeft = str.substring(0, starIndex);
            String curRight = starIndex < str.length() ? str.substring(starIndex + 1) : "";

            if (!matchPrefix(prevLeft, curLeft)) {
                isPatternValid = false;
                break;
            }
            
            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            if (!matchSuffix(prevRight, curRight)) {
                isPatternValid = false;
                break;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

            System.out.printf("Updated prevLeft = %s, prevRight = %s%n", prevLeft, prevRight);
        }

        String result = isPatternValid ? prevLeft + prevRight : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean matchPrefix(String prevLeft, String curLeft) {
        int minLength = Math.min(prevLeft.length(), curLeft.length());
        for (int i = 0; i < minLength; i++) {
            if (prevLeft.charAt(i) != curLeft.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean matchSuffix(String prevRight, String curRight) {
        int prevLength = prevRight.length();
        int curLength = curRight.length();
        int minLength = Math.min(prevLength, curLength);
        
        for (int i = 0; i < minLength; i++) {
            if (prevRight.charAt(prevLength - 1 - i) != curRight.charAt(curLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}