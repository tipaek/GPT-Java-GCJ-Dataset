
import java.util.*;

public class Solution {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        char[] res = new char[10];

        List<String> list = new ArrayList<>();

        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            sc.nextInt();
            for (int j = 0; j < 10000; j++) {
                int num = sc.nextInt();
                String str = sc.next();
                list.add(str);

                if (num <= 9 || (num <= 19 && str.length() == 2)) {
                    if (num > 9) num -= 10;
                    if (!map.containsKey(num)) {
                        map.put(num, new HashSet<>());
                    }
                    Character c = str.length() == 1 ? str.charAt(0) : str.charAt(1);
                    map.get(num).add(c);
                } else {
                    if (!map.containsKey(9)) {
                        map.put(9, new HashSet<>());
                    }
                    for (int k = 0; k < str.length(); k++) {
                        map.get(9).add(str.charAt(k));
                    }
                }
            }
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(map.get(i));
//        }

        if (!map.containsKey(0)) {
            Character zero;
            Iterator<Character> iterator = map.get(1).iterator();
            Character c1 = iterator.next();
            Character c2 = iterator.next();
            zero = list.stream().noneMatch(s -> s.startsWith(String.valueOf(c1))) ? c1 : c2;
            map.put(0, new HashSet<>());
            map.get(0).add(zero);
        }

        for (int i = 9; i > 0; i--) {
            if (map.containsKey(i) && map.containsKey(i - 1) && !map.get(i - 1).isEmpty())
                map.get(i).removeAll(map.get(i - 1));
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(map.get(i));
//        }
//        for (int i = 0; i < 10; i++) {
//            res[i] = map.get(i).iterator().next();
//        }
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