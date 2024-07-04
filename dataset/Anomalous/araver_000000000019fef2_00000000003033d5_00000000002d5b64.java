import java.io.*;

public class Solution {

    private static final boolean FROM_FILE = false;
    private static int[] ax, ay, globalSolX, globalSolY, swapX, swapY, tempX, tempY;
    private static int r, s, maxOp, globalSolMoves;

    private static boolean checkSolution() {
        for (int index = 0, j = 1; j <= r; j++) {
            for (int k = 1; k <= s; k++) {
                if (ax[index] != j) return false;
                index++;
            }
        }
        return true;
    }

    private static void swap(int a, int b) {
        System.arraycopy(ax, 0, tempX, 0, a);
        System.arraycopy(ay, 0, tempY, 0, a);
        System.arraycopy(ax, a, ax, 0, b);
        System.arraycopy(ay, a, ay, 0, b);
        System.arraycopy(tempX, 0, ax, b, a);
        System.arraycopy(tempY, 0, ay, b, a);
    }

    private static void back(int moves) {
        if (moves >= globalSolMoves) return;

        if (checkSolution()) {
            globalSolMoves = moves;
            System.arraycopy(swapX, 0, globalSolX, 0, globalSolMoves);
            System.arraycopy(swapY, 0, globalSolY, 0, globalSolMoves);
            return;
        }

        for (int i = 1; i < maxOp; i++) {
            for (int j = 1; j <= maxOp - i; j++) {
                if (moves == 0 || i != swapY[moves - 1] || j != swapX[moves - 1]) {
                    swapX[moves] = i;
                    swapY[moves] = j;
                    swap(i, j);
                    back(moves + 1);
                    swap(j, i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;

        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("C2020R1BPC.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if (FROM_FILE) {
                File file = new File("C2020R1BPC.out");
                if (!file.exists()) file.createNewFile();
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                String[] p = br.readLine().split("\\s+");
                r = Integer.parseInt(p[0]);
                s = Integer.parseInt(p[1]);
                maxOp = r * s;

                ax = new int[maxOp];
                ay = new int[maxOp];

                for (int index = 0, j = 1; j <= s; j++) {
                    for (int k = 1; k <= r; k++) {
                        ax[index] = k;
                        ay[index] = j;
                        index++;
                    }
                }

                globalSolMoves = maxOp + 1;
                globalSolX = new int[globalSolMoves];
                globalSolY = new int[globalSolMoves];
                swapX = new int[globalSolMoves];
                swapY = new int[globalSolMoves];
                tempX = new int[globalSolMoves];
                tempY = new int[globalSolMoves];
                back(0);

                if (globalSolMoves <= maxOp) {
                    bw.write("Case #" + (i + 1) + ": " + globalSolMoves + "\n");
                    for (int j = 0; j < globalSolMoves; j++) {
                        bw.write(globalSolX[j] + " " + globalSolY[j] + "\n");
                    }
                } else {
                    throw new RuntimeException("XXX");
                }
                bw.flush();
            }

            if (FROM_FILE) {
                bw.close();
            }
        } finally {
            if (FROM_FILE) {
                br.close();
            }
        }
    }
}