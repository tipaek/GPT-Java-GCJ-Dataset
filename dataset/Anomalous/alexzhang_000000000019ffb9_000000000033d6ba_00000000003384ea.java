import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processTestCase(testCase);
        }
    }

    public static double calculateQuadratic(long a, long b) {
        if (a < b) return -99999999;
        double result = -1 + Math.sqrt(1 + 8 * (a - b));
        return result / 2 + 0.00001;
    }

    public static void processTestCase(int caseNumber) throws IOException {
        System.out.print("Case #" + caseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());
        long counter = Math.max((int) calculateQuadratic(L, R), (int) calculateQuadratic(R, L));

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

        long maxSteps = 90121310;
        if (L >= R) {
            maxSteps = Math.max((int) calculateSuperSteps(counter + 1, L), (int) calculateSuperSteps(counter + 2, R));
            L -= (counter + 1) * maxSteps + maxSteps * (maxSteps - 1);
            R -= (counter + 2) * maxSteps + maxSteps * (maxSteps - 1);
            counter += 2 * maxSteps;
            adjustCounterAndValues(counter, L, R);
            System.out.println(counter + " " + L + " " + R);
        } else {
            maxSteps = Math.max((int) calculateSuperSteps(counter + 1, R), (int) calculateSuperSteps(counter + 2, L));
            R -= (counter + 1) * maxSteps + maxSteps * (maxSteps - 1);
            L -= (counter + 2) * maxSteps + maxSteps * (maxSteps - 1);
            counter += 2 * maxSteps;
            adjustCounterAndValues(counter, L, R);
            System.out.println(counter + " " + L + " " + R);
        }
    }

    public static double calculateSuperSteps(long count, long value) {
        long offset = count - 1;
        return (-offset + Math.sqrt(offset * offset + 4 * value)) / 2 + 0.00001;
    }

    private static void adjustCounterAndValues(long counter, long L, long R) {
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