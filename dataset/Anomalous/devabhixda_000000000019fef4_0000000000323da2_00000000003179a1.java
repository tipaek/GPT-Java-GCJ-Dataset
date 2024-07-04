import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Map<Long, Set<String>> map = new HashMap<>();
            
            for (int j = 0; j < 10000; j++) {
                long key = scanner.nextLong();
                String value = scanner.next();
                
                map.computeIfAbsent(key, k -> new HashSet<>()).add(value);
            }
            
            Stack<String> stack = new Stack<>();
            Set<String> resultSet = new HashSet<>();
            
            for (long j = 1; j <= 10; j++) {
                Set<String> values = map.get(j);
                if (values != null) {
                    for (String value : values) {
                        if (resultSet.add(value)) {
                            stack.push(value);
                        }
                    }
                }
            }
            
            StringBuilder resultBuilder = new StringBuilder();
            char[] lastElementChars = stack.pop().toCharArray();
            
            for (String s : stack) {
                resultBuilder.append(s);
            }
            
            for (char ch : lastElementChars) {
                if (resultBuilder.indexOf(String.valueOf(ch)) == -1) {
                    resultBuilder.insert(0, ch);
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + resultBuilder.toString());
        }
    }
}