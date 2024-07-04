import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean isValid = true;
            String minStr = br.readLine();
            String maxStr = minStr;

            for (int i = 1; i < n; i++) {
                String currentStr = br.readLine();
                if (currentStr.length() > maxStr.length()) {
                    maxStr = currentStr;
                }

                String longerStr = currentStr.length() > minStr.length() ? currentStr : minStr;
                String shorterStr = currentStr.length() > minStr.length() ? minStr : currentStr;
                minStr = shorterStr;

                int longerStrIndex = longerStr.length() - 1;
                for (int j = shorterStr.length() - 1; j > 0; j--) {
                    if (shorterStr.charAt(j) != longerStr.charAt(longerStrIndex)) {
                        isValid = false;
                    }
                    longerStrIndex--;
                }
            }

            if (isValid && maxStr.length() > 1) {
                bw.write("Case #" + (t + 1) + ": " + maxStr.substring(1) + "\n");
            } else {
                bw.write("Case #" + (t + 1) + ": *\n");
            }
        }
        bw.flush();
    }
}