import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] ar = new String[n];
            int[] len = new int[n];
            int minLen = Integer.MAX_VALUE;
            int maxLen = 0;
            int minPos = 0, maxPos = 0, starCount = 0;

            for (int j = 0; j < n; j++) {
                ar[j] = br.readLine();
                len[j] = ar[j].length();

                if (len[j] < minLen) {
                    minLen = len[j];
                    minPos = j;
                }
                if (len[j] > maxLen) {
                    maxLen = len[j];
                    maxPos = j;
                }
                if (ar[j].charAt(0) == '*') {
                    starCount++;
                }
            }

            if (starCount == n) {
                String shortestPattern = ar[minPos];
                char endChar = shortestPattern.charAt(minLen - 1);
                boolean isValid = true;

                for (int k = 1; k < maxLen; k++) {
                    for (int j = 0; j < n; j++) {
                        String currentPattern = ar[j];
                        int currentLen = currentPattern.length();

                        if (currentLen >= k) {
                            char currentChar = currentPattern.charAt(currentLen - k);
                            if (currentChar != endChar && currentChar != '*') {
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if (!isValid) break;
                }

                if (isValid) {
                    System.out.println("Case #" + i + ": " + ar[maxPos].substring(1));
                }
            }
        }
    }
}