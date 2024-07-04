import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int matrixSize = Integer.parseInt(reader.readLine());

            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int trace = 0;

            boolean[][] columnSeen = new boolean[matrixSize][matrixSize + 1];
            boolean[] columnFlags = new boolean[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean rowFlag = false;
                boolean[] rowSeen = new boolean[matrixSize + 1];

                for (int j = 0; j < matrixSize; j++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) trace += value;

                    if (rowSeen[value]) rowFlag = true;
                    else rowSeen[value] = true;

                    if (columnSeen[j][value]) columnFlags[j] = true;
                    else columnSeen[j][value] = true;
                }
                if (rowFlag) rowDuplicates++;
            }

            for (int i = 0; i < matrixSize; i++) {
                if (columnFlags[i]) columnDuplicates++;
            }

            System.out.println(trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}