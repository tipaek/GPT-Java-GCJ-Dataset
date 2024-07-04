import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            String[] strings = new String[N];
            int maxLength = 0;
            int maxIndex = 0;

            for (int i = 0; i < N; i++) {
                strings[i] = scanner.next();
                if (strings[i].length() > maxLength) {
                    maxLength = strings[i].length();
                    maxIndex = i;
                }
            }

            boolean isMatch = true;
            String longestSuffix = strings[maxIndex].substring(1);

            for (int i = 0; i < N; i++) {
                String currentSuffix = strings[i].substring(1);
                int suffixLength = maxLength - 2;

                for (int j = currentSuffix.length() - 1; j >= 0; j--, suffixLength--) {
                    if (currentSuffix.charAt(j) != longestSuffix.charAt(suffixLength)) {
                        isMatch = false;
                        break;
                    }
                }

                if (!isMatch) {
                    break;
                }
            }

            String result = isMatch ? longestSuffix : "*";
            System.out.println("Case #" + tc + ": " + result);
        }
    }
}