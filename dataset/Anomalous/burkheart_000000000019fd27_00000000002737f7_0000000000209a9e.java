import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    
    private static int B;
    private static char[] b; // hidden
    private static int numQueries = 0;
    private static String lastAction = "";
    private static boolean SIMULATE_TEST_CASES = false;
    private static boolean USE_LOCAL_JUDGE = false;
    private static Scanner in = null;
    private static PrintStream out = null;
    private static Process judgeProcess = null;

    public static void main(String[] args) throws IOException {
        int tmax;

        if (!USE_LOCAL_JUDGE) {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        } else {
            judgeProcess = Runtime.getRuntime().exec("python src/judge.py 2");
            in = new Scanner(new BufferedReader(new InputStreamReader(judgeProcess.getInputStream())));
            out = new PrintStream(judgeProcess.getOutputStream());
        }

        if (!SIMULATE_TEST_CASES) {
            tmax = in.nextInt();
            B = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                solve();
            }
        } else {
            tmax = 1000;
            B = 10;
            for (int t = 1; t <= tmax; ++t) {
                b = new char[B];
                for (int i = 0; i < B; i++) {
                    b[i] = Math.random() < 0.5 ? '1' : '0';
                }
                System.err.println("DEBUG:   B: " + new String(b) + " - orig");
                solve();
            }
        }
    }

    private static void sendToJudge(String val) {
        out.println(val);
        out.flush();
    }

    private static String retrieveFromJudge() {
        return in.next();
    }

    private static void invert(char[] c) {
        for (int i = 0; i < B; i++) {
            c[i] = c[i] == '1' ? '0' : c[i] == '0' ? '1' : '.';
        }
    }

    private static void revert(char[] c) {
        for (int i = 0; i < B / 2; i++) {
            char tmp = c[i];
            c[i] = c[B - 1 - i];
            c[B - 1 - i] = tmp;
        }
    }

    private static char query(int pos) {
        numQueries++;
        assert numQueries <= 150;

        char res;
        if (!SIMULATE_TEST_CASES) {
            sendToJudge(String.valueOf(pos + 1));
            String val = retrieveFromJudge();
            res = val.charAt(0);
            assert res == '1' || res == '0';
        } else {
            if (numQueries % 10 == 1) {
                lastAction = "nothing";
                double rnd = Math.random();
                if (rnd < 0.25) {
                    revert(b);
                    lastAction = "revert";
                } else if (rnd < 0.5) {
                    invert(b);
                    lastAction = "invert";
                } else if (rnd < 0.75) {
                    invert(b);
                    revert(b);
                    lastAction = "re/in-vert";
                }
                System.err.println("DEBUG:   B: " + new String(b) + " - " + lastAction);
            }
            res = b[pos];
        }

        System.err.println("DEBUG:   > Query #" + numQueries + " for pos " + pos + ": " + res);
        return res;
    }

    private static void solve() {
        char[] res = new char[B];
        for (int i = 0; i < B; i++) res[i] = '.';

        System.err.println("DEBUG: RES: " + new String(res) + " - orig");

        boolean isAsym = false;
        int posSame = -1;
        char valSame = '.';
        int posDiff = -1;
        char valDiff = '.';

        numQueries = 0;
        for (int i = 0; i < 5; i++) {
            int pos1 = i;
            int pos2 = B - 1 - i;
            char b1 = query(pos1);
            char b2 = query(pos2);
            res[pos1] = b1;
            res[pos2] = b2;

            if (b1 != b2) {
                isAsym = true;
                if (posDiff < 0) {
                    posDiff = pos1;
                    valDiff = b1;
                }
            } else {
                if (posSame < 0) {
                    posSame = pos1;
                    valSame = b1;
                }
            }
        }

        System.err.println("DEBUG: RES: " + new String(res) + " - queried");

        int nextPos = 5;
        while (true) {
            String action = "nothing";
            char valSameNew = '.';
            char valDiffNew = '.';
            if (posSame >= 0) valSameNew = query(posSame); else query(B - 1);
            if (posDiff >= 0) valDiffNew = query(posDiff); else query(B - 1);

            System.err.println("DEBUG: isAsym=" + isAsym + " posSame=" + posSame + "/valSame=" + valSame + "->" + valSameNew + " posDiff=" + posDiff + "/valDiff=" + valDiff + "->" + valDiffNew);

            if (isAsym) {
                if (valSameNew == '.') {
                    assert posDiff >= 0;
                    if (valDiffNew != valDiff) {
                        invert(res);
                        action = "revert or invert";
                    } else {
                        action = "nothing or re/in-vert";
                    }
                } else {
                    assert posDiff >= 0;
                    assert posSame >= 0;

                    if ((valDiffNew == valDiff) && (valSameNew != valSame)) {
                        invert(res);
                        revert(res);
                        action = "nothing or re/in-vert";
                    } else if ((valDiffNew != valDiff) && (valSameNew == valSame)) {
                        revert(res);
                        action = "revert";
                    } else if ((valDiffNew != valDiff) && (valSameNew != valSame)) {
                        invert(res);
                        action = "invert";
                    }
                }
            } else {
                assert posDiff < 0;
                assert posSame >= 0;

                if (valSameNew != valSame) {
                    invert(res);
                    action = "invert or re/in-vert";
                } else {
                    action = "nothing or revert";
                }
            }

            System.err.println("DEBUG: RES: " + new String(res) + " - " + action);
            if (SIMULATE_TEST_CASES) assert action.contains(lastAction);

            valSame = valSameNew;
            valDiff = valDiffNew;

            for (int i = nextPos; (i < 4 + nextPos) && (i < B / 2); i++) {
                int pos1 = i;
                int pos2 = B - 1 - i;
                char b1 = query(pos1);
                char b2 = query(pos2);
                res[pos1] = b1;
                res[pos2] = b2;

                if (b1 != b2) {
                    isAsym = true;
                    if (posDiff < 0) {
                        posDiff = pos1;
                        valDiff = b1;
                    }
                } else {
                    if (posSame < 0) {
                        posSame = pos1;
                        valSame = b1;
                    }
                }
            }

            System.err.println("DEBUG: RES: " + new String(res) + " - queried");

            nextPos += 4;
            if (nextPos >= B / 2) {
                if (!SIMULATE_TEST_CASES) {
                    sendToJudge(new String(res));
                    String val = retrieveFromJudge();
                    assert val.contentEquals("Y") || val.contentEquals("N");
                    if (val.equals("N")) {
                        System.err.println("DEBUG: Incorrect");
                        System.exit(0);
                    }
                    System.err.println("DEBUG: Correct");
                    return;
                } else {
                    assert new String(res).equals(new String(b));
                    return;
                }
            }
        }
    }
}