import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processTestCase(testCase);
        }
    }

    public static double calculateQuadraticSolution(long a, long b) {
        if (a < b) return -99999999;
        double discriminant = Math.sqrt(1 + 4 * (a - b));
        double root = -1 + discriminant;
        return root / 2 - 0.00001;
    }

    public static void processTestCase(int testCaseNumber) throws IOException {
        System.out.print("Case #" + testCaseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        long counter = Math.max((int) Math.ceil(calculateQuadraticSolution(L, R)), (int) Math.ceil(calculateQuadraticSolution(R, L)));

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

        long additionalSteps = 90121310;
        if (L >= R) {
            additionalSteps = Math.min((int) calculateAdditionalSteps(counter + 1, L), (int) calculateAdditionalSteps(counter + 2, R));
            L -= (counter + 1) * additionalSteps + additionalSteps * (additionalSteps - 1);
            R -= (counter + 2) * additionalSteps + additionalSteps * (additionalSteps - 1);
            counter += 2 * additionalSteps;
            System.out.println(counter + " " + L + " " + R);
        } else {
            additionalSteps = Math.min((int) calculateAdditionalSteps(counter + 1, R), (int) calculateAdditionalSteps(counter + 2, L));
            R -= (counter + 1) * additionalSteps + additionalSteps * (additionalSteps - 1);
            L -= (counter + 2) * additionalSteps + additionalSteps * (additionalSteps - 1);
            counter += 2 * additionalSteps;
            System.out.println(counter + " " + L + " " + R);
        }
    }

    public static double calculateAdditionalSteps(long start, long value) {
        long offset = start - 1;
        return (-offset + Math.sqrt(offset * offset + 4 * value)) / 2 + 0.00001;
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
        return 10283 * x + y;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.x, other.x);
    }
}