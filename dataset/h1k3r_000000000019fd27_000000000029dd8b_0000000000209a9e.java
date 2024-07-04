import java.util.Scanner;

public class Solution
{

    private static class WrongGuess extends Exception {};

    private static void solve(Scanner input, int B) throws WrongGuess
    {
        int discoveredBits = 0;
        int queryCount = 1;
        char[] bits = new char[B];
        int unSymmetryBit = -1;
        int symmetryBit = -1;

        while (queryCount <= 150) {

            if (queryCount % 10 == 1 && queryCount > 10) {
                // there is symmetry bit - check for
                if (symmetryBit > -1) {
                    if (readBit(input,symmetryBit + 1) != bits[symmetryBit]) {
                        for (int i = 0; i < B; i++) {
                            if (bits[i] == '0') {
                                bits[i] = '1';
                            } else if (bits[i] == '1') {
                                bits[i] = '0';
                            }
                        }
                    }
                }
                if (unSymmetryBit > -1) {
                    if (readBit(input,unSymmetryBit + 1) != bits[unSymmetryBit]) {
                        for (int i = 0; i < B / 2; i++) {
                            char t = bits[i];
                            bits[i] = bits[B - i - 1];
                            bits[B - i - 1] = t;
                        }
                    }
                }

                // find change and update array
            } else {
                int nextPos = (discoveredBits % 2 == 0) ? discoveredBits / 2 + 1 : B - discoveredBits / 2;

                bits[nextPos - 1] = readBit(input, nextPos);
                discoveredBits++;
                if (discoveredBits % 2 == 0) {
                    if (symmetryBit < 0) {
                        if (bits[(discoveredBits - 1) / 2] == bits[nextPos - 1]) {
                            symmetryBit = (discoveredBits - 1) / 2;
                        }
                    }
                    if (unSymmetryBit < 0) {
                        if (bits[(discoveredBits - 1) / 2] != bits[nextPos - 1]) {
                            unSymmetryBit = (discoveredBits - 1) / 2;
                        }
                    }
                }


                if (discoveredBits >= B) {
                    System.out.println(new String(bits));

                    String s = input.next();
                    if (s.equals("N")) {
                        throw new WrongGuess();
                    }
                    return;
                }
            }

            queryCount++;
        }
    }

    private static char readBit(Scanner input, int pos)
    {
        System.out.println(pos);
        return input.next().charAt(0);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        try {
            for (int ks = 1; ks <= T; ks++) {
                solve(input, B);
            }
        } catch (WrongGuess e) {
            return;
        }
    }

}
