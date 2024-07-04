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
        Query[] queries = new Query[9];

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
            handleAllMinusOne(queries, distinctChars);
            return;
        }

        Arrays.sort(queries);
        HashMap<Character, int[]> charRanges = new HashMap<>();
        HashSet<Character>[] digitSets = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            digitSets[i] = new HashSet<>();
        }

        for (Query query : queries) {
            String MStr = String.valueOf(query.M);
            String R = query.R;
            boolean sameLength = R.length() == MStr.length();
            boolean mone = (String.valueOf(query.M - 1L)).length() < MStr.length();

            updateCharRanges(charRanges, distinctChars, MStr, R, sameLength);
        }

        determineDigits(distinctChars, charRanges);
    }

    private static void handleAllMinusOne(Query[] queries, HashSet<Character> distinctChars) {
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

        HashMap<Integer, Character> digitMap = new HashMap<>();
        HashSet<Character> notAvailable = new HashSet<>();
        for (char c : distinctChars) {
            if (!zeroCannotBe.contains(c)) {
                digitMap.put(0, c);
                notAvailable.add(c);
                break;
            }
        }

        for (int d = 1; d < 10; d++) {
            for (char c : distinctChars) {
                if (!notAvailable.contains(c) && !digitMap.containsValue(c)) {
                    digitMap.put(d, c);
                    notAvailable.add(c);
                    break;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(digitMap.get(i));
        }
        System.out.println();
    }

    private static void updateCharRanges(HashMap<Character, int[]> charRanges, HashSet<Character> distinctChars, String MStr, String R, boolean sameLength) {
        boolean nz = false;
        for (int p = 0; p < R.length(); p++) {
            int l = p == 0 ? 1 : 0;
            int r = sameLength ? (nz ? 9 : MStr.charAt(p) - '0') : 9;
            char c = R.charAt(p);
            distinctChars.add(c);

            charRanges.putIfAbsent(c, new int[]{l, r});
            int[] existingRange = charRanges.get(c);
            charRanges.put(c, new int[]{Math.max(l, existingRange[0]), Math.min(r, existingRange[1])});

            if ((p == 0 && R.charAt(p) > '1') || (p > 0 && R.charAt(p) > '0')) {
                nz = true;
            }
        }
    }

    private static void determineDigits(HashSet<Character> distinctChars, HashMap<Character, int[]> charRanges) {
        HashMap<Integer, Character> digitMap = new HashMap<>();
        int completed = 0;

        while (completed != 10) {
            for (char c : distinctChars) {
                int l = charRanges.get(c)[0];
                int r = charRanges.get(c)[1];
                int idx = -1;
                int count = 0;

                for (int i = l; i <= r; i++) {
                    if (!digitMap.containsKey(i)) {
                        count++;
                        idx = i;
                    }
                }

                if (count == 1) {
                    digitMap.put(idx, c);
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
        long M;
        String R;

        Query(long m, String r) {
            this.M = m;
            this.R = r;
        }

        @Override
        public int compareTo(Query o) {
            return Long.compare(this.M, o.M);
        }
    }
}