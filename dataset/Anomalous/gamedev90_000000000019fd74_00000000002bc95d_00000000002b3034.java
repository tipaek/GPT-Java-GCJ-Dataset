import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = t;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<String> prefixList = new ArrayList<>();
            List<String> suffixList = new ArrayList<>();

            while (n-- > 0) {
                String s = br.readLine();
                String[] parts = s.split("\\*");

                if (parts.length == 0) {
                    prefixList.add("");
                    suffixList.add("");
                } else if (parts.length == 1) {
                    if (s.charAt(0) != '*') {
                        prefixList.add(parts[0]);
                        suffixList.add("");
                    } else {
                        prefixList.add("");
                        suffixList.add(parts[0]);
                    }
                } else {
                    prefixList.add(parts[0]);
                    suffixList.add(parts[1]);
                }
            }

            String commonPrefix = findCommonSubstring(prefixList, true);
            String commonSuffix = findCommonSubstring(suffixList, false);
            String finalResult = "*";

            if (commonPrefix != null && commonSuffix != null) {
                finalResult = commonPrefix + commonSuffix;
            }
            
            System.out.println("Case #" + (caseNumber - t) + ": " + finalResult);
        }
    }

    private static String findCommonSubstring(List<String> stringList, boolean isPrefix) {
        stringList.sort((str1, str2) -> Integer.compare(str2.length(), str1.length()));

        String reference = stringList.get(0);
        for (int i = 1; i < stringList.size(); i++) {
            String current = stringList.get(i);
            String comparisonPart;

            if (isPrefix) {
                comparisonPart = reference.substring(0, current.length());
            } else {
                comparisonPart = reference.substring(reference.length() - current.length());
            }

            if (!comparisonPart.equals(current)) {
                return null;
            }
        }
        return reference;
    }
}