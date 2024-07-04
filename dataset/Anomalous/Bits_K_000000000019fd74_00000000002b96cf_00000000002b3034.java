import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                patterns.add(sc.next());
            }

            patterns.sort(Comparator.comparingInt(String::length));

            String result = "";
            boolean foundMismatch = false;

            for (int i = 1; i < n; i++) {
                String prevPattern = patterns.get(i - 1);
                String currPattern = patterns.get(i);
                int prevIndex = prevPattern.length() - 1;
                int currIndex = currPattern.length() - 1;

                while (prevIndex >= 0 && currIndex >= 0) {
                    char prevChar = prevPattern.charAt(prevIndex);
                    char currChar = currPattern.charAt(currIndex);

                    if (prevChar != '*' && currChar != '*' && prevChar != currChar) {
                        System.out.println("Case #" + caseNumber + ": *");
                        caseNumber++;
                        foundMismatch = true;
                        break;
                    } else if (prevChar == '*' || currChar == '*') {
                        if (prevChar != '*' && currChar == '*') {
                            result = currPattern.substring(0, currIndex) + prevChar + currPattern.substring(currIndex + 1);
                            patterns.set(i, result);
                        }
                    }
                    prevIndex--;
                    currIndex--;
                }

                if (foundMismatch) break;
            }

            if (!foundMismatch) {
                String finalPattern = patterns.get(n - 1).replace('*', 'A');
                System.out.println("Case #" + caseNumber + ": " + finalPattern);
                caseNumber++;
            }
        }
    }
}