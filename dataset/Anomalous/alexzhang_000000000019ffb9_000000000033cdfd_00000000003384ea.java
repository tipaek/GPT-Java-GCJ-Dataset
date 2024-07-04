import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processTestCase(testCase);
        }
    }

    private static double calculateQuadratic(long a, long b) {
        if (a < b) return -99999999;
        double result = -1 + Math.sqrt(1 + 8 * (a - b));
        return result / 2 + 0.00001;
    }

    private static void processTestCase(int caseNumber) throws IOException {
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

        long kazuma = 90121310;
        if (L >= R) {
            kazuma = Math.min((int) findSupremum(counter + 1, L), (int) findSupremum(counter + 2, R));
            L -= (counter + 1) * kazuma + kazuma * (kazuma - 1);
            R -= (counter + 2) * kazuma + kazuma * (kazuma - 1);
            counter += 2 * kazuma;
            adjustCounters(L, R, counter);
        } else {
            kazuma = Math.min((int) findSupremum(counter + 1, R), (int) findSupremum(counter + 2, L));
            R -= (counter + 1) * kazuma + kazuma * (kazuma - 1);
            L -= (counter + 2) * kazuma + kazuma * (kazuma - 1);
            counter += 2 * kazuma;
            adjustCounters(L, R, counter);
        }
    }

    private static double findSupremum(long count, long value) {
        long offset = count - 1;
        return (-offset + Math.sqrt(offset * offset + 4 * value)) / 2 + 0.00001;
    }

    private static void adjustCounters(long L, long R, long counter) {
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
    private final int x;
    private final int y;

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