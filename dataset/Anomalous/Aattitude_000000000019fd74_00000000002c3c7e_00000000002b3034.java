import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> strings = new ArrayList<>();

            String maxLengthString = br.readLine();
            strings.add(maxLengthString);

            for (int i = 1; i < n; i++) {
                String currentString = br.readLine();
                strings.add(currentString);
                if (currentString.length() > maxLengthString.length()) {
                    maxLengthString = currentString;
                }
            }

            boolean isSuffix = true;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    String str1 = strings.get(i);
                    String str2 = strings.get(j);
                    String longerString = str1.length() > str2.length() ? str1 : str2;
                    String shorterString = str1.length() > str2.length() ? str2 : str1;

                    int longerIndex = longerString.length() - 1;
                    for (int k = shorterString.length() - 1; k >= 0; k--) {
                        if (shorterString.charAt(k) != longerString.charAt(longerIndex)) {
                            isSuffix = false;
                            break;
                        }
                        longerIndex--;
                    }
                    if (!isSuffix) break;
                }
                if (!isSuffix) break;
            }

            if (isSuffix && maxLengthString.length() > 1) {
                bw.write("Case #" + (t + 1) + ": " + maxLengthString.substring(1) + "\n");
            } else {
                bw.write("Case #" + (t + 1) + ": *\n");
            }
        }
        bw.flush();
    }
}