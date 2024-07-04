import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] input = in.readLine().split("\\s+");
        int TT = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);
        int step = (1000000000 - A) / 2;

        for (int currTT = 0; currTT < TT; currTT++) {
            int iStep = step;
            int jStep = step;
            boolean solved = false;
            int i = 0, j = 0, tries = 0;

            while (tries < 300 && !solved) {
                out.println(i + " " + j);
                out.flush();
                String ans = in.readLine();

                if (ans.equals("CENTER")) {
                    break;
                }

                if (ans.equals("MISS")) {
                    if (tryMove(i + step, j + step, in, out)) {
                        i += step;
                        j += step;
                    } else if (tryMove(i + step, j - step, in, out)) {
                        i += step;
                        j -= step;
                        jStep = -step;
                    } else if (tryMove(i - step, j + step, in, out)) {
                        i -= step;
                        j += step;
                        iStep = -step;
                    } else if (tryMove(i - step, j - step, in, out)) {
                        i -= step;
                        j -= step;
                        iStep = -step;
                        jStep = -step;
                    }
                    tries++;
                }

                solved = ans.equals("CENTER");
                iStep /= 2;
                jStep /= 2;
                i += iStep;
                j += jStep;
            }
        }

        in.close();
        out.close();
    }

    private static boolean tryMove(int i, int j, BufferedReader in, PrintWriter out) throws Exception {
        out.println(i + " " + j);
        out.flush();
        String ans = in.readLine();
        return !ans.equals("MISS");
    }
}