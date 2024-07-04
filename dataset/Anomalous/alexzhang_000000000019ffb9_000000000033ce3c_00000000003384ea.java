import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            processCase(caseNum);
        }
    }

    public static double findQuadraticRoot(long a, long b) {
        if (a < b) return Double.NEGATIVE_INFINITY;
        double root = -1 + Math.sqrt(1 + 8 * (a - b));
        return root / 2 + 0.00001;
    }

    public static void processCase(int caseNumber) throws IOException {
        System.out.print("Case #" + caseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        long steps = Math.max((int) findQuadraticRoot(L, R), (int) findQuadraticRoot(R, L));

        if (L >= R) {
            L -= steps * (steps + 1) / 2;
        } else {
            R -= steps * (steps + 1) / 2;
        }

        if (Math.max(L, R) < steps + 1) {
            System.out.println(steps + " " + L + " " + R);
            return;
        }

        if (Math.max(L, R) == steps + 1) {
            if (L == steps + 1) {
                steps++;
                L -= steps;
                System.out.println(steps + " " + L + " " + R);
                return;
            }
            if (R == steps + 1) {
                steps++;
                R -= steps;
                System.out.println(steps + " " + L + " " + R);
                return;
            }
        }

        long minSteps = 90121310;
        if (L >= R) {
            minSteps = Math.min((int) findSuperRoot(steps + 1, L), (int) findSuperRoot(steps + 2, R));
            L -= (steps + 1) * minSteps + minSteps * (minSteps - 1);
            R -= (steps + 2) * minSteps + minSteps * (minSteps - 1);
            steps += 2 * minSteps;
            processRemainder(steps, L, R);
        } else {
            minSteps = Math.min((int) findSuperRoot(steps + 1, R), (int) findSuperRoot(steps + 2, L));
            R -= (steps + 1) * minSteps + minSteps * (minSteps - 1);
            L -= (steps + 2) * minSteps + minSteps * (minSteps - 1);
            steps += 2 * minSteps;
            processRemainder(steps, L, R);
        }
    }

    public static double findSuperRoot(long count, long value) {
        long offset = count - 1;
        return (-offset + Math.sqrt(offset * offset + 4 * value)) / 2 + 0.00001;
    }

    public static void processRemainder(long steps, long L, long R) {
        if (L > steps) {
            steps++;
            L -= steps;
        }
        if (R > steps) {
            steps++;
            R -= steps;
        }
        if (L > steps) {
            steps++;
            L -= steps;
        }
        if (R > steps) {
            steps++;
            R -= steps;
        }
        System.out.println(steps + " " + L + " " + R);
    }
}

class Pair implements Comparable<Pair> {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.x, other.x);
    }
}