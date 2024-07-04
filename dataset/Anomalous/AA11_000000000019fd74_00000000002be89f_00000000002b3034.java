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
            int minPos = 0, maxPos = 0;
            int starCount = 0;
            
            for (int j = 0; j < n; j++) {
                ar[j] = br.readLine();
                len[j] = ar[j].length();
                char firstChar = ar[j].charAt(0);
                
                if (len[j] < minLen) {
                    minLen = len[j];
                    minPos = j;
                }
                if (len[j] > maxLen) {
                    maxLen = len[j];
                    maxPos = j;
                }
                if (firstChar == '*') {
                    starCount++;
                }
            }
            
            if (starCount == n) {
                String minLenString = ar[minPos];
                char lastChar = minLenString.charAt(minLen - 1);
                boolean isMatch = true;

                for (int k = 1; k < maxLen; k++) {
                    for (int j = 0; j < n; j++) {
                        String currentString = ar[j];
                        int currentLen = currentString.length();
                        
                        if (currentLen > k) {
                            char currentChar = currentString.charAt(currentLen - k);
                            if (currentChar != lastChar && currentChar != '*') {
                                isMatch = false;
                                break;
                            }
                        }
                    }
                    if (!isMatch) {
                        break;
                    }
                }
                
                if (isMatch) {
                    System.out.println("Case #" + i + ": " + ar[maxPos].substring(1));
                }
            }
        }
    }
}