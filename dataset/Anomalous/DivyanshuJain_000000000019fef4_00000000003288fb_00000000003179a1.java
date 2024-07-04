import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int x = 1; x <= T; x++) {
            int U = sc.nextInt();
            long[] digit = new long[26];
            Arrays.fill(digit, 10);

            for (int i = 1; i <= 10000; i++) {
                long q = sc.nextLong();
                String s = sc.next().trim();
                int l = s.length();
                char ch = s.charAt(0);

                if (l == 1) {
                    if (q < 10 && digit[ch - 'A'] > q) {
                        digit[ch - 'A'] = q;
                    }
                } else {
                    long r = q / (long) Math.pow(10, U - 1);
                    if (digit[ch - 'A'] > r) {
                        digit[ch - 'A'] = r;
                    }
                    if (q == 10) {
                        char c = s.charAt(1);
                        digit[c - 'A'] = 0;
                    }
                }
            }

            Map<Character, Long> map = new HashMap<>();
            for (int k = 0; k < 26; k++) {
                if (digit[k] < 10) {
                    map.put((char) (k + 'A'), digit[k]);
                }
            }

            List<Map.Entry<Character, Long>> list = new LinkedList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());

            System.out.print("Case #" + x + ": ");
            for (Map.Entry<Character, Long> entry : list) {
                System.out.print(entry.getKey());
            }
            System.out.println();
        }
    }
}