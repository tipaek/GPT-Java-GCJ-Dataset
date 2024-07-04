import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 1; t <= T; t++) {
            in.next();
            Integer[] cnt = new Integer[26];
            for(int i = 0; i < 26; i++) cnt[i] = new Integer(0);
            for(int i = 0; i < 10000; i++) {
                in.next();
                char[] str = in.next().toCharArray();
                for(int j = 0; j < str.length; j++) {
                    cnt[(int)str[j] - (int)'A']++;
                }
            }
            
            HashMap<Integer, Character> map = new HashMap<>();
            for(int i = 0; i < 26; i++) {
                map.put(cnt[i], (char)(i + 'A'));
            }

            Arrays.sort(cnt, Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();

            sb.append(map.get(cnt[9]));

            for(int i = 0; i < 9; i++) {
                sb.append(map.get(cnt[i]));
            }

            System.out.printf("Case #%d: %s\n", t, sb);
        }
    }
}
