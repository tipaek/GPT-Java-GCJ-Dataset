import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Solution {

    static class Pair {
        int x, y;

        Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }

        @Override
        public String toString() {
            return String.format("%s %d", x, y);
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair)o;

            return p.x == x && y == p.y;
        }

        @Override
        public int hashCode() {
            return x * 10000 + y;
        }

        public int getValue() {
            return 0;
        }

        public boolean isValid() {
            if (x < 1 || y < 1) {
                return false;
            }

            return y <= x;
        }
    }

    private static BigInteger[]factorial = new BigInteger[600];

    public static void main(String []args) {

        iniFactorial();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCount = in.nextInt();
        for (int testNumber = 1; testNumber <= testCount; testNumber++) {
            System.out.printf("Case #%d:\n", testNumber);
            int n = in.nextInt();

            Set<Pair> visited = new HashSet<>();
            Pair initialPoint = new Pair(1, 1);
            visited.add(initialPoint);

            List<Pair> toPrint = new ArrayList<>();

            findPath(initialPoint, n - 1, visited, 1, toPrint);

            for (int i = toPrint.size() - 1; i >= 0; i--) {
//                System.out.println(toPrint.get(i) + "  " + getPascalValue(toPrint.get(i)));
                System.out.println(toPrint.get(i));
            }
        }
    }

    private static void iniFactorial() {
        factorial[0] = BigInteger.ONE;
        factorial[1] = BigInteger.ONE;

        for (int i = 2; i < 600; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    private static boolean findPath(Pair point, int remainingSum, Set<Pair> visited, int depth, List<Pair> toPrint) {
        int [][]possibleMoves = {
                {-1, -1},
                {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0},
                {1, 1},
        };

        if (depth > 500) {
            return false;
        }
        if (remainingSum < 0) {
            return false;
        }
        if (remainingSum == 0) {
            toPrint.add(point);
            return true;
        }

        for (int []move: possibleMoves) {
            Pair newPair = new Pair(point.x + move[0], point.y + move[1]);
            if (newPair.isValid() && !visited.contains(newPair)) {
                visited.add(newPair);
                if (findPath(newPair, remainingSum - getPascalValue(newPair), visited, depth + 1, toPrint)) {
                    toPrint.add(point);
                    visited.remove(point);
                    return true;
                }
            }
        }

        visited.remove(point);
        return false;

    }

    private static int getPascalValue(Pair pair) {
        int X = pair.x - 1;
        int Y = pair.y - 1;
        BigInteger s = factorial[X - Y];
        BigInteger deno = factorial[Y].multiply( s );
        return factorial[X].divide( deno ).intValue();
    }
}
/*


Input

Output

3
1
4
19


Case #1:
1 1
Case #2:
1 1
2 1
2 2
3 3
Case #3:
1 1
2 2
3 2
4 3
5 3
5 2
4 1
3 1


*/