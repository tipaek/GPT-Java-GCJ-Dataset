import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            input.nextLine(); // Consume the newline character
            String[] store = new String[n];
            List<Character> beginning = new ArrayList<>();
            List<Character> end = new ArrayList<>();
            List<Character> any = new ArrayList<>();
            boolean works = true;

            for (int k = 0; k < n; k++) {
                String temp = input.nextLine();
                store[k] = temp;

                String begintest = extractBeginning(temp);
                String endtest = extractEnd(temp);

                works = updateBeginning(beginning, begintest) && updateEnd(end, endtest);

                if (!works) {
                    System.out.println("Case #" + (i + 1) + ": *");
                    break;
                }

                addMiddleCharacters(temp, any);
            }

            if (works) {
                System.out.println("Case #" + (i + 1) + ": " + buildResult(beginning, any, end));
            }
        }
    }

    private static String extractBeginning(String temp) {
        int starIndex = temp.indexOf('*');
        return starIndex == -1 ? temp : temp.substring(0, starIndex);
    }

    private static String extractEnd(String temp) {
        int starIndex = temp.lastIndexOf('*');
        return starIndex == -1 ? temp : temp.substring(starIndex + 1);
    }

    private static boolean updateBeginning(List<Character> beginning, String begintest) {
        for (int j = 0; j < Math.min(beginning.size(), begintest.length()); j++) {
            if (beginning.get(j) != begintest.charAt(j)) {
                return false;
            }
        }
        for (int j = beginning.size(); j < begintest.length(); j++) {
            beginning.add(begintest.charAt(j));
        }
        return true;
    }

    private static boolean updateEnd(List<Character> end, String endtest) {
        for (int j = 0; j < Math.min(end.size(), endtest.length()); j++) {
            if (end.get(end.size() - 1 - j) != endtest.charAt(endtest.length() - 1 - j)) {
                return false;
            }
        }
        for (int j = end.size(); j < endtest.length(); j++) {
            end.add(0, endtest.charAt(endtest.length() - 1 - j));
        }
        return true;
    }

    private static void addMiddleCharacters(String temp, List<Character> any) {
        int firstStar = temp.indexOf('*');
        int lastStar = temp.lastIndexOf('*');
        for (int j = firstStar + 1; j < lastStar; j++) {
            if (temp.charAt(j) != '*') {
                any.add(temp.charAt(j));
            }
        }
    }

    private static String buildResult(List<Character> beginning, List<Character> any, List<Character> end) {
        StringBuilder result = new StringBuilder();
        for (char c : beginning) result.append(c);
        for (char c : any) result.append(c);
        for (char c : end) result.append(c);
        return result.toString();
    }
}