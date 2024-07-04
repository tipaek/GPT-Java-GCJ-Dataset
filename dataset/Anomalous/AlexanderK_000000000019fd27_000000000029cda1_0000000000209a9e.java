import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            process(reader);
        }
    }

    public static void process(BufferedReader reader) throws IOException, InterruptedException {
        String[] input = reader.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int i = 0; i < testCases; i++) {
            new Interaction().solve(reader, bitLength);
        }
    }

    static class Interaction {

        private BufferedReader reader;
        private int queryCount = 0;

        private char query(int position) throws IOException, InterruptedException {
            queryCount++;
            System.out.println(position + 1);
            return reader.readLine().charAt(0);
        }

        public void solve(BufferedReader reader, int bitLength) throws IOException, InterruptedException {
            this.reader = reader;
            List<int[]> transformations = new ArrayList<>();
            char[] bits = new char[bitLength];
            int[] transformIndices = new int[bitLength];
            int differentPosition = -1, samePosition = -1;
            char differentValue = 0, sameValue = 0;

            for (int i = 0; i < bitLength; i++) {
                if (queryCount % 10 == 0 && i > 0) {
                    int[] transform = {-1, -1};
                    if (differentPosition != -1) {
                        char value = query(differentPosition);
                        transform[0] = value == differentValue ? 0 : 1;
                        differentValue = value;
                    }
                    if (samePosition != -1) {
                        char value = query(samePosition);
                        transform[1] = value == sameValue ? 0 : 1;
                        sameValue = value;
                    }
                    if (queryCount % 2 == 1) {
                        query(0);
                    }
                    transformations.add(transform);
                }

                int position = i % 2 == 0 ? i / 2 : bitLength - (i / 2) - 1;
                bits[position] = query(position);
                transformIndices[position] = transformations.size();

                if (i % 2 == 1) {
                    if (differentPosition == -1 && bits[position] != bits[bitLength - position - 1]) {
                        differentPosition = bitLength - position - 1;
                        differentValue = bits[differentPosition];
                    }
                    if (samePosition == -1 && bits[position] == bits[bitLength - position - 1]) {
                        samePosition = bitLength - position - 1;
                        sameValue = bits[samePosition];
                    }
                }
            }

            char[] result = new char[bitLength];
            for (int i = 0; i < bitLength; i++) {
                char[] values = {bits[i / 2], bits[bitLength - i / 2 - 1]};
                for (int j = transformIndices[i / 2]; j < transformations.size(); j++) {
                    int[] transform = transformations.get(j);
                    int differentChanged = transform[0];
                    int sameChanged = transform[1];

                    if (sameChanged == -1) {
                        sameChanged = differentChanged;
                    }
                    if (differentChanged == -1) {
                        differentChanged = sameChanged;
                    }
                    if (sameChanged == 1) {
                        values[0] = values[0] == '0' ? '1' : '0';
                        values[1] = values[1] == '0' ? '1' : '0';
                    }
                    if (differentChanged != sameChanged) {
                        char temp = values[1];
                        values[1] = values[0];
                        values[0] = temp;
                    }
                }
                result[i / 2] = values[0];
                result[bitLength - i / 2 - 1] = values[1];
            }

            System.out.println(new String(result));
            String feedback = reader.readLine();
            if (!feedback.equals("Y")) {
                System.exit(-1);
            }
        }
    }
}