import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for (int t1 = 1; t1 <= t; t1++) {
            StringTokenizer tokenizer = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int oldX = x;
            int oldY = y;
            x = Math.abs(x);
            y = Math.abs(y);

            int numOfMoves = Integer.MAX_VALUE;
            ArrayList<boolean[]> bestMoves = new ArrayList<boolean[]>();

            ArrayList<boolean[]> filledTilesX = new ArrayList<boolean[]>();
            boolean[] binary = new boolean[30];
            fillInBinary(binary, x);
            filledTilesX.add(binary);
            filledTilesX.add(new boolean[30]);
            int power = getSmallestPowerOfTwoBiggerThan(x);
            while (power <= 1000000000) {
                boolean[] binary1 = new boolean[30];
                fillInBinary(binary1, power);
                boolean[] binary2 = new boolean[30];
                fillInBinary(binary2, power - x);
                filledTilesX.add(binary1);
                filledTilesX.add(binary2);
                power *= 2;
            }

            ArrayList<boolean[]> filledTilesY = new ArrayList<boolean[]>();
            binary = new boolean[30];
            fillInBinary(binary, y);
            filledTilesY.add(binary);
            filledTilesY.add(new boolean[30]);
            power = getSmallestPowerOfTwoBiggerThan(y);
            while (power <= 1000000000) {
                boolean[] binary1 = new boolean[30];
                fillInBinary(binary1, power);
                boolean[] binary2 = new boolean[30];
                fillInBinary(binary2, power - y);
                filledTilesY.add(binary1);
                filledTilesY.add(binary2);
                power *= 2;
            }

            for (int i = 0; i < filledTilesX.size(); i += 2) {
                boolean[] binary1 = filledTilesX.get(i);
                boolean[] binary2 = filledTilesX.get(i + 1);
                for (int j = 0; j < filledTilesY.size(); j += 2) {
                    boolean[] binary3 = filledTilesY.get(j);
                    boolean[] binary4 = filledTilesY.get(j + 1);
                    if (solutionIsLegal(binary1, binary2, binary3, binary4)) {
                        if (getMoves(binary1, binary2, binary3, binary4) < numOfMoves) {
                            numOfMoves = getMoves(binary1, binary2, binary3, binary4);
                            bestMoves.add(binary1);
                            bestMoves.add(binary2);
                            bestMoves.add(binary3);
                            bestMoves.add(binary4);
                        }
                    }
                }
            }

            out.print("Case #" + t1 + ": ");
            if (numOfMoves == Integer.MAX_VALUE) {
                out.println("IMPOSSIBLE");
            } else {
                char[] moves = new char[numOfMoves];
                for (int i = 0; i < bestMoves.get(0).length; i++) {
                    if (bestMoves.get(0)[i]) {
                        if (oldX >= 0) {
                            moves[i] = 'E';
                        } else {
                            moves[i] = 'W';
                        }
                    } else if (bestMoves.get(1)[i]) {
                        if (oldX >= 0) {
                            moves[i] = 'W';
                        } else {
                            moves[i] = 'E';
                        }
                    } else if (bestMoves.get(2)[i]) {
                        if (oldY >= 0) {
                            moves[i] = 'N';
                        } else {
                            moves[i] = 'S';
                        }
                    } else if (bestMoves.get(3)[i]) {
                        if (oldY >= 0) {
                            moves[i] = 'S';
                        } else {
                            moves[i] = 'N';
                        }
                    }
                }

                out.println(new String(moves));
            }
        }

        out.close();
    }

    private static int getMoves(boolean[] b1, boolean[] b2, boolean[] b3, boolean[] b4) {
        int moves = 0;
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] || b2[i] || b3[i] || b4[i]) {
                moves++;
            }
        }

        return moves;
    }

    private static boolean solutionIsLegal(boolean[] b1, boolean[] b2, boolean[] b3, boolean[] b4) {
        boolean hasEnded = false;
        for (int i = 0; i < b1.length; i++) {
            int num = 0;
            if (b1[i]) {
                num++;
            }
            if (b2[i]) {
                num++;
            }
            if (b3[i]) {
                num++;
            }
            if (b4[i]) {
                num++;
            }

            if (num > 1) {
                return false;
            }
            if (hasEnded && num != 0) {
                return false;
            }
            if (num == 0) {
                hasEnded = true;
            }
        }

        return true;
    }

    private static boolean binariesOverlap(boolean[] b1, boolean[] b2) {
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] && b2[i]) {
                System.out.println(b1[i] + " " + b2[i]);
                return true;
            }
        }

        return false;
    }

    private static void fillInBinary(boolean[] binary, int num) {
        int index = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                binary[index] = true;
            }
            index++;
            num /= 2;
        }
    }
    private static int getSmallestPowerOfTwoBiggerThan(int num) {
        int power = 1;
        while (power <= num) {
            power *= 2;
        }

        return power;
    }
}
