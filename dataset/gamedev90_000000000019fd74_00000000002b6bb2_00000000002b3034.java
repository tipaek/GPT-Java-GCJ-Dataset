
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
            while (n-- > 0) {
                String s = br.readLine();
                patternList.add(s);
            }
            String result = getCommonMatchSimple(patternList);
            String finalResult = result == null ? "*" : result;
            System.out.println("Case #" + (offset - t) + ": " + finalResult);
        }
    }

    private static String getCommonMatchSimple(List<String> stringList) {
        Collections.sort(stringList, new Comparator<String>() {
            public int compare(String time1, String time2) {
                return -(time1.length() - time2.length());
            }
        });
        Map<Character, Boolean> seenChars = new HashMap<>();
        String result = stringList.get(0).substring(1);
        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i).substring(1);
            int offsetIndex = result.length() - s.length();
            String t = result.substring(offsetIndex);
//            if (offsetIndex != 0 && i == 0) {
//                String t = s.substring(offsetIndex);
//                for (int i = 0; i < t)
//            }
            if (!t.equals(s)) {
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
