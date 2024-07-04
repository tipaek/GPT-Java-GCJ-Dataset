import java.io.*;
import java.util.*;

public class Solution {
    static boolean debug = false;
    public static void main(String args[]) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        if (debug) {
            File file = new File("test.in");
            reader = new FileReader(file);
        }
        BufferedReader in = new BufferedReader(reader);
        int            t  = Integer.parseInt(in.readLine());
        for (int tt = 1; tt <= t; tt++) {
            int                       u   = Integer.parseInt(in.readLine());
            int[]                     q   = new int[10000];
            String[]                  r   = new String[10000];
            Map<Character, Integer>   map = new HashMap<>();
            Map<Integer, Map<String, Integer>> m   = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                String[] tmp = in.readLine().split(" ");
                q[i] = Integer.parseInt(tmp[0]);
                r[i] = tmp[1];
                Map<String, Integer> set = m.getOrDefault(r[i].length(), new HashMap<>());
                int v = set.getOrDefault(r[i], 0) + 1;
                set.put(r[i], v);
                m.put(r[i].length(), set);
                for (Character c : r[i].toCharArray()) {
                    map.put(c, -1);
                }
            }
            findSolution(tt, u, q, r, map, m);
        }
    }
    
    public static void findSolution(int index, int u, int[] q, String[] r, Map<Character, Integer>     map,  Map<Integer, Map<String, Integer>> m) {
        char zero = 'A';
        Map<String, Integer> mm = m.get(2);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            boolean isZero = true;
            for (String s: mm.keySet()) {
                if (s.charAt(0) == key) {
                    isZero = false;
                }
            }
            if (isZero) {
                entry.setValue(0);
                zero = entry.getKey();
                break;
            }
        }
        Set<Character> tmp = new HashSet<>();
        tmp.add(zero);
        for (int i = 1; i <=9; i++) {
            int max = 0;
            char c = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char key = entry.getKey();
                if (tmp.contains(key)) {
                    continue;
                }
                String s = Character.toString(key) + Character.toString(zero);
                if (max < mm.get(s)) {
                    max = mm.get(s);
                    c = key;
                }
            }
            map.put(c, i);
            tmp.add(c);
        }
        char[] tmpc = new char[10];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            tmpc[entry.getValue()] = entry.getKey();
        }
        String result = new String(tmpc);
        System.out.println("Case #" + index + ": " + result);
    }
}