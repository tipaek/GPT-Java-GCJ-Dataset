
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int offset = t;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<String> patternList = new ArrayList<>();
            List<String> secondPatternList = new ArrayList<>();
            while (n-- > 0) {
                String s = br.readLine();
                String[] ls = s.split("\\*");
                if (ls.length == 0) {
                    patternList.add("");
                    secondPatternList.add("");
                } else if (ls.length == 1 && s.charAt(0) != '*') {
                    patternList.add(ls[0]);
                    secondPatternList.add("");
                } else if (ls.length == 1) {
                    patternList.add("");
                    secondPatternList.add(ls[0]);
                } else {
                    patternList.add(ls[0]);
                    secondPatternList.add(ls[1]);
                }

            }
            String result1 = getCommonMatchSimple(patternList, true);
            String result = getCommonMatchSimple(secondPatternList, false);
            String finalResult = "*";
            if (result != null && result1 != null) {
                finalResult = result1 + result;
            }
            System.out.println("Case #" + (offset - t) + ": " + finalResult);
        }
    }

    private static String getCommonMatchSimple(List<String> stringList, Boolean last) {
        Collections.sort(stringList, new Comparator<String>() {
            public int compare(String time1, String time2) {
                return -(time1.length() - time2.length());
            }
        });
        Map<Character, Boolean> seenChars = new HashMap<>();
        String result = stringList.get(0);
        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);

            String t = "";
            if (last) {
                t = result.substring(0, s.length());
            } else {
                int offsetIndex = result.length() - s.length();
                t = result.substring(offsetIndex);
            }
//            if (offsetIndex != 0 && i == 0) {
//                String t = s.substring(offsetIndex);
//                for (int i = 0; i < t)
//            }
            if (i != 0 && !t.equals(s)) {
                return null;
            }

//            for (int j = 0; j < s.length(); j++) {
//                Character c = s.charAt(j);
//                if (i != 0 && !seenChars.getOrDefault(c, false)) {
//                    return null;
//                } else if (i != 0) {
//                    int offsetIndex = result.length() - s.length();
//
//                } else if (i == 0) {
//                    seenChars.putIfAbsent(c, true);
//                }
//            }
        }
        return result;
    }
}
