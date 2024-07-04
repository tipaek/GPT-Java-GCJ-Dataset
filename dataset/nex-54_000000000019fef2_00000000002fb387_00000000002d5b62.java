

import java.io.*;
import java.util.*;

public class Solution {

    private static boolean debug = false;
    public static void main(String[] args) {
        try {
            Scanner in;
            if (debug)
                in = new Scanner(new File("C:\\Files\\Projects\\CodeJam\\out\\production\\CodeJam\\in.txt"));
            else
                in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int t = in.nextInt();
            HashMap<Pair, String> map = new HashMap<>();
            ArrayList<Pair> order = new ArrayList<>();
            for (int i = 1; i <= t; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Pair p = new Pair(x, y);
                order.add(p);
                map.put(p, "IMPOSSIBLE");
                dfs(0, 0, 1, map, new StringBuilder());
            }
            for (int i = 0; i < order.size(); i++) {
                print(i, map.get(order.get(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int x, int y, int nextJump, HashMap<Pair, String> map, StringBuilder path) {
        if (x < -100 || x > 100 || y < -100 || y > 100)
            return;
        Pair p = new Pair(x, y);
        if (map.containsKey(p)) {
            String have = map.get(p);
            if (have.equals("IMPOSSIBLE") || have.length() > path.length())
            map.put(p, path.toString());
        }
        int nextNextJump = nextJump * 2;
        path.append('N');
        dfs(x, y + nextJump, nextNextJump, map, path);
        path.deleteCharAt(path.length()-1);

        path.append('S');
        dfs(x, y - nextJump, nextNextJump, map, path);
        path.deleteCharAt(path.length()-1);

        path.append('W');
        dfs(x - nextJump, y, nextNextJump, map, path);
        path.deleteCharAt(path.length()-1);

        path.append('E');
        dfs(x + nextJump, y, nextNextJump, map, path);
        path.deleteCharAt(path.length()-1);
    }

//    private static void solve(int caseNum, Scanner in) {
//
//        print(caseNum, "IMPOSSIBLE " + n);
//    }

    private static void print(int caseNum, int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int r: result) {
            sb.append(" ");
            sb.append(r);
        }
        print(caseNum, sb);
    }

    private static void print(int caseNum, StringBuilder result) {
        print(caseNum, result.toString());
    }

    private static void print(int caseNum, String result) {
        System.out.println("Case #" + caseNum + ": " + result);
    }

    private static void print(int caseNum) {
        System.out.println("Case #" + caseNum + ":");
    }

    private static class Pair {
        int v1;
        int v2;

        public Pair(int v1, int v2){ this.v1 = v1; this.v2 = v2; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return v1 == pair.v1 &&
                    v2 == pair.v2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v1, v2);
        }
    }
}
