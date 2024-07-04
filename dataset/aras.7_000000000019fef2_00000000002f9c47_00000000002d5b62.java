import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Solution {

    static int currentAnswer;

    public static void main(String[] args) {
//        Set<Integer> validDistances = generateValidDistances();
//        for (int d: validDistances) {
//            System.out.println("V: " + d);
//        }
//        System.out.println("size: " + validDistances.size());

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
            long x = in.nextInt(), y = in.nextInt();

            currentAnswer = 10000;
            StringBuilder answerBuilder = new StringBuilder();
            if (!findIt(0, 0, 0, x, y, answerBuilder, 12)) {
                answerBuilder.append("IMPOSSIBLE");
            } else {
                answerBuilder = answerBuilder.reverse();
            }

            System.out.println("Case #" + testCase + ": " + answerBuilder.toString());
        }
    }

    private static boolean findIt(long x, long y, long it, long targetX, long targetY, StringBuilder answerBuilder, long maxIt) {
        if (x == targetX && y == targetY) {
            answerBuilder.setLength(0);
            currentAnswer = (int)it;
            return true;
        }
        
        if (maxIt == it) {
            return false;
        }

        if (currentAnswer <= it) {
            return false;
        }
        
        long distance = 1 << it;

        boolean found = false;

        if (findIt(x, y + distance, it + 1, targetX, targetY, answerBuilder, maxIt)) {
            answerBuilder.append("N");
            found = true;
        }

        if (findIt(x, y - distance, it + 1, targetX, targetY, answerBuilder, maxIt)) {
            answerBuilder.append("S");
            found = true;
        }

        if (findIt(x + distance, y, it + 1, targetX, targetY, answerBuilder, maxIt)) {
            answerBuilder.append("E");
            found = true;
        }

        if (findIt(x - distance, y, it + 1, targetX, targetY, answerBuilder, maxIt)) {
            answerBuilder.append("W");
            found = true;
        }

        return found;
    }

    private static Set<Integer> generateValidDistances() {
        Set<Integer> distances = new TreeSet<>();
        distances.add(0);
        long i = 0;
        long num = 0;
        while (true) {
            num += (1L << i);

            if (num <= 2 * 1_000_000_000L) {
                distances.add((int)num);
            } else {
                break;
            }

            i++;
        }

        return distances;
    }

}
/*
9
2 3
-2 -3
3 0
-1 1
100 100
99 89
1000 1000
10000000 1000000000
1000000000 1000000000


Case #1: SEN
Case #2: NWS
Case #3: EE
Case #4: IMPOSSIBLE
* */
