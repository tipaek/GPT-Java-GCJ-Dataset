

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/overrand/input.txt"))));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int nr = 1; nr <= t; nr++) {
            solve(in, nr);
        }
    }

    private static void solve(Scanner in, int nr) {
        int u = in.nextInt();

        Map<Character, Set<Integer>> map = new HashMap<>();

        String[] m = new String[10000];
        String[] r = new String[10000];

        for (int k = 0; k < 10000; k++) {
            m[k] = in.next();
            r[k] = in.next();
        }

        while (!done(map)) {
            for (int k = 0; k < 10000; k++) {
                //String str = in.next();

                //System.out.println(m + " " + r);

                if (m[k].equals("-1")) {
                    for (int i = 1; i < r[k].length(); i++) {
                        if (!map.containsKey(r[k].charAt(i))) {
                            updateChMap(map, r[k].charAt(i), 0, 9);
                            optimise(map);
                        }
                    }

                    rmv(map, r[k].charAt(0), 0);
                } else {

                    if (m[k].length() == r[k].length()) {
                        updateChMap(map, r[k].charAt(0), 1, m[k].charAt(0) - '0');
                        //updateChMap(map, r.charAt(r.length() - 1), 0, 9);

                        for (int i = 1; i < r[k].length(); i++) {
                            if (!map.containsKey(r[k].charAt(i))) {
                                updateChMap(map, r[k].charAt(i), 0, 9);
                            }
                        }
                    } else {
                        for (int i = 0; i < r[k].length(); i++) {
                            if (!map.containsKey(r[k].charAt(i))) {
                                updateChMap(map, r[k].charAt(i), 0, 9);
                            }
                        }
                    }
                }
            }

            optimise(map);
        }

        char[] q = new char[10];

        for (Character c : map.keySet()) {
            //System.out.print(c + " : ");
            Set<Integer> set = map.get(c);

            /*for (int i : set) {
                System.out.print(i + " ");
            }
            System.out.println();*/

            if (set.size() == 1) q[set.iterator().next()] = c;
        }

        System.out.print("Case #" + nr + ": ");
        for (int i = 0; i < 10; i++) {
            System.out.print(q[i]);
        }
        System.out.println();
    }

    private static void updateChMap(Map<Character, Set<Integer>> map, char c, int a, int b) {
        //System.out.println(c + " " + a + " " + b);

        Set<Integer> st = rangeSet(a, b);

        if (st.size() == 1) {
            int k = st.iterator().next();

            //System.out.println("** " + k);
            rmv(map, c, k);
        }

        if (!map.containsKey(c)) {
            map.put(c, st);
        } else {
            Set<Integer> s = map.get(c);

            s.retainAll(st);

            if (s.size() == 1) {
                int k = s.iterator().next();

                //System.out.println("!! " + k);
                rmv(map, c, k);
            }
        }
    }

    private static void rmv(Map<Character, Set<Integer>> map, char ch, int x) {
        //System.out.println(ch + " " + x);
        for (Character c : map.keySet()) {
            if (c != ch) {
                Set<Integer> st = map.get(c);
                st.remove(x);

                /*if (st.size() == 1) {
                    int k = st.iterator().next();

                    //System.out.println("** " + k);
                    rmv(map, c, k);
                }*/
            }
        }
    }

    private static Set<Integer> rangeSet(int a, int b) {
        Set<Integer> st = new HashSet<>();

        for (int i = a; i <= b; i++) st.add(i);

        return st;
    }

    private static boolean done(Map<Character, Set<Integer>> map) {
        if (map.isEmpty()) return false;
        for (char c : map.keySet()) {
            Set<Integer> set = map.get(c);

            if (set.size() != 1) return false;
        }

        return true;
    }

    private static void optimise(Map<Character, Set<Integer>> map) {
        for (char c : map.keySet()) {
            Set<Integer> set = map.get(c);

            if (set.size() == 1) rmv(map, c, set.iterator().next());
        }
    }
}
