import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            Map<Integer, String> stringMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String input = scanner.nextLine();
                stringMap.put(input.length(), input.replace("*", ""));
            }

            int maxLength = 0;
            for (int length : stringMap.keySet()) {
                if (length > maxLength) {
                    maxLength = length;
                }
            }

            String longestString = stringMap.get(maxLength);
            boolean isValid = true;

            for (String value : stringMap.values()) {
                if (!longestString.contains(value)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + testCase + ": " + longestString);
            } else {
                System.out.println("Case #" + testCase + ": *");
            }
        }

        scanner.close();
    }
}