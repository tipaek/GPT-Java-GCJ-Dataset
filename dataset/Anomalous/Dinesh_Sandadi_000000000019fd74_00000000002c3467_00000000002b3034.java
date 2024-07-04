import java.util.*;

public class Solution {

    private boolean hasCommonStringEnd(List<String> list) {
        if (list.isEmpty()) return true;
        String common = list.get(0);

        for (String current : list) {
            if (!common.endsWith(current)) return false;
        }
        return true;
    }

    private boolean hasCommonStringStart(List<String> list) {
        if (list.isEmpty()) return true;
        String common = list.get(0);

        for (String current : list) {
            if (!common.startsWith(current)) return false;
        }
        return true;
    }

    private String findPattern(String[] arr) {
        List<String> startPatterns = new ArrayList<>();
        List<String> endPatterns = new ArrayList<>();
        StringBuilder middlePattern = new StringBuilder();

        for (String str : arr) {
            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            int firstStar = str.indexOf('*');
            int lastStar = str.lastIndexOf('*');

            if (firstStar != -1) {
                start.append(str, 0, firstStar);
                startPatterns.add(start.toString());
            }

            if (lastStar != -1) {
                end.append(str, lastStar + 1, str.length());
                endPatterns.add(end.toString());
            }

            for (int j = firstStar; j < lastStar; j++) {
                if (str.charAt(j) != '*') {
                    middlePattern.append(str.charAt(j));
                }
            }
        }

        if (startPatterns.isEmpty() && endPatterns.isEmpty()) return "A";

        Collections.sort(startPatterns, Comparator.comparingInt(String::length).reversed());
        Collections.sort(endPatterns, Comparator.comparingInt(String::length).reversed());

        String prefix = "";
        String suffix = "";

        if (hasCommonStringStart(startPatterns)) {
            prefix = startPatterns.get(0);
        } else {
            return "";
        }

        if (hasCommonStringEnd(endPatterns)) {
            suffix = endPatterns.get(0);
        } else {
            return "";
        }

        return prefix + middlePattern.toString() + suffix;
    }

    private void printAnswer(String answer, int testCase) {
        if (answer.isEmpty()) answer = "*";
        System.out.println("Case #" + testCase + ": " + answer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextLine();
            }
            String result = solution.findPattern(arr);
            solution.printAnswer(result, i);
        }
    }
}