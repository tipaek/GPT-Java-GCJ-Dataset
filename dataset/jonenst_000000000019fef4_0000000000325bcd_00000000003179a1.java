import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            List<Object> input = readInput(in);
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static List<Object> readInput(Scanner in) {
        int U = in.nextInt();
        List<Object> records = new ArrayList<Object>();
        for (int i = 0; i < 10000; i++) {
            records.add(Arrays.asList(in.nextLong(), in.nextLine().substring(1)));
        }
        return Arrays.asList(U, records);
    }

    public static String solve(List<Object> input) {
        int U = (int) input.get(0);
        List<List<Object>> records = (List<List<Object>>) input.get(1);
        Map<Integer, Integer> totals = new HashMap<Integer, Integer>();
        for (List<Object> record : records) {
            long M = (long) record.get(0);
            String s = (String) record.get(1);
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i);
                totals.put(c, totals.getOrDefault(c, 0) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        totals.entrySet().stream().sorted(Comparator.comparing((Entry<Integer, Integer> e) -> e.getValue()).reversed())
                .forEach(
                e -> sb.append((char) (int) e.getKey())
        );
        String x = sb.toString();
        return x.charAt(x.length() - 1) + x.substring(0, x.length() - 1);
        // Case #1: TPFOXLUSHB
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            int best = -1;
//            int bestkey = -1;
//            for (Entry<Integer, Map<Integer, Integer>> e : map.entrySet()) {
//                int c = e.getKey();
//                int v = e.getValue().getOrDefault(i, 0);
//                int normalized = v * fulltot / totals.get(c);
//                if (normalized > best) {
//                    best = normalized;
//                    bestkey = c;
//                }
//            }
//            sb.append((char) bestkey);
//        }
//        return sb.toString();
//        List<Integer> res = map.entrySet().stream().map(entry -> {
//            int c = entry.getKey();
//            Entry k = entry.getValue().entrySet().stream()
//                    .sorted((Comparator.comparing((Entry e) -> (Integer) e.getValue())).reversed())
//                    .findFirst()
//                    .get();
//            return Arrays.asList(c, k.getKey());
//        }).sorted(Comparator.comparing(l -> (int) ((List) l).get(1))).map(w -> (int) ((List) w).get(0))
//                .collect(Collectors.toList());
//        StringBuilder sb = new StringBuilder();
//        for (int a : res) {
//            sb.append((char) a);
//        }
//        return sb.toString();
    }
}
