import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = scanner.next().substring(1);
            substrings.add(str);
        }

        substrings.sort(Comparator.comparingInt(String::length));

        String longestSubstring = substrings.get(substrings.size() - 1);
        boolean isValid = substrings.stream().allMatch(longestSubstring::contains);

        String result = isValid ? longestSubstring : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }
}