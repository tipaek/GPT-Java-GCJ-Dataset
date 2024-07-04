import java.util.*;

public class Solution {
    private final int T;

    private final int nBits;
    private int[] bits;

    private Scanner in;

    private boolean knowS;
    private int d1;
    private int d2;
    private boolean knowD;
    private int s2;
    private int s1;

    private int knowBits = 0;

    public Solution(int T, int nBits, Scanner in) {
        this.T = T;
        this.nBits = nBits;
        this.bits = new int[nBits];
        this.in = in;
    }


    public void solve() {
        int currentI = 0;

        int action = 0;

        while (knowBits == nBits) { //1 2 3 4 5 6 7 8 9 10
            currentI = nextIndex(currentI);

            if (action == 10) {
                action = 0;
                action += checkResult();
            }
            final int bit = getBit(currentI);
            action++;

            final int oppositeI = nBits - currentI - 1;

            final int oppositeBit = getBit(oppositeI);
            action++;

            if (!knowD && bit != oppositeBit) {
                d1 = currentI;
                d2 = oppositeI;

                knowD = true;
            }

            if (!knowS && bit == oppositeBit) {
                s1 = currentI;
                s2 = oppositeI;

                knowS = true;
            }

            bits[currentI] = bit;
            bits[oppositeI] = oppositeI;

            knowBits += 2;
        }

        answer();
    }

    private int nextIndex(int next) {
        while (bits[next] != -1) {
            next = (next + 1) % (nBits / 2);
        }

        return next;
    }

    private int checkResult() {
        if (knowS) {
            final int bit = getBit(s1);

            if (bit != bits[s1]) {
                for (int i = 0; i < bits.length / 2; i++) {
                    if (bits[i] == bits[nBits - i - 1]) {
                        int newVal = bits[i] == 0 ? 1 : 0;
                        bits[i] = newVal;
                        bits[nBits - i - 1] = newVal;
                    }
                }
            }
        } else {
            resetSame();
        }

        if (knowD) {
            final int bit = getBit(d1);

            if (bit != bits[d1]) {
                for (int i = 0; i < bits.length / 2; i++) {
                    if (bits[i] != bits[nBits - i - 1]) {
                        int newVal = bits[i] == 0 ? 1 : 0;
                        bits[i] = newVal;
                        bits[nBits - i - 1] = newVal;
                    }
                }
            }
        } else {
            resetDiff();
        }
        return 0;
    }

    private void resetSame() {
        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] == bits[nBits - i - 1]) {
                bits[i] = -1;
                bits[nBits - i - 1] = -1;

                knowBits -= 2;
            }
        }
    }

    private void resetDiff() {
        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] != bits[nBits - i - 1]) {
                bits[i] = -1;
                bits[nBits - i - 1] = -1;

                knowBits -= 2;
            }
        }
    }

    private void answer() {
        for (int i = 0; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
        System.out.println();
        System.out.flush();

        final String s = in.nextLine();

        if (s.equals("N")) System.exit(0);
    }

    private int getBit(int currentBit) {
        System.out.println(currentBit);
        System.out.flush();
        return in.nextInt();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            final Solution solution = new Solution(t + 1, N, in);

            solution.solve();
        }
    }
}
