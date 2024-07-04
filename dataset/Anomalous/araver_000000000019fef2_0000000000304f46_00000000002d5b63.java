import java.io.*;

public class Solution {

    private static final boolean FROM_FILE = false;
    private static final int MAX = 1_000_000_000;

    private static int calculateCenter(int[] coordinates, int count) {
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += coordinates[i];
        }
        return (int) (sum / count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;

        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("C2020R1BPB.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if (FROM_FILE) {
                File file = new File("C2020R1BPB.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] params = line.split("\\s+");
            int tests = Integer.parseInt(params[0]);
            int a = Integer.parseInt(params[1]);
            int b = Integer.parseInt(params[2]);

            for (int i = 0; i < tests; i++) {
                int foundPoints = 0;
                int x = -MAX;
                int y = -MAX;
                int density = (MAX - 5) / 2;
                int[] cx = new int[3];
                int[] cy = new int[3];
                boolean finishedTable = false;

                for (int c = 0; c < 300; c++) {
                    if (!finishedTable) {
                        x += density;
                        if (x > MAX) {
                            x = -MAX + density;
                            y += density;
                        }

                        if (y > MAX) {
                            finishedTable = true;
                        }
                    }

                    if (finishedTable) {
                        x = calculateCenter(cx, foundPoints);
                        y = calculateCenter(cy, foundPoints);
                    }

                    bw.write(x + " " + y + "\n");
                    bw.flush();

                    line = br.readLine().toUpperCase();
                    if (line.startsWith("CENTER")) {
                        break;
                    } else if (line.startsWith("HIT")) {
                        // Handle HIT case if needed
                    } else if (line.startsWith("MISS")) {
                        cx[foundPoints] = x;
                        cy[foundPoints] = y;
                        foundPoints++;
                    } else if (line.startsWith("WRONG")) {
                        throw new RuntimeException("Unexpected 'WRONG' response!");
                    }
                }
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