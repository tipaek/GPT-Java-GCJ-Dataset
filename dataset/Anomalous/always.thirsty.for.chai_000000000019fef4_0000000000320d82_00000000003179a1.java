import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int totalCases = testCases;

        while (testCases-- > 0) {
            int U = scanner.nextInt();
            HashMap<String, String> hashMap = new HashMap<>();

            for (int i = 0; i < 10; i++) {
                String question = scanner.next();
                String response = scanner.next();
                hashMap.put(question, response);
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i <= 9; i++) {
                String key = Integer.toString(i);
                if (hashMap.containsKey(key)) {
                    answer.append(hashMap.get(key));
                }
            }

            System.out.println("Case #" + (totalCases - testCases) + ": " + answer);
        }

        scanner.close();
    }
}