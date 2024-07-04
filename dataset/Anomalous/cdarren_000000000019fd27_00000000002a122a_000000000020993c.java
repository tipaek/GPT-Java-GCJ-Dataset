import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private Scanner scanner = new Scanner(System.in);
    private PrintWriter writer;

    private List<List<Integer>> readMatrix() throws IOException {
        int size = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> row = new ArrayList<>();
            String[] elements = scanner.nextLine().split(" ");
            for (String element : elements) {
                row.add(Integer.parseInt(element));
            }
            matrix.add(row);
        }
        return matrix;
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int numberOfMatrices = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfMatrices; i++) {
            String result = processMatrix();
            writer.println(String.format("Case #%d: %s", i + 1, result));
        }
        reader.close();
        writer.close();
    }

    private String processMatrix() throws IOException {
        List<List<Integer>> matrix = readMatrix();
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.size(); i++) {
            trace += matrix.get(i).get(i);

            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicates = false;

            for (int j = 0; j < matrix.size(); j++) {
                if (!rowSet.add(matrix.get(i).get(j)) && !rowHasDuplicates) {
                    duplicateRows++;
                    rowHasDuplicates = true;
                }

                if (i == 0) {
                    Set<Integer> columnSet = new HashSet<>();
                    for (int k = 0; k < matrix.size(); k++) {
                        columnSet.add(matrix.get(k).get(j));
                    }
                    if (columnSet.size() != matrix.size()) {
                        duplicateColumns++;
                    }
                }
            }
        }

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }
}