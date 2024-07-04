import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int X = Integer.parseInt(tokenizer.nextToken());
            int Y = Integer.parseInt(tokenizer.nextToken());

            boolean isXNegative = X < 0;
            boolean isYNegative = Y < 0;

            X = Math.abs(X);
            Y = Math.abs(Y);

            if (X == 0) {
                System.out.println(getVerticalMoves(Y, isYNegative));
            } else if (Y == 0) {
                System.out.println(getHorizontalMoves(X, isXNegative));
            } else {
                String result = getCombinedMoves(X, Y, isXNegative, isYNegative);
                System.out.println(result != null ? result : "IMPOSSIBLE");
            }
        }
    }

    private static String getVerticalMoves(int Y, boolean isYNegative) {
        char move = isYNegative ? 'S' : 'N';
        StringBuilder moves = new StringBuilder();

        for (char bit : Integer.toBinaryString(Y).toCharArray()) {
            if (bit == '1') {
                moves.append(move);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return moves.toString();
    }

    private static String getHorizontalMoves(int X, boolean isXNegative) {
        char move = isXNegative ? 'W' : 'E';
        StringBuilder moves = new StringBuilder();

        for (char bit : Integer.toBinaryString(X).toCharArray()) {
            if (bit == '1') {
                moves.append(move);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return moves.toString();
    }

    private static String getCombinedMoves(int X, int Y, boolean isXNegative, boolean isYNegative) {
        String binaryX = Integer.toBinaryString(X);
        String binaryY = Integer.toBinaryString(Y);

        while (binaryX.length() < binaryY.length()) {
            binaryX = "0" + binaryX;
        }
        while (binaryY.length() < binaryX.length()) {
            binaryY = "0" + binaryY;
        }

        char[] xBits = binaryX.toCharArray();
        char[] yBits = binaryY.toCharArray();
        StringBuilder moves = new StringBuilder();
        boolean possible = true;

        for (int i = 0; i < xBits.length - 2; i++) {
            if (xBits[xBits.length - 1 - i] == yBits[yBits.length - 1 - i]) {
                possible = false;
                break;
            }
            if (xBits[xBits.length - 1 - i] == '1') {
                if (xBits[xBits.length - 1 - i - 1] == yBits[yBits.length - 1 - i - 1]) {
                    moves.append('W');
                    xBits[xBits.length - 1 - i] = '0';
                    int idx = xBits.length - 1 - i - 1;
                    while (xBits[idx] == '1') {
                        xBits[idx] = '0';
                        idx--;
                    }
                    xBits[idx] = '1';
                } else {
                    moves.append('E');
                    xBits[xBits.length - 1 - i] = '0';
                }
            } else {
                if (yBits[yBits.length - 1 - i - 1] == xBits[xBits.length - 1 - i - 1]) {
                    moves.append('S');
                    yBits[yBits.length - 1 - i] = '0';
                    int idx = yBits.length - 1 - i - 1;
                    while (yBits[idx] == '1') {
                        yBits[idx] = '0';
                        idx--;
                    }
                    yBits[idx] = '1';
                } else {
                    moves.append('N');
                    yBits[yBits.length - 1 - i] = '0';
                }
            }
        }

        if (!possible) {
            return null;
        }

        if ((xBits[1] == '1' && xBits[0] == '1') || (yBits[1] == '1' && yBits[0] == '1')) {
            return null;
        }

        if (xBits[1] == '0' && xBits[0] == '0') {
            if (yBits[1] == '0' && yBits[0] == '1') {
                return null;
            }
            if (yBits[1] == '1' && yBits[0] == '0') {
                moves.append('N');
            }
        } else if (xBits[1] == '1') {
            if (yBits[1] == '1') {
                return null;
            }
            if (yBits[0] == '1') {
                moves.append('E');
                moves.append('N');
            } else {
                moves.append('E');
            }
        } else {
            if (yBits[1] == '0' && yBits[0] == '1') {
                return null;
            }
            if (yBits[1] == '1') {
                moves.append('N');
                moves.append('E');
            } else {
                return null;
            }
        }

        if (isXNegative) {
            for (int i = 0; i < moves.length(); i++) {
                if (moves.charAt(i) == 'E') {
                    moves.setCharAt(i, 'W');
                } else if (moves.charAt(i) == 'W') {
                    moves.setCharAt(i, 'E');
                }
            }
        }

        if (isYNegative) {
            for (int i = 0; i < moves.length(); i++) {
                if (moves.charAt(i) == 'N') {
                    moves.setCharAt(i, 'S');
                } else if (moves.charAt(i) == 'S') {
                    moves.setCharAt(i, 'N');
                }
            }
        }

        return moves.toString();
    }
}