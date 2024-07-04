import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int trace = 0;
            int rowDupCount = 0;
            int colDupCount = 0;

            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            Set<Integer> rowDupSet = new HashSet<>();
            Set<Integer> colDupSet = new HashSet<>();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int input = scanner.nextInt();
                    if (i == j) {
                        trace += input;
                    }
                    
                    rowMap.putIfAbsent(i, new HashSet<>());
                    colMap.putIfAbsent(j, new HashSet<>());

                    if (!rowMap.get(i).add(input) && rowDupSet.add(i)) {
                        rowDupCount++;
                    }
                    
                    if (!colMap.get(j).add(input) && colDupSet.add(j)) {
                        colDupCount++;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + rowDupCount + " " + colDupCount);
        }
        
        scanner.close();
    }
}