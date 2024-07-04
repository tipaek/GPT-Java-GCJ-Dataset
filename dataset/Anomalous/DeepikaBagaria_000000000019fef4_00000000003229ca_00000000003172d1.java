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
            int n = Integer.parseInt(str.nextToken());
            int d = Integer.parseInt(str.nextToken());
            Map<Long, Integer> map = new HashMap<>();

            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                Long x = Long.parseLong(str.nextToken());
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            int ans = d - 1;
            if (d == 2) {
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= 2) {
                        ans = 0;
                        break;
                    }
                }
            } else if (d == 3) {
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    Long key = entry.getKey();
                    if (key % 2 == 0 && map.containsKey(key / 2)) {
                        ans = 1;
                    }
                    if (entry.getValue() >= 3) {
                        ans = 0;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (tt + 1) + ": " + ans);
        }
    }
}