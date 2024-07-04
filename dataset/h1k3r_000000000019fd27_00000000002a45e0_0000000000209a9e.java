import java.util.Scanner;

class Solution
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
                boolean complemented = false;
                boolean reversed = false;
                if (symmetryBit > -1) {
                    char symmetryBitVal = readBit(input,symmetryBit + 1);
                    queryCount++;

                    complemented = symmetryBitVal != bits[symmetryBit];
                } else {
                    readBit(input, 1);
                    queryCount++;
                }
                if (unSymmetryBit > -1) {
                    char unSymmetryBitVal = readBit(input,unSymmetryBit + 1);
                    queryCount++;

                    reversed = (!complemented && (unSymmetryBitVal != bits[unSymmetryBit])) || (complemented && (unSymmetryBitVal == bits[unSymmetryBit]));
                } else {
                    readBit(input, 1);
                    queryCount++;
                }
                if (complemented) {
                    for (int i = 0; i < B; i++) {
                        if (bits[i] == '0') {
                            bits[i] = '1';
                        } else if (bits[i] == '1') {
                            bits[i] = '0';
                        }
                    }
                }
                if (reversed) {
                    for (int i = 0; i < discoveredBits / 2; i++) {
                        int newPos = B - i - 1;
                        char t = bits[i];
                        bits[i] = bits[newPos];
                        bits[newPos] = t;
                    }
                    if (discoveredBits % 2 == 1) {
                        discoveredBits--;
                    }
                }

            } else {
                int nextPos = (discoveredBits % 2 == 0) ? discoveredBits / 2 + 1 : B - discoveredBits / 2;

                bits[nextPos - 1] = readBit(input, nextPos);
                queryCount++;
                discoveredBits++;
                if (discoveredBits % 2 == 0) {
                    int previousPos = (discoveredBits - 1) / 2;
                    if (symmetryBit < 0) {
                        if (bits[previousPos] == bits[nextPos - 1]) {
                            symmetryBit = previousPos;
                        }
                    }
                    if (unSymmetryBit < 0) {
                        if (bits[previousPos] != bits[nextPos - 1]) {
                            unSymmetryBit = previousPos;
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
