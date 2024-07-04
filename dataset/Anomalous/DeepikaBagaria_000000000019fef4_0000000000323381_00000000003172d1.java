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

            Map<Long, Integer> frequencyMap = new HashMap<>();
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                Long x = Long.parseLong(str.nextToken());
                frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
            }

            int result = d - 1;

            if (d == 2) {
                for (int count : frequencyMap.values()) {
                    if (count >= 2) {
                        result = 0;
                        break;
                    }
                }
            } else if (d == 3) {
                for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                    Long key = entry.getKey();
                    int count = entry.getValue();

                    if (key != 0 && key % 2 == 0 && frequencyMap.containsKey(key / 2)) {
                        result = 1;
                    }
                    if (count == 2) {
                        for (Long otherKey : frequencyMap.keySet()) {
                            if (otherKey > key) {
                                result = 1;
                                break;
                            }
                        }
                    }
                    if (count >= 3) {
                        result = 0;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (tt + 1) + ": " + result);
        }
    }
}