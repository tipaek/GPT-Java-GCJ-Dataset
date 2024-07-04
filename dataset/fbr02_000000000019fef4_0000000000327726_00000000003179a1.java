package Gcj.s2020e1a;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution overRandomized = new Solution();
        overRandomized.solve();
    }

    Scanner sc = new Scanner(System.in);

    void solve() {
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            go(t);
        }
    }

    int M = 10000;

    private void go(int t) {
        int U = sc.nextInt();
        Map<Integer, List<Character>> qs = new HashMap<>();

        Set<Character> dec = new HashSet<>();
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int q = sc.nextInt();
            String r = sc.next();
            if (r.length() == 2) {
                seen.add(r.charAt(0));
                seen.add(r.charAt(1));
//                int q1 = q / 10;
//                int q2 = q % 10;
//                List<Character> curr1 = qs.getOrDefault(q1, new ArrayList<>());
//                List<Character> curr2 = qs.getOrDefault(q1, new ArrayList<>());
//                curr1.add(r.charAt(0));
//                curr2.add(r.charAt(1));
//                qs.put(q1, curr1);
//                qs.put(q2, curr2);


            } else if (q <= 10) {
                List<Character> curr1 = qs.getOrDefault(q, new ArrayList<>());
                curr1.add(r.charAt(0));
                qs.put(q, curr1);
            } else {
//                int q1 = q;
//                for (int j = 4; j < Math.min(q1, 10); j++) {
//                    List<Character> curr1 = qs.getOrDefault(j, new ArrayList<>());
//                    curr1.add(r.charAt(0));
//                    qs.put(j, curr1);
//                }
            }
        }


        char[] ass = new char[11];
        for (int i = 1; i < 11 ; i++) {
            List<Character> characters = qs.get(i);
            for(char curr : characters) {
                if (!dec.contains(curr))  {
                    ass[i] = curr;
                    dec.add(curr);
                    break;
                }
            }
        }

        for (char d : seen) {
            if (!dec.contains(d)) {
                ass[0] = d;
            }
        }

        String res = "";

        for (int i = 0; i < 10; i++) {
            res += ass[i];

        }
        System.out.println("Case #" + (t + 1) + ": " + res);
    }

}
