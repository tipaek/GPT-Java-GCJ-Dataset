import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            Map<Integer, Set<String>> numberToStringsMap = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                int number = scanner.nextInt();
                String str = scanner.next();

                numberToStringsMap.computeIfAbsent(number, k -> new HashSet<>()).add(str);
            }

            Stack<String> stack = new Stack<>();
            Set<String> resultSet = new HashSet<>();

            for (int j = 1; j <= 10; j++) {
                Set<String> strings = numberToStringsMap.getOrDefault(j, Collections.emptySet());
                for (String str : strings) {
                    if (!resultSet.contains(str)) {
                        stack.push(str);
                        resultSet.add(str);
                    }
                }
            }

            StringBuilder resultBuilder = new StringBuilder();
            char[] lastStringChars = stack.pop().toCharArray();

            for (String str : stack) {
                resultBuilder.append(str);
            }

            for (char ch : lastStringChars) {
                if (resultBuilder.indexOf(Character.toString(ch)) == -1) {
                    resultBuilder.insert(0, ch);
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
        }
    }
}