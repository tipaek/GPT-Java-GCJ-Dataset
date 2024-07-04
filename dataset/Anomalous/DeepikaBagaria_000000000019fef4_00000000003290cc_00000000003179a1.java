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
            Map<Character, Integer> map = new HashMap<>();

            for (int x = 1; x <= 10000; x++) {
                str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                String b = str.nextToken();
                char firstChar = b.charAt(0);

                if (a < 10) {
                    map.putIfAbsent(firstChar, a);
                    map.computeIfPresent(firstChar, (k, v) -> Math.min(v, a));
                } else {
                    String s = Integer.toString(a);
                    if (b.length() == s.length()) {
                        a /= 10;
                        map.putIfAbsent(firstChar, a);
                        map.computeIfPresent(firstChar, (k, v) -> Math.min(v, a));

                        char secondChar = b.charAt(1);
                        map.putIfAbsent(secondChar, 100);
                    }
                }
            }

            char[] arr = new char[10];
            map.forEach((key, value) -> {
                if (value < 10) {
                    arr[value] = key;
                } else {
                    arr[0] = key;
                }
            });

            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }

            System.out.println("Case #" + (tt + 1) + ": " + sb.toString());
        }
    }
}