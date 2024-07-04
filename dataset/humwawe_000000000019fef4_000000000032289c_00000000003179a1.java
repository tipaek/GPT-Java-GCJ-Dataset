import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author hum
 */
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %s";
        for (int cas = 1; cas <= n; cas++) {
            String u = sc.next();
            boolean[] al = new boolean[26];
            int[] count = new int[26];
            for (int i = 0; i < 10000; i++) {
                String ignore = sc.next();
                String s = sc.next();
                Set<Character> set = new HashSet<>();
                for (int j = 0; j < s.length(); j++) {
                    count[s.charAt(j) - 'A']++;
                    if (j == 0) {
                        al[s.charAt(j) - 'A'] = true;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0 && !al[i]) {
                    stringBuilder.append((char) (i + 'A'));
                    count[i] = 0;
                    break;
                }
            }
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    list.add(new int[]{i, count[i]});
                }
            }
            list.sort((a, b) -> b[1] - a[1]);
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append((char) (list.get(i)[0] + 'A'));
            }
            System.out.println(String.format(result, cas, stringBuilder.toString()));
        }
    }
}
