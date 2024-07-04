import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            long L = in.nextLong();
            long R = in.nextLong();
            boolean swap = false;
            if (L < R) {
                swap = true;
                long temp = L;
                L = R;
                R = temp;
            }
            long diff = L-R;
            long eqSteps = (long) Math.floor((-1+Math.sqrt(1+8*diff))/2);
            L -= eqSteps*(eqSteps+1)/2;
            if (L == R && L > eqSteps) {
                eqSteps++;
                L -= eqSteps;
                swap = true;
                long temp = L;
                L = R;
                R = temp;
            }
            long zSteps = (long) Math.floor((-2*eqSteps-3+Math.sqrt((2*eqSteps+3)*(2*eqSteps+3)+8*R))/2);
            long zDelta = (2*eqSteps+zSteps+3)*zSteps/2;
            R -= zDelta;
            L -= zDelta - zSteps;
            long steps = eqSteps + 2*zSteps;
            if (L > steps) {
                L -= steps+1;
                steps++;
            }
            if (swap) {
                long temp = L;
                L = R;
                R = temp;
            }
            System.out.printf("Case #%d: %d %d %d\n", t, steps, L, R);
        }
    }

}
