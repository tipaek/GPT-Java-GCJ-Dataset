import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
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

        boolean allMinusOne = true;
        HashSet<Character> distinctChars = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            String[] input = br.readLine().split(" ");
            queries[i] = new Query(Long.parseLong(input[0]), input[1]);
            if (queries[i].M != -1) {
                allMinusOne = false;
            }
        }

        if (allMinusOne) {
            handleAllMinusOneCase(queries, distinctChars);
            return;
        }

        Arrays.sort(queries);
        HashMap<Character, int[]> charRange = new HashMap<>();
        HashSet<Character>[] digitSets = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            digitSets[i] = new HashSet<>();
        }

        for (Query query : queries) {
            processQuery(query, charRange, distinctChars);
        }

        HashMap<Integer, Character> digitMapping = new HashMap<>();
        int completedMappings = 0;
        while (completedMappings < 10) {
            for (char c : distinctChars) {
                int l = charRange.get(c)[0];
                int r = charRange.get(c)[1];
                int possibleDigit = -1;
                int count = 0;
                for (int i = l; i <= r; i++) {
                    if (!digitMapping.containsKey(i)) {
                        count++;
                        possibleDigit = i;
                    }
                }
                if (count == 1) {
                    digitMapping.put(possibleDigit, c);
                    completedMappings++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(digitMapping.get(i));
        }
        System.out.println();
    }

    private static void handleAllMinusOneCase(Query[] queries, HashSet<Character> distinctChars) {
        HashSet<Character> zeroCannotBe = new HashSet<>();
        for (Query query : queries) {
            String R = query.R;
            for (int p = 0; p < R.length(); p++) {
                if (p == 0) {
                    zeroCannotBe.add(R.charAt(p));
                }
                distinctChars.add(R.charAt(p));
            }
        }
        HashMap<Integer, Character> digitMapping = new HashMap<>();
        for (char c : distinctChars) {
            if (!zeroCannotBe.contains(c)) {
                digitMapping.put(0, c);
                break;
            }
        }
        for (int d = 1; d < 10; d++) {
            for (char c : distinctChars) {
                if (!digitMapping.containsValue(c)) {
                    digitMapping.put(d, c);
                    break;
                }
            }
        }
    }

    private static void processQuery(Query query, HashMap<Character, int[]> charRange, HashSet<Character> distinctChars) {
        String M = String.valueOf(query.M);
        String R = query.R;
        boolean sameLength = R.length() == M.length();
        boolean mone = (String.valueOf(query.M - 1).length() < M.length());

        if (sameLength) {
            boolean nonZero = false;
            for (int p = 0; p < R.length(); p++) {
                int l = p == 0 ? 1 : 0;
                int r = nonZero ? 9 : M.charAt(p) - '0';
                char c = R.charAt(p);
                distinctChars.add(c);
                updateRange(charRange, c, l, r);
                int d = R.charAt(p) - '0';
                if ((p == 0 && d > 1) || (p > 0 && d > 0)) {
                    nonZero = true;
                }
            }
        } else {
            for (int p = 0; p < R.length(); p++) {
                int l = p == 0 ? 1 : 0;
                int r = 9;
                char c = R.charAt(p);
                distinctChars.add(c);
                updateRange(charRange, c, l, r);
            }
        }
    }

    private static void updateRange(HashMap<Character, int[]> charRange, char c, int l, int r) {
        if (charRange.containsKey(c)) {
            int[] range = charRange.get(c);
            charRange.put(c, new int[]{Math.max(l, range[0]), Math.min(r, range[1])});
        } else {
            charRange.put(c, new int[]{l, r});
        }
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