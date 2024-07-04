
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution m = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            m.run(in);
            System.out.println();
        }
    }

    Long matrixSize = 0L;
    long matrixTrace = 0;
    long sameInRows = 0;
    long sameInCol = 0;
    Map<Integer, List<Long>> columnMap = new HashMap<>();

    void clear() {
        columnMap = new HashMap<>();
        matrixTrace = 0;
        sameInRows = 0;
        sameInCol = 0;
    }

    void run(Scanner in) {
        int matrixTraceNrInRow = 0;

        matrixSize = in.nextLong();
        clear();

        for (int i = 0; i < matrixSize; i++) {
            List<Long> row = new ArrayList<>();

            for (int j = 0; j < matrixSize; j++) {
                Long value = in.nextLong();
                row.add(value);

                // columns map
                List<Long> c = Optional.ofNullable(columnMap.get(j)).orElse(new ArrayList<>());
                c.add(value);
                columnMap.put(j, c);
            }
            matrixTrace += row.get(matrixTraceNrInRow);
            if (row.size() != new HashSet<>(row).size()) sameInRows++;

            matrixTraceNrInRow++;
        }

        sameInCol = columnMap.entrySet().stream().filter(e -> e.getValue().size() != new HashSet<>(e.getValue()).size()).count();
        System.out.print(matrixTrace + " " + sameInRows + " " + sameInCol);
    }
}
