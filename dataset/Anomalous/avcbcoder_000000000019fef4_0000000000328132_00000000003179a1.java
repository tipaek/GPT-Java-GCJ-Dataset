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
        HashSet<Character>[] digitSets = initializeDigitSets();
        HashMap<Character, int[]> rangeMap = new HashMap<>();

        processQueries(queries, distinctChars, rangeMap);

        HashMap<Integer, Character> result = determineDigits(distinctChars, rangeMap);
        printResult(result);
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

        HashMap<Integer, Character> result = new HashMap<>();
        HashSet<Character> usedChars = new HashSet<>();
        for (char c : distinctChars) {
            if (!zeroCannotBe.contains(c)) {
                result.put(0, c);
                usedChars.add(c);
                break;
            }
        }

        for (int d = 1; d < 10; d++) {
            for (char c : distinctChars) {
                if (!usedChars.contains(c)) {
                    result.put(d, c);
                    usedChars.add(c);
                    break;
                }
            }
        }

        printResult(result);
    }

    private static HashSet<Character>[] initializeDigitSets() {
        HashSet<Character>[] digitSets = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            digitSets[i] = new HashSet<>();
        }
        return digitSets;
    }

    private static void processQueries(Query[] queries, HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        for (Query query : queries) {
            String M = String.valueOf(query.M);
            String R = query.R;

            boolean sameLength = R.length() == M.length();
            boolean mone = (String.valueOf(query.M - 1L)).length() < M.length();

            if (sameLength) {
                processSameLengthQuery(R, M, distinctChars, rangeMap);
            } else {
                processDifferentLengthQuery(R, distinctChars, rangeMap);
            }
        }
    }

    private static void processSameLengthQuery(String R, String M, HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        boolean nonZeroFound = false;
        for (int p = 0; p < R.length(); p++) {
            int l = (p == 0) ? 1 : 0;
            int r = nonZeroFound ? 9 : M.charAt(p) - '0';
            char c = R.charAt(p);
            distinctChars.add(c);

            rangeMap.putIfAbsent(c, new int[]{l, r});
            int[] range = rangeMap.get(c);
            rangeMap.put(c, new int[]{Math.max(l, range[0]), Math.min(r, range[1])});

            int d = R.charAt(p) - '0';
            if ((p == 0 && d > 1) || (p > 0 && d > 0)) {
                nonZeroFound = true;
            }
        }
    }

    private static void processDifferentLengthQuery(String R, HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        for (int p = 0; p < R.length(); p++) {
            int l = (p == 0) ? 1 : 0;
            int r = 9;
            char c = R.charAt(p);
            distinctChars.add(c);

            rangeMap.putIfAbsent(c, new int[]{l, r});
            int[] range = rangeMap.get(c);
            rangeMap.put(c, new int[]{Math.max(l, range[0]), Math.min(r, range[1])});
        }
    }

    private static HashMap<Integer, Character> determineDigits(HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        HashMap<Integer, Character> result = new HashMap<>();
        int completed = 0;

        while (completed != 10) {
            for (char c : distinctChars) {
                int l = rangeMap.get(c)[0];
                int r = rangeMap.get(c)[1];
                int index = -1;
                int count = 0;
                for (int i = l; i <= r; i++) {
                    if (!result.containsKey(i)) {
                        count++;
                        index = i;
                    }
                }
                if (count == 1) {
                    result.put(index, c);
                    completed++;
                }
            }
        }

        return result;
    }

    private static void printResult(HashMap<Integer, Character> result) {
        for (int i = 0; i < 10; i++) {
            System.out.print(result.get(i));
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