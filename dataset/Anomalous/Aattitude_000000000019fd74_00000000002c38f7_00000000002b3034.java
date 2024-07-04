import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean isValid = true;
            String minString = br.readLine();
            String maxString = minString;

            for (int i = 1; i < n; i++) {
                String currentString = br.readLine();
                if (currentString.length() > maxString.length()) {
                    maxString = currentString;
                }

                String longerString = currentString.length() > minString.length() ? currentString : minString;
                String shorterString = currentString.length() > minString.length() ? minString : currentString;

                int longerIndex = longerString.length() - 1;
                for (int j = shorterString.length() - 1; j > 0; j--) {
                    if (shorterString.charAt(j) != longerString.charAt(longerIndex)) {
                        isValid = false;
                        break;
                    }
                    longerIndex--;
                }
            }

            if (isValid && maxString.length() > 1) {
                bw.write("Case #" + (t + 1) + ": " + maxString.substring(1) + "\n");
            } else {
                bw.write("Case #" + (t + 1) + ": *\n");
            }
        }
        bw.flush();
    }
}