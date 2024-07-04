import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int[] input = readInput(in);
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private static List<Long> newPos(long jump, int i, List<Long> oldpos) {
        switch(i) {
        case 0: return Arrays.asList(oldpos.get(0)+jump, oldpos.get(1));
        case 1: return Arrays.asList(oldpos.get(0)-jump, oldpos.get(1));
        case 2: return Arrays.asList(oldpos.get(0), oldpos.get(1)+jump);
        case 3: return Arrays.asList(oldpos.get(0), oldpos.get(1)-jump);
        }
        throw new RuntimeException("bad");
    }

    private static char newPath(int i) {
        switch(i) {
        case 0: return 'E';
        case 1: return 'W';
        case 2: return 'N';
        case 3: return 'S';
        }
        throw new RuntimeException("bad");
    }
    
    private static String solve(int[] input) {
        ArrayDeque<List<Object>> queu = new ArrayDeque<>();
        queu.add(Arrays.asList(Arrays.asList(0L,0L), 1L, ""));
        while (!queu.isEmpty() && ((String) (queu.peek().get(2))).length() < 10) {
            List<Object> cur = queu.pop();
            List<Long> curpos = (List<Long>) cur.get(0);
            long jump = (long) cur.get(1);
            for (int i=0; i<4; i++) {
                List<Long> nextpos = newPos(jump, i, curpos);
                String curpath = (String) cur.get(2);
                String nextpath = curpath + newPath(i);
                if (nextpos.get(0) == input[0] && nextpos.get(1) == input[1]) {
                    return nextpath;
                } else {
                    queu.add(Arrays.asList(nextpos, jump * 2, nextpath));
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static int[] readInput(Scanner in) {
        return Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
