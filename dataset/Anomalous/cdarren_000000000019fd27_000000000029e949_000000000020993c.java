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

    private BufferedReader rd;
    private Scanner sc = new Scanner(System.in);
    private PrintWriter wr;

    private List<List<Integer>> getMatrix() throws IOException {
        int length = Integer.parseInt(sc.nextLine());
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<Integer> row = new ArrayList<>();
            String[] elements = sc.nextLine().split(" ");
            for (String element : elements) {
                row.add(Integer.parseInt(element));
            }
            matrix.add(row);
        }
        return matrix;
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int numOfMatrices = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numOfMatrices; i++) {
            String result = compute();
            wr.println(String.format("Case #%d: %s", i + 1, result));
        }
        rd.close();
        wr.close();
    }

    private String compute() throws IOException {
        List<List<Integer>> matrix = getMatrix();
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.size(); i++) {
            trace += matrix.get(i).get(i);

            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean columnHasDuplicate = false;

            for (int j = 0; j < matrix.size(); j++) {
                if (!rowSet.add(matrix.get(i).get(j))) {
                    rowHasDuplicate = true;
                }
                if (!columnSet.add(matrix.get(j).get(i))) {
                    columnHasDuplicate = true;
                }
            }

            if (rowHasDuplicate) duplicateRows++;
            if (columnHasDuplicate) duplicateColumns++;
        }

        return String.format("%d %d %d", trace, duplicateRows, duplicateColumns);
    }
}