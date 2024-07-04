import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int tt = 0; tt < t; tt++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            Map<Character, Long> map = new HashMap<>();
            
            for (int x = 1; x <= 10000; x++) {
                str = new StringTokenizer(br.readLine());
                long a = Long.parseLong(str.nextToken());
                String b = str.nextToken();
                
                char firstChar = b.charAt(0);
                if (a < 10) {
                    map.putIfAbsent(firstChar, a);
                    if (map.get(firstChar) > a) {
                        map.put(firstChar, a);
                    }
                } else {
                    String aStr = Long.toString(a);
                    if (b.length() == aStr.length()) {
                        a /= 10;
                        map.putIfAbsent(firstChar, a);
                        if (map.get(firstChar) > a) {
                            map.put(firstChar, a);
                        }
                        char secondChar = b.charAt(1);
                        map.putIfAbsent(secondChar, 100L);
                    }
                }
            }
            
            char[] arr = new char[10];
            for (Map.Entry<Character, Long> entry : map.entrySet()) {
                char key = entry.getKey();
                long value = entry.getValue();
                if (value < 10) {
                    arr[(int) value] = key;
                } else {
                    arr[0] = key;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (char c : arr) {
                result.append(c);
            }
            
            System.out.println("Case #" + (tt + 1) + ": " + result.toString());
        }
    }
}