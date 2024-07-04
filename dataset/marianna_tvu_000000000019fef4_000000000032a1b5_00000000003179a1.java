
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        int x = 10_000;
        for (int i = 0; i < numTests; i++) {
            int base = sc.nextInt();
            int max = (int) (Math.pow(10, base + 1) - 1);
            Map<Character, Integer> minSeen = new HashMap<>();
            Map<Integer, Character> ordered = new TreeMap<>();
            for (int j = 0; j < x; j++) {
                int Qi = sc.nextInt();
                String s = sc.next();
                int first = Qi / 10;
                int second = 9;
                if (s.length() == 2) {
                    if (first >= 1) {
                        if (!minSeen.containsKey(s.charAt(0)) || minSeen.get(s.charAt(0)) > first) {
                            minSeen.put(s.charAt(0), first);
                            ordered.put(first, s.charAt(0));
                        }
                        if (!minSeen.containsKey(s.charAt(1)) || minSeen.get(s.charAt(1)) > second) {
                            minSeen.put(s.charAt(1), second);
                            ordered.put(second, s.charAt(1));
                        }
                    } else {
                        if (!minSeen.containsKey(s.charAt(0)) || minSeen.get(s.charAt(0)) > second) {
                            minSeen.put(s.charAt(0), second);
                            ordered.put(second, s.charAt(0));
                        }
                    }
                } else {
                    if (!minSeen.containsKey(s.charAt(0)) || minSeen.get(s.charAt(0)) > 9) {
                        minSeen.put(s.charAt(0), 9);
                        ordered.put(9, s.charAt(0));
                    }
                }
            }
            check(i + 1, minSeen, ordered, x);
        }
    }

    private static void check(int i, Map<Character, Integer> minSeen, Map<Integer, Character> ordered, int x) {
        StringBuilder sb = new StringBuilder();
        //        System.out.println(minSeen);

        Map<Integer, Character> o = new TreeMap<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : minSeen.entrySet()) {
            o.put(characterIntegerEntry.getValue(), characterIntegerEntry.getKey());
        }
        for (Character value : o.values()) {
            sb.append(value);
        }
        printAnsw(i, sb.toString());
    }

    private static void printAnsw(int i, String res) {
        System.out.println("Case #" + i + ": " + res);
    }
}
