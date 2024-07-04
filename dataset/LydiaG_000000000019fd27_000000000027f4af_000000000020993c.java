import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            Set<Integer> row = new HashSet<>();
            List<Set<Integer>> column = new ArrayList<>();
            Set<Integer> columnsWithDuplicate = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String[] input = sc.nextLine().split(" ");
                boolean hasDuplicateRow = false;
                for (int k = 0; k < n; k++) {
                    if(j == 0){
                        column.add(new HashSet<Integer>());
                    }
                    int item = Integer.parseInt(input[k]);
                    if (j == k) {
                        trace += item;
                    }

                    if (row.contains(item)) {
                        if(!hasDuplicateRow){
                            duplicateRows++;
                            hasDuplicateRow = true;
                        }
                    }
                    row.add(item);

                    if(column.get(k).contains(item)){
                        if(!columnsWithDuplicate.contains(k)){
                            duplicateColumns++;
                            columnsWithDuplicate.add(k);
                        }
                    }

                    column.get(k).add(item);
                }

                row = new HashSet<>();
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}
