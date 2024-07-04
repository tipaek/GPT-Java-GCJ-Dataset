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

        HashMap<Character, int[]> rangeMap = new HashMap<>();
        for (Query query : queries) {
            processQuery(query, distinctChars, rangeMap);
        }

        HashMap<Integer, Character> digitMap = determineDigits(distinctChars, rangeMap);
        printResult(digitMap);
    }

    private static void handleAllMinusOneCase(Query[] queries, HashSet<Character> distinctChars) {
        HashSet<Character> zeroCannotBe = new HashSet<>();
        for (Query query : queries) {
            String R = query.R;
            zeroCannotBe.add(R.charAt(0));
            for (char c : R.toCharArray()) {
                distinctChars.add(c);
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
                if (notAvailable.contains(c)) continue;
                if (!digitMap.containsValue(c)) {
                    digitMap.put(d, c);
                    notAvailable.add(c);
                    break;
                }
            }
        }

        printResult(digitMap);
    }

    private static void processQuery(Query query, HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        String M = String.valueOf(query.M);
        String R = query.R;

        boolean sameLength = R.length() == M.length();
        boolean oneLessLength = (String.valueOf(query.M - 1)).length() < M.length();

        if (sameLength) {
            processSameLengthQuery(M, R, distinctChars, rangeMap);
        } else {
            processDifferentLengthQuery(R, distinctChars, rangeMap);
        }
    }

    private static void processSameLengthQuery(String M, String R, HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        boolean nonZero = false;
        for (int p = 0; p < R.length(); p++) {
            int left = p == 0 ? 1 : 0;
            int right = nonZero ? 9 : M.charAt(p) - '0';
            char c = R.charAt(p);
            distinctChars.add(c);
            updateRangeMap(rangeMap, c, left, right);
            int digit = R.charAt(p) - '0';
            if ((p == 0 && digit > 1) || (p > 0 && digit > 0)) {
                nonZero = true;
            }
        }
    }

    private static void processDifferentLengthQuery(String R, HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        for (int p = 0; p < R.length(); p++) {
            int left = p == 0 ? 1 : 0;
            int right = 9;
            char c = R.charAt(p);
            distinctChars.add(c);
            updateRangeMap(rangeMap, c, left, right);
        }
    }

    private static void updateRangeMap(HashMap<Character, int[]> rangeMap, char c, int left, int right) {
        if (rangeMap.containsKey(c)) {
            int[] range = rangeMap.get(c);
            rangeMap.put(c, new int[]{Math.max(left, range[0]), Math.min(right, range[1])});
        } else {
            rangeMap.put(c, new int[]{left, right});
        }
    }

    private static HashMap<Integer, Character> determineDigits(HashSet<Character> distinctChars, HashMap<Character, int[]> rangeMap) {
        HashMap<Integer, Character> digitMap = new HashMap<>();
        int completed = 0;

        while (completed != 10) {
            for (char c : distinctChars) {
                int left = rangeMap.get(c)[0];
                int right = rangeMap.get(c)[1];
                int index = -1;
                int count = 0;

                for (int i = left; i <= right; i++) {
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

        return digitMap;
    }

    private static void printResult(HashMap<Integer, Character> digitMap) {
        for (int i = 0; i < 10; i++) {
            System.out.print(digitMap.get(i));
        }
        System.out.println();
    }

    public static class Query implements Comparable<Query> {
        long M;
        String R;

        Query(long M, String R) {
            this.M = M;
            this.R = R;
        }

        @Override
        public int compareTo(Query other) {
            return Long.compare(this.M, other.M);
        }
    }
}