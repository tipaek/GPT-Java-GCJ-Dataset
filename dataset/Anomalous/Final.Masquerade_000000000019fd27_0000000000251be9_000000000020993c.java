import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            Vestigium solver = new Vestigium();
            int testCount = Integer.parseInt(in.readLine());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in);
            }
        }
    }

    static class Vestigium {

        public void solve(int testCaseNumber, BufferedReader in) throws IOException {
            int N = Integer.parseInt(in.readLine());
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            HashMap<Integer, ColumnHelper> columnMap = new HashMap<>(N);
            Set<String> rowSet = new HashSet<>(N);

            for (int i = 0; i < N; i++) {
                String[] line = in.readLine().split(" ");
                trace += Integer.parseInt(line[i]);
                boolean rowHasDuplicate = false;

                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(line[j])) {
                        rowHasDuplicate = true;
                    }

                    ColumnHelper columnHelper = columnMap.computeIfAbsent(j, k -> new ColumnHelper(new HashSet<>()));
                    if (columnHelper.isAlive && !columnHelper.items.add(line[j])) {
                        columnHelper.isAlive = false;
                        colRepeats++;
                    }
                }

                if (rowHasDuplicate) {
                    rowRepeats++;
                }
                rowSet.clear();
            }

            System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
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