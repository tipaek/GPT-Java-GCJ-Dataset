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

            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                String[] input = br.readLine().split("\\s+");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                String moves = input[2];

                int xc = 0, yc = 0, steps = 0;
                boolean found = false;

                for (int j = 0; j < moves.length(); j++) {
                    if (xc == x && yc == y) {
                        found = true;
                        break;
                    }

                    char move = moves.charAt(j);
                    switch (move) {
                        case 'S': y--; break;
                        case 'N': y++; break;
                        case 'E': x++; break;
                        case 'W': x--; break;
                    }

                    if (Math.abs(x - xc) >= Math.abs(y - yc)) {
                        if (x > xc) {
                            xc++;
                        } else if (x < xc) {
                            xc--;
                        }
                    } else {
                        if (y > yc) {
                            yc++;
                        } else if (y < yc) {
                            yc--;
                        }
                    }

                    steps++;
                }

                if (xc == x && yc == y) {
                    found = true;
                }

                String answer = found ? String.valueOf(steps) : "IMPOSSIBLE";
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