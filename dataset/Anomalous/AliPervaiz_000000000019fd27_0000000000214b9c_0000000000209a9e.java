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
            int[] bits = new int[bitLength + 1];
            int sameIndex = -1;
            int diffIndex = -1;

            for (int i = 1; i <= bitLength / 2; i++) {
                writer.println(i);
                writer.flush();
                bits[i] = Integer.parseInt(reader.readLine());

                writer.println(bitLength - i + 1);
                writer.flush();
                bits[bitLength - i + 1] = Integer.parseInt(reader.readLine());

                if (bits[i] == bits[bitLength - i + 1]) {
                    sameIndex = i;
                } else {
                    diffIndex = i;
                }
            }

            boolean flipSames = false;
            boolean flipDiffs = false;

            if (sameIndex != -1) {
                writer.println(sameIndex);
                writer.flush();
                int value = Integer.parseInt(reader.readLine());
                if (bits[sameIndex] != value) {
                    flipSames = true;
                }
            }

            if (diffIndex != -1) {
                writer.println(diffIndex);
                writer.flush();
                int value = Integer.parseInt(reader.readLine());
                if (bits[diffIndex] != value) {
                    flipDiffs = true;
                }
            }

            for (int i = 1; i <= bitLength; i++) {
                if ((bits[i] == bits[bitLength - i + 1] && flipSames) || (bits[i] != bits[bitLength - i + 1] && flipDiffs)) {
                    writer.print(1 - bits[i]);
                } else {
                    writer.print(bits[i]);
                }
            }
            writer.println();
            writer.flush();
            reader.readLine(); // Read the confirmation line
        }

        writer.close();
    }
}