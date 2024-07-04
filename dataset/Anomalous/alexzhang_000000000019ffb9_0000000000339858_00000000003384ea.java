import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processCase(caseNumber);
        }
    }

    public static void processCase(int caseNumber) throws IOException {
        System.out.print("Case #" + caseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int moves = 0;

        for (int i = 1; ; i++) {
            if (L < R) {
                if (R >= i) {
                    R -= i;
                    moves++;
                } else {
                    System.out.println(moves + " " + L + " " + R);
                    return;
                }
            } else {
                if (L >= i) {
                    L -= i;
                    moves++;
                } else {
                    System.out.println(moves + " " + L + " " + R);
                    return;
                }
            }
        }
    }
}

class Pair {
    public long x;
    public long y;

    public Pair(long x, long y) {
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
        return Objects.hash(x, y);
    }
}