import java.io.IOException;
import java.util.Scanner;

/*
 * If all pairs we had were opposites, then reversing is equal to flipping, and reversing+flipping is equal to identity
 * If all pairs we had were equals, then we don't really care about reversing and we just check for flipping
 * If we had at least one of each, we can check with the equals whether a flip happened,
 *  and subsequently we check with the opposites whether reversing (also) happened
 */
public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int T = sc.nextInt(), B = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            new Solution().oneRun(i, B);
        }
    }

    private Qubit[] bits;
    private int counter = 1;
    private void oneRun(int num, int B) {
        bits = new Qubit[B];
        for (int i = 0; i < B; i++) {
            bits[i] = new Qubit();
        }
        boolean allEqual = true, allOpposite = true;
        int index = 0;
        int knownEqualIndex = -1, knownOppositeIndex = -1;

        while (index < B/2) {
            if (counter % 10 == 1 && counter != 1) {
                if (!allOpposite) {
                    int result = oracle(knownEqualIndex);

                    if (result != bits[knownEqualIndex].state) {
                        flipAll();
                    }
                }

                if (!allEqual) {
                    int result = oracle(knownOppositeIndex);

                    if (result != bits[knownOppositeIndex].state) {
                        reverse();
                    }
                }

                if (counter % 10 == 2) {
                    oracle(1); // discard to maintain parity
                }
            } else {
                int first = oracle(index);
                bits[index].state = first;
                int second = oracle(B - 1 - index);
                bits[B - 1 - index].state = second;

                if (first == second && knownEqualIndex == -1) {
                    allOpposite = false;
                    knownEqualIndex = index;
                } else if (knownOppositeIndex == -1){
                    allEqual = false;
                    knownOppositeIndex = index;
                }

                index++;
            }
        }

        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            sol.append(bits[i].state);
        }
        System.out.println(sol.toString());
        if (sc.next().equals('N')) throw new RuntimeException();
    }

    private int oracle(int index) {
		index++;
        System.out.println(index);
        counter++;
        int ret = sc.nextInt();
        return ret;
    }

    private void flipAll() {
        for (int i = 0; i < bits.length; i++) {
            bits[i].flip();
        }
    }

    private void reverse() {
        for (int i = 0; i < bits.length / 2; i++) {
            Qubit t = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = bits[i];
            bits[i] = t;
        }
    }

    static class Qubit {
        int state = -1;

        void flip() {
            if (state != -1) {
                state = 1 - state;
            }
        }
    }
}
