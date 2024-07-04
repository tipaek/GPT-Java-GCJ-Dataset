import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int testCases = Integer.parseInt(tokenizer.nextToken());
        int bitLength = Integer.parseInt(tokenizer.nextToken());

        while (testCases-- > 0) {
            boolean[] bits = new boolean[bitLength + 1];
            int sameIndex = -1;
            int diffIndex = -1;

            for (int i = 1; i <= bitLength / 2; i++) {
                writer.println(i);
                writer.flush();
                bits[i] = Integer.parseInt(reader.readLine()) == 1;

                writer.println(bitLength - i + 1);
                writer.flush();
                bits[bitLength - i + 1] = Integer.parseInt(reader.readLine()) == 1;

                if (bits[i] == bits[bitLength - i + 1]) {
                    sameIndex = i;
                } else {
                    diffIndex = i;
                }
            }

            boolean flipSameBits = false;
            boolean flipDiffBits = false;

            if (sameIndex != -1) {
                writer.println(sameIndex);
                writer.flush();
                boolean value = Integer.parseInt(reader.readLine()) == 1;
                if (bits[sameIndex] != value) {
                    flipSameBits = true;
                }
            }

            if (diffIndex != -1) {
                writer.println(diffIndex);
                writer.flush();
                boolean value = Integer.parseInt(reader.readLine()) == 1;
                if (bits[diffIndex] != value) {
                    flipDiffBits = true;
                }
            }

            for (int i = 1; i <= bitLength; i++) {
                if ((bits[i] == bits[bitLength - i + 1] && flipSameBits) || (bits[i] != bits[bitLength - i + 1] && flipDiffBits)) {
                    writer.print(bits[i] ? 0 : 1);
                } else {
                    writer.print(bits[i] ? 1 : 0);
                }
            }

            writer.println();
            writer.flush();

            String response = reader.readLine();
            if (response.equals("N")) {
                break;
            }
        }

        writer.close();
    }
}