

import java.io.*;
import java.util.*;

public class Solution {

//    public static void main(String[] args) {
////        try {
////            //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
////            Scanner in = new Scanner(new File("C:\\Files\\Projects\\CodeJam\\out\\production\\CodeJam\\in.txt"));
////
////            int t = in.nextInt();
////            for (int i = 1; i <= t; i++) {
////                solve(i, in);
////            }
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////    }

    public static void main(String[] args) {
//        try {
//            Scanner in = new Scanner(new File("C:\\Files\\Projects\\CodeJam\\out\\production\\CodeJam\\in.txt"));
//
//            solve(0, in);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int maxNum = 0;
    private static HashMap<Integer, ArrayList<Pair>> map = new HashMap<>(); // val -> path
    private static HashSet<Pair> visited = new HashSet<>(); // val -> path
    private static ArrayList<Pair> path = new ArrayList<>();
    private static int[][] triangle;
    private static int foundSolutions = 0;

    private static void solve(int caseNum, Scanner in) {
        int n = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num > maxNum)
                maxNum = num;
            map.put(num, new ArrayList<>());
            nums[i] = num;
        }

        triangle = new int[500][];

        dfs(0, 0, 0, 0);

        for (int i = 0; i < nums.length; i++) {
            List<Pair> path = map.get(nums[i]);
            print(i+1);
            for (Pair p : path) {
                System.out.println((p.v1+1) + " " + (p.v2+1));
            }
        }
    }

    private static void dfs(int r, int c, int sum, int step) {
        if (foundSolutions >= map.size())
            return;

        if (r < 0 || r > triangle.length || c < 0)
            return;
        if (triangle[r] == null)
            triangle[r] = new int[r+1];
        if (c > triangle[r].length)
            return;
        step++;
        if (step > 500)
            return;

        process(r, c);


        sum += triangle[r][c];
        if (sum > maxNum)
            return;
        Pair pair = new Pair(r, c);
        path.add(pair);
        visited.add(pair);

        if (map.containsKey(sum)) {
            ArrayList<Pair> plist = map.get(sum);
            if (plist.size() == 0) {
                foundSolutions++;
                for (Pair p : path) {
                    plist.add(p);
                }
            }
        }

        if (step % 2 == 0) {
            dfs(r+1, c+0, sum, step);
            dfs(r+1, c+1, sum, step);
        } else {
            dfs(r+1, c+1, sum, step);
            dfs(r+1, c+0, sum, step);
        }
        dfs(r+0, c+1, sum, step);
        dfs(r+0, c-1, sum, step);
        dfs(r-1, c-1, sum, step);
        dfs(r-1, c+0, sum, step);

        visited.remove(pair);
        path.remove(path.size()-1);
    }

    private static void process(int r, int c) {
        if (triangle[r][c] == 0) {
            if (c == 0 || c == triangle[r].length-1) {
                triangle[r][c] = 1;
            } else {
                process(r-1, c);
                process(r-1, c-1);
                triangle[r][c] = triangle[r-1][c] + triangle[r-1][c-1];
            }
        }
    }

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
