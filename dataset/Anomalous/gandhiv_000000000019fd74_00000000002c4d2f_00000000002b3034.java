import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<String> strings = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                strings.add(scanner.next());
            }

            TreeSet<String> sortedStrings = new TreeSet<>(strings);
            strings = new ArrayList<>(sortedStrings);

            String[] arr = new String[strings.size()];
            int index = 0;
            for (String str : strings) {
                arr[index++] = str;
            }

            for (int i = 1; i < strings.size(); i++) {
                String temp = arr[i];
                int j = i - 1;
                while (j >= 0 && temp.length() > arr[j].length()) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;
            }

            boolean isMatch = true;
            String pattern = arr[0].replace("*", "");

            for (int i = 1; i < n && isMatch; i++) {
                if (!isPatternMatch(arr[i], pattern)) {
                    isMatch = false;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (isMatch) {
                System.out.println(pattern);
            } else {
                System.out.println("*");
            }
        }
    }

    public static boolean isPatternMatch(String first, String second) {
        if (first.isEmpty() && second.isEmpty()) {
            return true;
        }
        if (first.length() > 1 && first.charAt(0) == '*' && second.isEmpty()) {
            return false;
        }
        if (!first.isEmpty() && !second.isEmpty() && first.charAt(0) == second.charAt(0)) {
            return isPatternMatch(first.substring(1), second.substring(1));
        }
        if (!first.isEmpty() && first.charAt(0) == '*') {
            return isPatternMatch(first.substring(1), second) || isPatternMatch(first, second.substring(1));
        }
        return false;
    }
}