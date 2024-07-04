import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testN = input.nextInt();
        for (int i = 0; i < testN; i++) {
            int intervalN = input.nextInt();
            int[][] intervals = new int[intervalN][2];
            for (int j = 0; j < intervalN; j++) {
                intervals[j][0] = input.nextInt();
                intervals[j][1] = input.nextInt();
            }

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            List<Integer> J = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
            List<Integer> C = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());

            for (int[] interval : intervals) {
                if (isAvailable(J, interval[0], interval[1])) {
                    result.append("J");
                    removeInterval(J, interval[0], interval[1]);
                } else if (isAvailable(C, interval[0], interval[1])) {
                    result.append("C");
                    removeInterval(C, interval[0], interval[1]);
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, result.toString());
        }
    }

    private static boolean isAvailable(List<Integer> list, int start, int end) {
        int startIndex = list.indexOf(start);
        int endIndex = list.indexOf(end);
        return startIndex != -1 && endIndex != -1 && (endIndex - startIndex == end - start);
    }

    private static void removeInterval(List<Integer> list, int start, int end) {
        int startIndex = list.indexOf(start);
        for (int i = 0; i < end - start; i++) {
            list.remove(startIndex);
        }
    }
}