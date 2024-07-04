import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.valueOf(scanner.nextLine());
        int size = 0;
        int trace = 0;
        int duplicateRow = 0;
        int duplicateCol = 0;
        boolean[] shouldSkipColMemo;
        for (int i = 1; i <= total; i++) {
            size = Integer.valueOf(scanner.nextLine());
            shouldSkipColMemo = new boolean[size];
            Map<Integer, Set<String>> colChecker = new HashMap<>();
            for (int k = 0; k < size; k++) {
                String line = scanner.nextLine();
                String[] row = line.split(" ");
                trace += Integer.valueOf(row[k]);

                Set<String> rowReducer = Stream.of(row).collect(Collectors.toSet());
                if (rowReducer.size() != size) {
                    duplicateRow += 1;
                }
                if (k == 0) {
                    for (int l = 0; l < size; l++) {
                        colChecker.put(l, new HashSet<>());
                        colChecker.get(l).add(row[l]);
                    }
                } else {
                    for (int l = 0; l < size; l++) {
                        if (shouldSkipColMemo[l] == true) {
                            continue;
                        }
                        colChecker.get(l).add(row[l]);
                        if (colChecker.get(l).size() != k + 1) {
                            shouldSkipColMemo[l] = true;
                            duplicateCol += 1;
                        }

                    }
                }

                if (duplicateCol == size) {
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + duplicateRow + " " + duplicateCol);
        }
    }

}
