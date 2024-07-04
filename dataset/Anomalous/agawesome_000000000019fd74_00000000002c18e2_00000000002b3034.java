import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    
    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            return Integer.compare(x.length(), y.length());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numStrings = scanner.nextInt();
            String[] strings = new String[numStrings];

            for (int j = 0; j < numStrings; j++) {
                strings[j] = scanner.next().substring(1);
            }

            Arrays.sort(strings, new StringLengthComparator());

            boolean isValid = true;
            for (int j = 1; j < numStrings; j++) {
                int lengthDifference = strings[j].length() - strings[j - 1].length();

                if (strings[j].length() == strings[j - 1].length()) {
                    if (!strings[j].equals(strings[j - 1])) {
                        System.out.println("Case #" + i + ": *");
                        isValid = false;
                        break;
                    }
                } else {
                    if (!strings[j].substring(lengthDifference).equals(strings[j - 1])) {
                        System.out.println("Case #" + i + ": *");
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + i + ": " + strings[numStrings - 1]);
            }
        }
    }
}