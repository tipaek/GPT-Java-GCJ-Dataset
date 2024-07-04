import java.io.*;
import java.util.*;

class Solution {
    public static boolean check(int[] matrix, int size, int targetTrace) {
        int trace = 0;
        for (int i = 0; i < size * size; i += (size + 1)) {
            trace += matrix[i];
        }
        if (trace != targetTrace) {
            return false;
        }

        int duplicateRows = 0, duplicateColumns = 0;

        for (int i = 0; i < size * size; i += size) {
            HashMap<Integer, Integer> rowMap = new HashMap<>();
            for (int j = i; j < i + size; j++) {
                if (rowMap.containsKey(matrix[j])) {
                    duplicateRows++;
                    break;
                }
                rowMap.put(matrix[j], 1);
            }
        }

        for (int i = 0; i < size; i++) {
            HashMap<Integer, Integer> colMap = new HashMap<>();
            for (int j = i; j < size * size; j += size) {
                if (colMap.containsKey(matrix[j])) {
                    duplicateColumns++;
                    break;
                }
                colMap.put(matrix[j], 1);
            }
        }

        return trace == targetTrace && duplicateRows == 0 && duplicateColumns == 0;
    }

    public static boolean generate(int[] matrix, int size, int targetTrace, int index, BufferedWriter writer) throws IOException {
        if (index == size * size) {
            if (check(matrix, size, targetTrace)) {
                writer.write("POSSIBLE\n");
                for (int i = 0; i < size * size; i += size) {
                    for (int j = i; j < i + size; j++) {
                        writer.write(matrix[j] + " ");
                    }
                    writer.write("\n");
                }
                return true;
            }
            return false;
        }

        for (int i = 1; i <= size; i++) {
            matrix[index] = i;
            if (generate(matrix, size, targetTrace, index + 1, writer)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        int caseNumber = 1;
        while (testCases-- > 0) {
            writer.write("Case #" + caseNumber + ": ");
            String[] input = reader.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            int targetTrace = Integer.parseInt(input[1]);
            int[] matrix = new int[size * size];
            boolean possible = generate(matrix, size, targetTrace, 0, writer);
            if (!possible) {
                writer.write("IMPOSSIBLE\n");
            }
            caseNumber++;
        }
        writer.flush();
    }
}