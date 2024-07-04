import java.util.*;

public class Main {

    static Map<Integer, Set<Integer>> columnsMap = new HashMap<>();
    static Map<Integer, Set<Integer>> rowsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer t = sc.nextInt();
        Integer caseNumber = 1;

        while (t-- != 0) {
            Integer n = sc.nextInt();
            Integer trace = 0;
            Set<Integer> columnRepeated = new HashSet<>();
            Set<Integer> rowRepeated = new HashSet<>();

            for (int i = 0; i < n; i++) {
                rowsMap.put(i, new HashSet<>());
                for (int j = 0; j < n; j++) {
                    Integer value = sc.nextInt();

                    // Create sets for each column
                    if (i == 0) {
                        columnsMap.put(j, new HashSet<>());
                    }

                    // Calculate trace
                    if (i == j) {
                        trace += value;
                    }

                    // Check if value is already present in a row o column
                    if (rowsMap.get(i).contains(value)) {
                        rowRepeated.add(i);
                    }
                    if (columnsMap.get(j).contains(value)) {
                        columnRepeated.add(j);
                    }

                    // Add value to column and row sets
                    columnsMap.get(j).add(value);
                    rowsMap.get(i).add(value);
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + rowRepeated.size() + " " + columnRepeated.size());

        }
    }

}
