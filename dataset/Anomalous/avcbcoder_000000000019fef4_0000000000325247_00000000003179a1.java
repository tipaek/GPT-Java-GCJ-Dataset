import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
            queries[i] = new Query(Long.parseLong(input[0]), input[1]);
        }

        Arrays.sort(queries);

        HashSet<Character>[] digitSets = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            digitSets[i] = new HashSet<>();
        }

        HashMap<Character, int[]> ranges = new HashMap<>();
        HashSet<Character> distinctChars = new HashSet<>();

        for (Query query : queries) {
            String M = Long.toString(query.M);
            String R = query.R;

            boolean sameLength = R.length() == M.length();
            boolean mone = (Long.toString(query.M - 1).length() < M.length());

            if (sameLength) {
                boolean nonZeroFound = false;
                for (int p = 0; p < R.length(); p++) {
                    int l = (p == 0) ? 1 : 0;
                    int r = nonZeroFound ? 9 : M.charAt(p) - '0';
                    char c = R.charAt(p);
                    distinctChars.add(c);

                    if (ranges.containsKey(c)) {
                        int[] range = ranges.get(c);
                        ranges.put(c, new int[]{Math.max(l, range[0]), Math.min(r, range[1])});
                    } else {
                        ranges.put(c, new int[]{l, r});
                    }

                    int digit = R.charAt(p) - '0';
                    if ((p == 0 && digit > 1) || (p > 0 && digit > 0)) {
                        nonZeroFound = true;
                    }
                }
            } else {
                for (int p = 0; p < R.length(); p++) {
                    int l = (p == 0) ? 1 : 0;
                    int r = 9;
                    char c = R.charAt(p);
                    distinctChars.add(c);

                    if (ranges.containsKey(c)) {
                        int[] range = ranges.get(c);
                        ranges.put(c, new int[]{Math.max(l, range[0]), Math.min(r, range[1])});
                    } else {
                        ranges.put(c, new int[]{l, r});
                    }
                }
            }
        }

        HashMap<Integer, Character> resolvedDigits = new HashMap<>();
        int completed = 0;
        while (completed != 10) {
            for (char c : distinctChars) {
                int l = ranges.get(c)[0];
                int r = ranges.get(c)[1];
                int index = -1;
                int count = 0;
                for (int i = l; i <= r; i++) {
                    if (!resolvedDigits.containsKey(i)) {
                        count++;
                        index = i;
                    }
                }
                if (count == 1) {
                    resolvedDigits.put(index, c);
                    completed++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(resolvedDigits.get(i));
        }
        System.out.println();
    }

    public static class Query implements Comparable<Query> {
        long M;
        String R;

        Query(long m, String r) {
            this.M = m;
            this.R = r;
        }

        @Override
        public int compareTo(Query other) {
            return Long.compare(this.M, other.M);
        }
    }
}