import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(br);
        }
    }

    public static void solve(BufferedReader br) throws Exception {
        int U = Integer.parseInt(br.readLine());

        Query[] queries = new Query[10000];
        for (int i = 0; i < queries.length; i++) {
            String[] input = br.readLine().split(" ");
            queries[i] = new Query(Integer.parseInt(input[0]), input[1]);
        }

        Arrays.sort(queries);

        HashSet<Character>[] digitSets = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            digitSets[i] = new HashSet<>();
        }

        HashMap<Character, int[]> rangeMap = new HashMap<>();
        HashSet<Character> distinctChars = new HashSet<>();

        for (Query query : queries) {
            String M = String.valueOf(query.M);
            String R = query.R;

            boolean sameLength = R.length() == M.length();
            boolean mone = (String.valueOf(query.M - 1)).length() < M.length();

            if (sameLength) {
                boolean nonZero = false;
                for (int p = 0; p < R.length(); p++) {
                    int l = (p == 0) ? 1 : 0;
                    int r = nonZero ? 9 : M.charAt(p) - '0';
                    char c = R.charAt(p);
                    distinctChars.add(c);
                    rangeMap.putIfAbsent(c, new int[]{l, r});
                    int[] currentRange = rangeMap.get(c);
                    rangeMap.put(c, new int[]{Math.max(l, currentRange[0]), Math.min(currentRange[1], r)});
                    if ((p == 0 && R.charAt(p) - '0' > 1) || (p > 0 && R.charAt(p) - '0' > 0)) {
                        nonZero = true;
                    }
                }
            } else {
                for (int p = 0; p < R.length(); p++) {
                    int l = (p == 0) ? 1 : 0;
                    int r = 9;
                    char c = R.charAt(p);
                    distinctChars.add(c);
                    rangeMap.putIfAbsent(c, new int[]{l, r});
                    int[] currentRange = rangeMap.get(c);
                    rangeMap.put(c, new int[]{Math.max(l, currentRange[0]), Math.min(currentRange[1], r)});
                }
            }
        }

        HashMap<Integer, Character> digitMap = new HashMap<>();
        int completed = 0;
        while (completed < 10) {
            for (char c : distinctChars) {
                int l = rangeMap.get(c)[0];
                int r = rangeMap.get(c)[1];
                int index = -1;
                int count = 0;
                for (int i = l; i <= r; i++) {
                    if (!digitMap.containsKey(i)) {
                        count++;
                        index = i;
                    }
                }
                if (count == 1) {
                    digitMap.put(index, c);
                    completed++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(digitMap.get(i));
        }
        System.out.println();
    }

    public static class Query implements Comparable<Query> {
        int M;
        String R;

        Query(int M, String R) {
            this.M = M;
            this.R = R;
        }

        @Override
        public int compareTo(Query other) {
            return Integer.compare(this.M, other.M);
        }
    }
}