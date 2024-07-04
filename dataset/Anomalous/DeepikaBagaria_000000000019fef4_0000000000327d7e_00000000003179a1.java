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
            Map<Character, Integer> map = new HashMap<>();

            for (int x = 1; x <= 10000; x++) {
                str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                String b = str.nextToken();
                char firstChar = b.charAt(0);

                if (a < 10) {
                    map.put(firstChar, Math.min(map.getOrDefault(firstChar, a), a));
                } else {
                    if (b.length() > 1) {
                        a /= 10;
                        map.put(firstChar, Math.min(map.getOrDefault(firstChar, a), a));
                        char secondChar = b.charAt(1);
                        map.putIfAbsent(secondChar, 100);
                    }
                }
            }

            char[] arr = new char[10];
            for (Entry<Character, Integer> entry : map.entrySet()) {
                char key = entry.getKey();
                int pos = entry.getValue();
                if (pos < 10) {
                    arr[pos] = key;
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