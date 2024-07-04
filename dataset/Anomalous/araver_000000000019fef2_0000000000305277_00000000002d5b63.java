import java.io.*;

public class Solution {

    private static final boolean FROM_FILE = false;
    private static final int MAX = 1_000_000_000;

    public static int calculateCenter(int[] coordinates, int count) {
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += coordinates[i];
        }
        return (int) (sum / count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        BufferedWriter writer;

        if (FROM_FILE) {
            reader = new BufferedReader(new FileReader("C2020R1BPB.in"));
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if (FROM_FILE) {
                File outputFile = new File("C2020R1BPB.out");
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }
                writer = new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));
            } else {
                writer = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String[] input = reader.readLine().split("\\s+");
            int testCases = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            for (int i = 0; i < testCases; i++) {
                int foundPoints = 0;
                int x = -MAX;
                int y = -MAX;
                int density = (MAX - 5) / 2;
                int[] cx = new int[1000];
                int[] cy = new int[1000];
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

                    writer.write(x + " " + y + "\n");
                    writer.flush();

                    String response = reader.readLine().toUpperCase();
                    if (response.startsWith("CENTER")) {
                        break;
                    } else if (response.startsWith("HIT")) {
                        // Handle hits if necessary
                    } else if (response.startsWith("MISS")) {
                        cx[foundPoints] = x;
                        cy[foundPoints] = y;
                        foundPoints++;
                    } else if (response.startsWith("WRONG")) {
                        throw new RuntimeException("Unexpected response: WRONG");
                    }
                }
            }

            if (FROM_FILE) {
                writer.close();
            }
        } finally {
            if (FROM_FILE) {
                reader.close();
            }
        }
    }
}