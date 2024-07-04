import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static int flagWrongSet(int[] row, int n) {
        Arrays.sort(row);
        for (int i = 0; i < n; i++) {
            if (row[i] != (i + 1)) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FROM_FILE ? new BufferedReader(new FileReader("QR20202.in"))
                                      : new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;

        try {
            if (FROM_FILE) {
                File file = new File("QR20202.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                String line = br.readLine();
                int n = line.length();

                StringBuilder s = new StringBuilder();
                int depth = 0;

                for (int j = 0; j < n; j++) {
                    int d = line.charAt(j) - '0';

                    if (d > depth) {
                        s.append("(".repeat(d - depth));
                    } else if (d < depth) {
                        s.append(")".repeat(depth - d));
                    }

                    depth = d;
                    s.append(d);
                }

                s.append(")".repeat(depth));

                String answer = s.toString();
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