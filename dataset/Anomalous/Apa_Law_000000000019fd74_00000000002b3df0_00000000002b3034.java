import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int numStrings = Integer.parseInt(scanner.nextLine());
            Map<Integer, String> stringMap = new HashMap<>();

            for (int j = 0; j < numStrings; j++) {
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
                System.out.println("Case #" + (i + 1) + ": " + longestString);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }

        scanner.close();
    }
}