import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            processCase(caseNum);
        }
    }

    private static double calculateQuadraticRoot(long a, long b) {
        if (a < b) return Double.NEGATIVE_INFINITY;
        double discriminant = Math.sqrt(1 + 4 * (a - b));
        return (-1 + discriminant) / 2 - 0.00001;
    }

    private static void processCase(int caseNum) throws IOException {
        System.out.print("Case #" + caseNum + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        long counter = Math.max((long) Math.ceil(calculateQuadraticRoot(L, R)), (long) Math.ceil(calculateQuadraticRoot(R, L)));

        if (L >= R) {
            L -= counter * (counter + 1) / 2;
        } else {
            R -= counter * (counter + 1) / 2;
        }

        if (Math.max(L, R) < counter + 1) {
            System.out.println(counter + " " + L + " " + R);
            return;
        }

        if (Math.max(L, R) == counter + 1) {
            if (L == counter + 1) {
                counter++;
                L -= counter;
                System.out.println(counter + " " + L + " " + R);
                return;
            }
            if (R == counter + 1) {
                counter++;
                R -= counter;
                System.out.println(counter + " " + L + " " + R);
                return;
            }
        }

        long maxSteps = Long.MAX_VALUE;

        if (L >= R) {
            maxSteps = Math.min((long) findSteps(counter + 1, L), (long) findSteps(counter + 2, R));
            L -= (counter + 1) * maxSteps + maxSteps * (maxSteps - 1);
            R -= (counter + 2) * maxSteps + maxSteps * (maxSteps - 1);
            counter += 2 * maxSteps;
            updateValues(counter, L, R);
        } else {
            maxSteps = Math.min((long) findSteps(counter + 1, R), (long) findSteps(counter + 2, L));
            R -= (counter + 1) * maxSteps + maxSteps * (maxSteps - 1);
            L -= (counter + 2) * maxSteps + maxSteps * (maxSteps - 1);
            counter += 2 * maxSteps;
            updateValues(counter, L, R);
        }
    }

    private static double findSteps(long step, long value) {
        long adjustedStep = step - 1;
        return (-adjustedStep + Math.sqrt(adjustedStep * adjustedStep + 4 * value)) / 2 + 0.00001;
    }

    private static void updateValues(long counter, long L, long R) {
        if (L > counter) {
            counter++;
            L -= counter;
        }
        if (R > counter) {
            counter++;
            R -= counter;
        }
        if (L > counter) {
            counter++;
            L -= counter;
        }
        if (R > counter) {
            counter++;
            R -= counter;
        }
        System.out.println(counter + " " + L + " " + R);
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
        Pair other = (Pair) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.x, other.x);
    }
}