import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int u = sc.nextInt();
            Map<Character, Integer> num2min = new HashMap<>();
            Set<Character> all = new HashSet<>(10);
            for (int i = 0; i < 10000; i++) {
                String num = sc.next();
                String str = sc.next();
                for (char ch : str.toCharArray()) {
                    all.add(ch);
                }
                if (num.length() == str.length()) {
                    char ch = str.charAt(0);
                    Integer min = num2min.get(ch);
                    if (min == null) {
                        min = 9;
                    }
                    min = Math.min(min, num.charAt(0) - '0');
                    num2min.put(ch, min);
                }
            }
            Map<Integer, Character> int2ch = new HashMap<>(10);
            for (Character ch : num2min.keySet()) {
                int2ch.put(num2min.get(ch), ch);
            }
            all.removeAll(num2min.keySet());
            int2ch.put(0, all.iterator().next());
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<=9;i++) {
                sb.append(int2ch.get(i));
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
