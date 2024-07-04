import java.io.*;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;

        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("C2020R1CPA.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if (FROM_FILE) {
                File file = new File("C2020R1CPA.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            int tests = Integer.parseInt(line);

            for (int i = 0; i < tests; i++) {
                line = br.readLine();
                String[] p = line.split("\\s+");
                int x = Integer.parseInt(p[0]);
                int y = Integer.parseInt(p[1]);
                String m = p[2];

                int xc = 0, yc = 0, moves = 0;
                boolean found = false;

                for (int j = 0; j < m.length(); j++) {
                    if (xc == x && yc == y) {
                        found = true;
                        break;
                    }

                    char move = m.charAt(j);
                    if (move == 'S') y--;
                    else if (move == 'N') y++;
                    else if (move == 'E') x++;
                    else if (move == 'W') x--;

                    if (Math.abs(x - xc) > Math.abs(y - yc)) {
                        if (x > xc) xc++;
                        else if (x < xc) xc--;
                    } else if (Math.abs(x - xc) < Math.abs(y - yc)) {
                        if (y > yc) yc++;
                        else if (y < yc) yc--;
                    } else {
                        int xp = x, yp = y;
                        if (j + 1 < m.length()) {
                            char nextMove = m.charAt(j + 1);
                            if (nextMove == 'S') yp--;
                            else if (nextMove == 'N') yp++;
                            else if (nextMove == 'E') xp++;
                            else if (nextMove == 'W') xp--;
                        }

                        if (Math.abs(xp - xc) > Math.abs(yp - yc)) {
                            if (xp > xc) xc++;
                            else if (xp < xc) xc--;
                        } else if (Math.abs(xp - xc) < Math.abs(yp - yc)) {
                            if (yp > yc) yc++;
                            else if (yp < yc) yc--;
                        }
                    }

                    moves++;
                }

                if (xc == x && yc == y) {
                    found = true;
                }

                String answer = found ? String.valueOf(moves) : "IMPOSSIBLE";
                bw.write("Case #" + (i + 1) + ": " + answer + "\n");
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