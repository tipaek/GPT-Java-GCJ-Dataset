import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                int U = sc.nextInt();
                Map<Character, Integer> map = new HashMap<>();
                Set<Character> set = new HashSet<>();

                for (int i = 0; i < Math.pow(10, 4); i++) {
                    String M = sc.next().trim();
                    String R = sc.next().trim();
                    
                    if (M.equals("-1") || M.length() != R.length()) {
                        continue;
                    }

                    if (set.size()!=10) {
                        for (char c : R.toCharArray()) {
                            set.add(c);
                        }
                    }


                    char x = R.charAt(0);
                    int y = M.charAt(0) - '0';
                    if (map.containsKey(x)) {
                        if (map.get(x) > y) {
                            map.put(x, y);
                        }
                    } else {
                        map.put(x, y);
                    }
                }
                System.out.println("Case #"+t+": "+formAns(map, set));
            }
        }
    }

    private static String formAns(Map<Character, Integer> map, Set<Character> set) {
        Map<Integer, Character> map1 = new HashMap<>();

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            map1.put(entry.getValue(), entry.getKey());
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (Character c: set) {
            if(!map.containsKey(c)){
                stringBuilder.append(c);
                break;
            }
        }

        for (int i=1; i<=9; i++){
            stringBuilder.append(map1.get(i));
        }
        return stringBuilder.toString();
    }
}
