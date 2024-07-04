import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int initialTestCases = testCases;

        while (testCases-- > 0) {
            int U = scanner.nextInt();
            HashMap<String, String> hashMap = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String query = scanner.next();
                String response = scanner.next();
                hashMap.put(query, response);
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i <= 9; i++) {
                String key = Integer.toString(i);
                if (hashMap.containsKey(key)) {
                    answer.append(hashMap.get(key));
                }
            }

            System.out.println("Case #" + (initialTestCases - testCases) + ": " + answer);
        }

        scanner.close();
    }
}