import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

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
                
                if (a < 10) {
                    map.merge(b.charAt(0), a, Math::min);
                } else {
                    String s = Long.toString(a);
                    if (b.length() == s.length()) {
                        a /= 10;
                        map.merge(b.charAt(0), a, Math::min);
                        map.putIfAbsent(b.charAt(1), 100L);
                    }
                }
            }
            
            char[] arr = new char[10];
            for (Entry<Character, Long> entry : map.entrySet()) {
                char key = entry.getKey();
                long pos = entry.getValue();
                if (pos < 10) {
                    arr[(int) pos] = key;
                } else {
                    arr[0] = key;
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : arr) {
                result.append(c);
            }
            System.out.println("Case #" + (tt + 1) + ": " + result);
        }
    }
}