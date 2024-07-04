import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            Map<Long, Set<String>> dataMap = new HashMap<>();

            for (int j = 0; j < 10000; j++) {
                long key = scanner.nextLong();
                String value = scanner.next();
                dataMap.computeIfAbsent(key, k -> new HashSet<>()).add(value);
            }

            Stack<String> stack = new Stack<>();
            Set<String> resultSet = new HashSet<>();

            for (long j = 1; j <= 10; j++) {
                if (dataMap.containsKey(j)) {
                    for (String value : dataMap.get(j)) {
                        if (!resultSet.contains(value)) {
                            stack.push(value);
                            resultSet.add(value);
                        }
                    }
                }
            }

            StringBuilder resultBuilder = new StringBuilder();
            if (!stack.isEmpty()) {
                char[] lastValueChars = stack.pop().toCharArray();
                for (String value : stack) {
                    resultBuilder.append(value);
                }
                for (char ch : lastValueChars) {
                    if (resultBuilder.indexOf(String.valueOf(ch)) == -1) {
                        resultBuilder.insert(0, ch);
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + resultBuilder.toString());
        }
    }
}