import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int di = scanner.nextInt();
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            HashMap<Integer, HashSet<Integer>> columnsMap = new HashMap<>();
            
            for (int j = 0; j < di; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;
                
                for (int k = 0; k < di; k++) {
                    int num = scanner.nextInt();
                    
                    columnsMap.putIfAbsent(k, new HashSet<>());
                    HashSet<Integer> columnSet = columnsMap.get(k);
                    columnSet.add(num);
                    
                    if (!hasDuplicateInRow) {
                        if (rowSet.contains(num)) {
                            hasDuplicateInRow = true;
                        } else {
                            rowSet.add(num);
                        }
                    }
                    
                    if (j == k) {
                        diagonalSum += num;
                    }
                }
                
                if (hasDuplicateInRow) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < di; j++) {
                if (columnsMap.get(j).size() != di) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}