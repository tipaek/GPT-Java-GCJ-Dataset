import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        for (int _ = 0; _ < q; _++) {
            int size = scanner.nextInt();
            List<List<Integer>> columns = new ArrayList<>();
            int firstTotal = 0;
            int sameRows = 0;
            int sameColumns = 0;
            
            for (int i = 0; i < size; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    int a = scanner.nextInt();
                    row.add(a);
                    if (j == i) {
                        firstTotal += a;
                    }
                    if (i == 0) {
                        columns.add(new ArrayList<>());
                    }
                    columns.get(j).add(a);
                }
                Collections.sort(row);
                int temp = row.get(0);
                for (int p = 1; p < row.size(); p++) {
                    if (temp.equals(row.get(p))) {
                        sameRows++;
                        break;
                    }
                    temp = row.get(p);
                }
            }
            
            for (List<Integer> column : columns) {
                Collections.sort(column);
                int temp = column.get(0);
                for (int j = 1; j < column.size(); j++) {
                    if (temp.equals(column.get(j))) {
                        sameColumns++;
                        break;
                    }
                    temp = column.get(j);
                }
            }
            
            System.out.println("Case #" + (_ + 1) + ": " + firstTotal + " " + sameRows + " " + sameColumns);
        }
        
        scanner.close();
    }
}