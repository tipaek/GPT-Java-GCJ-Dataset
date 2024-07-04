import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Vestigium solver = new Vestigium();
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader);
        }
    }

    static class Vestigium {

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
            int matrixSize = Integer.parseInt(reader.readLine());
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            HashMap<Integer, ColumnHelper> columnMap = new HashMap<>(matrixSize);
            Set<String> rowSet = new HashSet<>(matrixSize);

            for (int i = 0; i < matrixSize; i++) {
                String[] line = reader.readLine().split(" ");
                trace += Integer.parseInt(line[i]);
                boolean rowHasDuplicates = false;

                for (int j = 0; j < matrixSize; j++) {
                    // Check for row duplicates
                    if (!rowSet.add(line[j])) {
                        rowHasDuplicates = true;
                    }

                    // Check for column duplicates
                    ColumnHelper helper = columnMap.get(j);
                    if (helper == null) {
                        columnMap.put(j, new ColumnHelper(new HashSet<String>() {{
                            add(line[j]);
                        }}));
                    } else {
                        if (helper.isAlive && !helper.items.add(line[j])) {
                            helper.isAlive = false;
                            colRepeats++;
                        }
                    }
                }

                if (rowHasDuplicates) {
                    rowRepeats++;
                }
                rowSet.clear();
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}

class ColumnHelper {
    boolean isAlive = true;
    Set<String> items;

    public ColumnHelper(Set<String> items) {
        this.items = items;
    }
}