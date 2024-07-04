//package codejam.qualification1C.randomize;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
    Map<Integer, Map<Character, Integer>> count;
    Set<Character> totalChars;
    void solve(Scanner sc, PrintWriter pw) {
        U = sc.nextInt();
        count = new HashMap<>();
        totalChars = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            long number = sc.nextLong();
            String mapped = sc.next();
            char topMapped = String.valueOf(mapped).charAt(0);
            int lenNumber = String.valueOf(number).length();
            totalChars.addAll(mapped.chars().mapToObj(x -> (char)x).collect(Collectors.toList()));
            Map<Character, Integer> lenCount = count.computeIfAbsent(lenNumber, x -> new HashMap<>());
            lenCount.put(topMapped, lenCount.getOrDefault(topMapped, 0) + 1);
        }

        char zero = 'x';
        Set<Character> oneKeys = count.get(1).keySet();
        for (char c : totalChars) {
            if (!oneKeys.contains(c)) {
                zero = c;
                break;
            }
        }

        for (Map<Character, Integer> value : count.values()) {
            value.remove(zero);
        }

        Map<List<Character>, Integer> mappedCount = new HashMap<>();
        for (Map<Character, Integer> value : count.values()) {
            List<Character> sortedList = value.keySet().stream().sorted(Comparator.comparing(value::get).reversed()).collect(Collectors.toList());
            mappedCount.put(sortedList, mappedCount.getOrDefault(value, 0) + 1);
        }

        List<Character> maxMap = mappedCount.keySet().stream().max(Comparator.comparing(mappedCount::get)).get();

        String result = "";
        result += zero;
        for (char c : maxMap) {
            result += c;
        }
        pw.println(result);
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
//        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
//                + OUTPUT_FILE_NAME));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Solution().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
