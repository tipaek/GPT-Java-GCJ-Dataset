import java.util.*;
import java.io.*;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int trace = 0, repeatedRows = 0, repeatedCols = 0;

            boolean[][] colSeen = new boolean[matrixSize][matrixSize + 1];
            boolean[] colFlag = new boolean[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean rowFlag = false;
                boolean[] rowSeen = new boolean[matrixSize + 1];

                for (int j = 0; j < matrixSize; j++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) trace += value;

                    if (rowSeen[value]) rowFlag = true;
                    else rowSeen[value] = true;

                    if (colSeen[j][value]) colFlag[j] = true;
                    else colSeen[j][value] = true;
                }
                if (rowFlag) repeatedRows++;
            }

            for (int i = 0; i < matrixSize; i++) {
                if (colFlag[i]) repeatedCols++;
            }

            System.out.println(trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}