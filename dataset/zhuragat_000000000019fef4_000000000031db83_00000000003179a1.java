import java.util.*;

public class Solution {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        char[] res = new char[10];

        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            sc.nextInt();
            for (int j = 0; j < 10000; j++) {
                int num = sc.nextInt();
                String str = sc.next();
                if (num <= 9 || (num <= 18 && str.length() == 2)) {
                    if (num > 9) num -= 10;
                    if (!map.containsKey(num)) {
                        map.put(num, new HashSet<>());
                    }
                    Character c = str.length() == 1 ? str.charAt(0) : str.charAt(1);
                    map.get(num).add(c);
                }
            }
        }
        Set<Character> deleted = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            map.get(i).removeAll(deleted);
            res[i] = map.get(i).iterator().next();
            deleted.add(res[i]);
        }
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + t + ": " + String.valueOf(res));
        }
    }
}