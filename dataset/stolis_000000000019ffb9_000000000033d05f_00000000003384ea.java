import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            long L = in.nextLong();
            long R = in.nextLong();
            long[] solution = solve(L, R);
            System.out.printf("Case #%d: %d %d %d\n", t, solution[0], solution[1], solution[2]);
        }
    }

    static long[] solveNaive(long L, long R) {
        long step = 1;
        while (true) {
            if (Math.max(L,R) < step) {
                break;
            }
            if (L>=R) {
                L -= step;
            } else {
                R -= step;
            }
            step++;
        }
        return new long[] {step-1, L, R};
    }

    static long[] solve(long L, long R) {
        boolean swap = false;
        if (L < R) {
            swap = true;
            long temp = L;
            L = R;
            R = temp;
        }
        long diff = L - R;
        long eqSteps = (long) Math.floor((-1 + Math.sqrt(1 + 8 * diff)) / 2);
        L -= eqSteps * (eqSteps + 1) / 2;
        if (L == R && L > eqSteps) {
            eqSteps++;
            L -= eqSteps;
            swap = true;
            long temp = L;
            L = R;
            R = temp;
        }
        long zSteps = (long) Math.floor((-eqSteps - 1 + Math.sqrt((eqSteps + 1) * (eqSteps + 1) + 4 * R))/2);
        long zDelta = (eqSteps + zSteps + 1) * zSteps;
        R -= zDelta;
        L -= zDelta - zSteps;
        long steps = eqSteps + 2 * zSteps;
        if (L > steps) {
            steps++;
            L -= steps;
        }
        if (swap) {
            long temp = L;
            L = R;
            R = temp;
        }
        return new long[]{steps, L, R};
    }

}
