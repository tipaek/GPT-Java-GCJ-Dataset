import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution {
    public static class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        int getFirst() {
            return first;
        }

        int getSecond() {
            return second;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int MAX_LENGTH = 24*60;
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            StringBuffer result = new StringBuffer();

            Map<Integer, Pair> schedule = new HashMap<>();
            for(int j = 0; j < N; j++)
            {
                int start = in.nextInt();
                int end = in.nextInt();

                schedule.put(j, new Pair(start, end));
            }
            schedule = sortByValue(schedule);

            Map<Integer, Character> resultMap = new TreeMap<>();
            String camString = repeat('-', MAX_LENGTH);
            String jamString = repeat('-', MAX_LENGTH);

            boolean impossible = false;
            for(Map.Entry<Integer, Pair> integerPairEntry : schedule.entrySet()) {
                int start = integerPairEntry.getValue().getFirst();
                int end = integerPairEntry.getValue().getSecond();

                if (impossible) {
                    break;
                }
                if (camString.substring(start, end).equals(repeat('-', end - start))) {
                    resultMap.put(integerPairEntry.getKey(), 'C');
                    camString = new StringBuffer(camString.substring(0, start))
                        .append(repeat('C', end - start))
                        .append(camString.substring(end))
                        .toString();
                } else if (jamString.substring(start, end).equals(repeat('-', end - start))) {
                    resultMap.put(integerPairEntry.getKey(), 'J');
                    jamString = new StringBuffer(jamString.substring(0, start))
                        .append(repeat('J', end - start))
                        .append(jamString.substring(end))
                        .toString();

                } else {
                    impossible = true;
                }
            }

            resultMap.entrySet().forEach(entry -> result.append(entry.getValue()));

            System.out.println("Case #" + i + ": " + (impossible? "IMPOSSIBLE" : result));
        }
    }

    private static String repeat(char ch, int n) {
        StringBuffer out = new StringBuffer();
        IntStream.range(0, n).forEach(i -> out.append(ch));
        return out.toString();
    }

    private static Map<Integer, Pair> sortByValue(Map<Integer, Pair> unsortMap) {
        List<Map.Entry<Integer, Pair>> list = new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Pair>>() {
            public int compare(Map.Entry<Integer, Pair> o1,
                Map.Entry<Integer, Pair> o2) {
                return o1.getValue().getFirst() - o2.getValue().getFirst();
            }
        });

        Map<Integer, Pair> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Pair> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
