import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<String> patternList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                patternList.add(br.readLine());
            }

            String result = getCommonMatchSimple(patternList);
            if (result == null) {
                result = "*";
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static String getCommonMatchSimple(List<String> stringList) {
        stringList.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

        String basePattern = stringList.get(0).substring(1);
        for (String s : stringList) {
            String currentPattern = s.substring(1);
            int offsetIndex = basePattern.length() - currentPattern.length();

            if (!basePattern.substring(offsetIndex).equals(currentPattern)) {
                return null;
            }
        }

        return basePattern;
    }
}