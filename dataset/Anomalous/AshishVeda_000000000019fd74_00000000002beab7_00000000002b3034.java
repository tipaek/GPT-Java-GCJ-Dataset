import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        while (numTests > 0) {
            int numStrings = scanner.nextInt();
            String[] strings = new String[numStrings];

            for (int i = 0; i < numStrings; i++) {
                strings[i] = scanner.next();
            }

            Arrays.sort(strings, Comparator.comparingInt(String::length));

            String reference = strings[numStrings - 1];
            int starIndex = reference.indexOf('*');
            String refPrefix = reference.substring(0, starIndex);
            String refSuffix = reference.substring(starIndex + 1);

            boolean isValid = true;
            for (int i = 0; i < numStrings - 1; i++) {
                String current = strings[i];
                int currentStarIndex = current.indexOf('*');
                String currentPrefix = current.substring(0, currentStarIndex);
                String currentSuffix = current.substring(currentStarIndex + 1);

                if (!refPrefix.startsWith(currentPrefix) || !refSuffix.endsWith(currentSuffix)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(refPrefix + refSuffix);
            } else {
                System.out.println('*');
            }

            numTests--;
        }

        scanner.close();
    }
}