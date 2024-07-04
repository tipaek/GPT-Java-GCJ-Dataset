//package codejam.qualification1C.randomize;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    final static String PROBLEM_NAME = "overrandomize";
    final static String WORK_DIR = "/home/kamel/Code/java/LeetCode/data/gcj2020/q1c/" + PROBLEM_NAME + "/";
    final static String INPUT_FILE_NAME = "input";
    final static String OUTPUT_FILE_NAME = "output";

    int U;
    Map<Long, String> map;
    Map<Character, Long> upper;
    List<Character> total;
    Map<Character, Integer> usedMap;
    void solve(Scanner sc, PrintWriter pw) {
        U = sc.nextInt();
        map = new HashMap<>();
        upper = new HashMap<>();
        usedMap = new HashMap<>();
        for (int i = 0; i < 10_000; i++) {
            long number = sc.nextLong();
            String mapped = sc.next();
            if (mapped.length() != U) {
                continue;
            }
            map.put(number, mapped);
            char topChar = mapped.charAt(0);
            int topDigit = String.valueOf(number).charAt(0) - '0';
            upper.put(topChar, (long)topDigit);
        }

        total = map.values().stream().flatMap(x -> x.chars().mapToObj(c -> (char) c))
                .distinct()
                .sorted(Comparator.comparing(x -> upper.getOrDefault(x, 10L)))
                .collect(Collectors.toList());
        pw.println(dfs(0, 10, ""));
    }

    private String dfs(int digit, int left, String current) {
        if (left == 0) {
            if (valid(current)) {
                return current;
            } else {
                return "";
            }
        }

        for (char c : total) {
            if (usedMap.containsKey(c)) {
                continue;
            }

            if (upper.getOrDefault(c, 10L) < digit) {
                continue;
            }

            usedMap.put(c, digit);
            String candidate = dfs(digit + 1, left - 1, current + c);
            if (!candidate.isEmpty()) {
                return candidate;
            }

            usedMap.remove(c);
        }
        return "";
    }

    private boolean valid(String current) {
        Map<Character, Integer> digitMap = new HashMap<>();
        for (int i = 0; i < current.length(); i++) {
            digitMap.put(current.charAt(i), i);
        }
        

        for (Map.Entry<Long, String> entry : map.entrySet()) {
            long upper = entry.getKey();
            String mapped = entry.getValue();
            if (digitMap.get(mapped.charAt(0)) == 0L) {
               return false;
            }
            int mappedValue = 0;
            for (char c : mapped.toCharArray()) {
                mappedValue = mappedValue * 10 + digitMap.get(c);
            }

            if (mappedValue > upper) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        //PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
   //             + OUTPUT_FILE_NAME));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            //System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Solution().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
