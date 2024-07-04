import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {

            System.out.print("Case #" + num + ": ");

            int u = in.nextInt();

            Map<Character, Set<Integer>> map = new HashMap<>();
            Map<Integer, Character> soulution = new HashMap<>();

            long n = (long) Math.pow(10, 4);
            for (int i = 1; i <= n; i++) {
                int q = in.nextInt();
                String r = in.next();

                if (r.length() == 1) {
                    char c = r.charAt(0);
                    Set<Integer> possibles = map.computeIfAbsent(c, (k) -> getNew(k));
                    possibles.remove(0);
                    strip(q, possibles);
                }
                if (r.length() == String.valueOf(q).length() ) {
                    String qStr = String.valueOf(q);
                    char c = r.charAt(0);
                    Set<Integer> possibles = map.computeIfAbsent(c, (k) -> getNew(k));
                    possibles.remove(0);
                    strip(Integer.parseInt(String.valueOf(qStr.charAt(0))), possibles);

                    int ind1 = 0;
                    while (ind1 < qStr.length() && get(ind1, q) != 1) {
                        ind1++;
                    }

                    ind1++;
                    if (ind1 > 0 && ind1 < qStr.length()) {
                        c = r.charAt(ind1);
                        possibles = map.computeIfAbsent(c, (k) -> getNew(k));
                        strip(get(ind1, q), possibles);
                    }
                }

                map.forEach((k, v) -> {
                    if (v.size() == 1) {
                        soulution.put(v.iterator().next(), k);
                    }
                });

                map.forEach((k,v) -> soulution.keySet().forEach(s -> v.remove(s)));
            }

//            map.forEach((k, v) -> {
//                System.out.print(k + " ---- ");
//                v.forEach(d -> System.out.print(d + ","));
//                System.out.println();
//            });

            for(int i = 0; i<=9; i++) {
                System.out.print(soulution.get(i));
            }
            System.out.println();
        }
    }

    private static int get(int index, int target) {
        return Integer.parseInt(String.valueOf(target).substring(index, index+1));
    }

    private static void strip(int q, Set<Integer> possibles) {
        if (q < 9) {
            for(int x = q + 1; x <= 9; x++) {
                possibles.remove(x);
            }
        }
    }

    public static Set<Integer> getNew(char c) {
//        System.out.println(c);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        return set;
    }
}
