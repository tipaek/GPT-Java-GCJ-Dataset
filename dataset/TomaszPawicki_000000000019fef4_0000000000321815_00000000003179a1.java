import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int u = sc.nextInt();
            Map<Character, Integer> num2min = new HashMap<>();
            Map<Character, Integer> num2count = new HashMap<>();
            Set<Character> all = new HashSet<>(10);
            for (int i = 0; i < 10000; i++) {
                String num = sc.next();
                String str = sc.next();
                for (char ch : str.toCharArray()) {
                    all.add(ch);
                }
                if("-1".equals(num)) {
                    char ch = str.charAt(0);
                    Integer count = num2count.get(ch);
                    if(count == null) {
                        count = 0;
                    }
                    num2count.put(ch, count + 1);
                } else {
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
            }
            Map<Integer, Character> int2ch = new HashMap<>(10);

            for (Character ch : num2min.keySet()) {
                int2ch.put(num2min.get(ch), ch);
            }
            if(num2count.size() > 0) {
                List<Character> list = new ArrayList<>(9);
                list.addAll(num2count.keySet());
                Collections.sort(list, (a, b) -> {
                    return -num2count.get(a).compareTo(num2count.get(b));
                });
                for(int i=1;i<=9;i++) {
                    int2ch.put(i, list.get(i-1));
                }
            }
            all.removeAll(num2min.keySet());
            all.removeAll(num2count.keySet());
            int2ch.put(0, all.iterator().next());
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<=9;i++) {
                sb.append(int2ch.get(i));
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
