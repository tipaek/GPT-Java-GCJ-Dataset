import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
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
            boolean isImpossible = false;
            List<Integer> J = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
            List<Integer> C = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
            int jn = 0, cn = 0;
            
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                
                if (isAvailable(J, start, end) && isAvailable(C, start, end)) {
                    if (jn > cn) {
                        assignInterval(result, J, start, end, 'J');
                        jn++;
                    } else {
                        assignInterval(result, C, start, end, 'C');
                        cn++;
                    }
                } else if (isAvailable(J, start, end)) {
                    assignInterval(result, J, start, end, 'J');
                    jn++;
                } else if (isAvailable(C, start, end)) {
                    assignInterval(result, C, start, end, 'C');
                    cn++;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static boolean isAvailable(List<Integer> list, int start, int end) {
        return list.contains(start) && list.contains(end) && list.indexOf(end) - list.indexOf(start) == end - start;
    }

    private static void assignInterval(StringBuilder result, List<Integer> list, int start, int end, char person) {
        result.append(person);
        int s = list.indexOf(start);
        int e = list.indexOf(end);
        for (int i = s; i < e; i++) {
            list.remove(s);
        }
    }
}