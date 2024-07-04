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
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            boolean isNegativeX = (x < 0);
            boolean isNegativeY = (y < 0);

            x = Math.abs(x);
            y = Math.abs(y);

            if (x == 0) {
                processYAxis(y, isNegativeY);
            } else if (y == 0) {
                processXAxis(x, isNegativeX);
            } else {
                processBothAxes(x, y, isNegativeX, isNegativeY);
            }
        }
    }

    private static void processYAxis(int y, boolean isNegativeY) {
        char[] yBinary = Integer.toBinaryString(y).toCharArray();
        StringBuilder moves = new StringBuilder();

        for (int i = yBinary.length - 1; i >= 0; i--) {
            if (yBinary[i] == '1') {
                moves.append(isNegativeY ? 'S' : 'N');
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(moves.toString());
    }

    private static void processXAxis(int x, boolean isNegativeX) {
        char[] xBinary = Integer.toBinaryString(x).toCharArray();
        StringBuilder moves = new StringBuilder();

        for (int i = xBinary.length - 1; i >= 0; i--) {
            if (xBinary[i] == '1') {
                moves.append(isNegativeX ? 'W' : 'E');
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(moves.toString());
    }

    private static void processBothAxes(int x, int y, boolean isNegativeX, boolean isNegativeY) {
        String xBinary = String.format("%0" + (Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length()) + 1) + "d", Integer.parseInt(Integer.toBinaryString(x)));
        String yBinary = String.format("%0" + (Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length()) + 1) + "d", Integer.parseInt(Integer.toBinaryString(y)));

        char[] xArray = xBinary.toCharArray();
        char[] yArray = yBinary.toCharArray();
        StringBuilder moves = new StringBuilder();

        boolean possible = true;

        for (int i = 0; i < xArray.length - 2; i++) {
            if (xArray[xArray.length - 1 - i] == yArray[yArray.length - 1 - i]) {
                possible = false;
                break;
            }
            if (xArray[xArray.length - 1 - i] == '1') {
                if (xArray[xArray.length - 2 - i] == yArray[yArray.length - 2 - i]) {
                    moves.append('W');
                    xArray[xArray.length - 1 - i] = '0';
                    int idx = xArray.length - 2 - i;
                    while (xArray[idx] == '1') {
                        xArray[idx] = '0';
                        idx--;
                    }
                    xArray[idx] = '1';
                } else {
                    moves.append('E');
                    xArray[xArray.length - 1 - i] = '0';
                }
            } else {
                if (yArray[yArray.length - 2 - i] == xArray[xArray.length - 2 - i]) {
                    moves.append('S');
                    yArray[yArray.length - 1 - i] = '0';
                    int idx = yArray.length - 2 - i;
                    while (yArray[idx] == '1') {
                        yArray[idx] = '0';
                        idx--;
                    }
                    yArray[idx] = '1';
                } else {
                    moves.append('N');
                    yArray[yArray.length - 1 - i] = '0';
                }
            }
        }

        if (!possible) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        if (xArray[1] == '0' && xArray[0] == '0') {
            if (yArray[1] == '0' && yArray[0] == '1') {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (yArray[1] == '1' && yArray[0] == '0') {
                moves.append('N');
            }
        } else if (xArray[1] == '1') {
            if (yArray[1] == '1') {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (yArray[0] == '1') {
                moves.append('E').append('N');
            } else {
                moves.append('E');
            }
        } else {
            if (yArray[1] == '0' && yArray[0] == '1') {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (yArray[1] == '1') {
                moves.append('N').append('E');
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        if (isNegativeX) {
            for (int i = 0; i < moves.length(); i++) {
                if (moves.charAt(i) == 'E') {
                    moves.setCharAt(i, 'W');
                } else if (moves.charAt(i) == 'W') {
                    moves.setCharAt(i, 'E');
                }
            }
        }

        if (isNegativeY) {
            for (int i = 0; i < moves.length(); i++) {
                if (moves.charAt(i) == 'N') {
                    moves.setCharAt(i, 'S');
                } else if (moves.charAt(i) == 'S') {
                    moves.setCharAt(i, 'N');
                }
            }
        }

        System.out.println(moves.toString());
    }
}