import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int U = in.nextInt();
            String result = "";
            Map<Character, Integer> charMap = new HashMap();
            for (int i = 0; i < 10000; i++) {
                String query = in.next();
                char[] answer = in.next().toCharArray();
                for (int j = 0; j < answer.length; j++) {
                    char c = answer[j];
                    if (charMap.containsKey(c)) {
                        charMap.put(c, charMap.get(c) + 1);
                    } else {
                        charMap.put(c, 1);
                    }
                }
            }
            
            int min = 20000;
            char c0 = 'c';
            for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char c = entry.getKey();
                if (charMap.get(c) < min) {
                    min = charMap.get(c);
                    c0 = c;
                }
            }
            
            result += c0;
            charMap.put(c0, -1);
            
            for (int i = 0; i < 9; i++) {
                int max = -1;
                char maxChar = 'c';
                for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                    char c = entry.getKey();
                    if (charMap.get(c) > max) {
                        max = charMap.get(c);
                        maxChar = c;
                    }
                }
                result += maxChar;
                charMap.put(maxChar, -1);
            }
            System.out.println("Case #" + caseNum +": " + result);
        }
    }
}