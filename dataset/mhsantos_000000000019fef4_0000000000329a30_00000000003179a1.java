import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            char[] D = new char[10];
            int U = in.nextInt();
            in.nextLine();
            List<String[]> queries = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < 4000; j++) {
                queries.add(in.nextLine().split(" "));
            }

            Set<Character> chars = new HashSet<>();
            Set<Character> first = new HashSet<>();

            outer:
            for (int x = 0; x < queries.size(); x++) {
                String[] q = queries.get(x);
                for (int k = 0; k < q[1].length(); k++) {
                    chars.add(q[1].charAt(k));
                    if (chars.size() == 10) {
                        break outer;
                    }
                }
            }

            for (int x = 0; x < queries.size(); x++) {
                String[] q = queries.get(x);
                first.add(q[1].charAt(0));
            }

            for (Character charr : chars) {
                if (!first.contains(charr)) {
                    D[0] = charr;
                    break;
                }
            }

            queries.sort((s1, s2) -> {
                return Integer.valueOf(s1[0])-Integer.valueOf(s2[0]);
            });

            for (int x = 0; x < queries.size(); x++) {
                String[] q = queries.get(x);
                Character xx = q[1].charAt(0);
                if (q[0].length() == 2) break;
                if (q[0].equals("1")) {
                    map.put(xx, 1);
                }
                else if (q[0].equals("2") && !map.containsKey(xx)) {
                    map.put(q[1].charAt(0), 2);
                }
                else if (q[0].equals("3") && !map.containsKey(xx)) {
                    map.put(xx, 3);
                }
                else if (q[0].equals("4") && !map.containsKey(xx)) {
                    map.put(xx, 4);
                }
                else if (q[0].equals("5") && !map.containsKey(xx)) {
                    map.put(xx, 5);
                }
                else if (q[0].equals("6") && !map.containsKey(xx)) {
                    map.put(xx, 6);
                }
                else if (q[0].equals("7") && !map.containsKey(xx)) {
                    map.put(xx, 7);
                }
                else if (q[0].equals("8") && !map.containsKey(xx)) {
                    map.put(xx, 8);
                }
                else if (q[0].equals("9") && !map.containsKey(xx)) {
                    map.put(xx, 9);
                }
                else {
                    continue;
                }
            }

            for (Character key : map.keySet()) {
                D[map.get(key)] = key;
            }
            System.out.println("Case #" + i + ": " + String.valueOf(D));
        }


    }

}
