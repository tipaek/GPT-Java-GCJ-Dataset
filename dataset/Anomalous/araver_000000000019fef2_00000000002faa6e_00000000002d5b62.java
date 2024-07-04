import java.io.*;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = FROM_FILE ? new BufferedReader(new FileReader("C2020R1BPA.in"))
                                      : new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;

        try {
            if (FROM_FILE) {
                File file = new File("C2020R1BPA.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                String[] p = br.readLine().split("\\s+");
                int x = Integer.parseInt(p[0]);
                int y = Integer.parseInt(p[1]);

                int max = Math.abs(x) + Math.abs(y);

                if (max == 0) {
                    bw.write("Case #" + (i + 1) + ":\n");
                    bw.flush();
                    continue;
                }

                int minSteps = Integer.SIZE - Integer.numberOfLeadingZeros(max + 1);
                boolean checkDirect = ((max + 1 & max) == 0);

                if (checkDirect) minSteps--;

                StringBuilder s = new StringBuilder(minSteps + 1);
                int move = 1 << (minSteps - 1);

                while (move > 0) {
                    if (Math.abs(x) >= Math.abs(y)) {
                        if (x > 0) {
                            s.append("E");
                            x -= move;
                        } else {
                            s.append("W");
                            x += move;
                        }
                    } else {
                        if (y > 0) {
                            s.append("N");
                            y -= move;
                        } else {
                            s.append("S");
                            y += move;
                        }
                    }
                    move >>= 1;
                }

                String answer = (x == 0 && y == 0) ? s.reverse().toString() : "IMPOSSIBLE";

                bw.write("Case #" + (i + 1) + ": " + answer + "\n");
                bw.flush();
            }

        } finally {
            if (FROM_FILE) {
                if (br != null) br.close();
                if (bw != null) bw.close();
            }
        }
    }
}