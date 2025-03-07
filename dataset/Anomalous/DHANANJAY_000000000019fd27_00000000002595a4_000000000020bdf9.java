import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];

            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }

            if (intervals[0] == 0 && intervals[1] == 1440 && n > 2) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder result = new StringBuilder();
            String firstCharacter = (intervals[0] % 2 == 0) ? "C" : "J";
            String secondCharacter = (firstCharacter.equals("C")) ? "J" : "C";

            result.append(firstCharacter);

            for (int k = 2; k < n * 2; k += 2) {
                if ((intervals[k] < intervals[k - 1] && intervals[k] > intervals[k - 2]) ||
                    (intervals[k + 1] > intervals[k - 2] && intervals[k + 1] < intervals[k - 2])) {
                    result.append(secondCharacter);
                } else if ((intervals[k] < intervals[k - 1] && intervals[k] < intervals[k - 2]) ||
                           (intervals[k + 1] < intervals[k - 2] && intervals[k + 1] > intervals[k - 2])) {
                    if (result.charAt(result.length() - 1) == 'J') {
                        result.append(secondCharacter);
                    } else {
                        result.append(firstCharacter);
                    }
                } else if (intervals[k] == intervals[k - 1]) {
                    result.append(result.charAt(result.length() - 1));
                } else {
                    result.append(firstCharacter);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}