import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfStrings = scanner.nextInt();
            List<String> stringList = new ArrayList<>();

            for (int i = 0; i < numberOfStrings; i++) {
                stringList.add(scanner.next());
            }

            TreeSet<String> sortedSet = new TreeSet<>(stringList);
            stringList = new ArrayList<>(sortedSet);
            String[] stringArray = stringList.toArray(new String[0]);

            // Sort strings by length in descending order
            Arrays.sort(stringArray, (a, b) -> Integer.compare(b.length(), a.length()));

            boolean isMatch = true;
            String basePattern = stringArray[0].replace("*", "");

            for (int i = 1; i < stringArray.length && isMatch; i++) {
                if (!matches(stringArray[i], basePattern)) {
                    isMatch = false;
                }
            }

            System.out.print("Case #" + caseIndex + ": ");
            if (isMatch) {
                System.out.println(basePattern);
            } else {
                System.out.println("*");
            }
        }
    }

    public static boolean matches(String first, String second) {
        if (first.isEmpty() && second.isEmpty()) {
            return true;
        }
        if (first.length() > 1 && first.charAt(0) == '*' && second.isEmpty()) {
            return false;
        }
        if (!first.isEmpty() && !second.isEmpty() && first.charAt(0) == second.charAt(0)) {
            return matches(first.substring(1), second.substring(1));
        }
        if (!first.isEmpty() && first.charAt(0) == '*') {
            return matches(first.substring(1), second) || matches(first, second.substring(1));
        }
        return false;
    }
}