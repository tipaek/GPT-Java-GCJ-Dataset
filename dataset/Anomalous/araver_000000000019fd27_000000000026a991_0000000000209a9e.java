import java.io.*;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;

        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("QR20204.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String NO = "IMPOSSIBLE";

        try {
            if (FROM_FILE) {
                File file = new File("QR20204.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p = line.split("\\s+");
            int tests = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);

            for (int i = 0; i < tests; i++) {
                StringBuilder s = new StringBuilder(b);

                for (int j = 0; j < 10; j++) {
                    bw.write((j + 1) + "\n");
                    bw.flush();
                    line = br.readLine();
                    int bit = Integer.parseInt(line);
                    s.append(bit);
                }

                String answer = s.toString();
                bw.write(answer + "\n");
                bw.flush();

                line = br.readLine();
                if (line.startsWith("N")) {
                    throw new RuntimeException();
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