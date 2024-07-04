import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> matrix = new ArrayList<>();
            int rowDuplicates = 0, colDuplicates = 0, trace = 0;
            
            for (int j = 0; j < size; j++) {
                List<Integer> line = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                String[] input = scanner.nextLine().split(" ");
                
                for (int k = 0; k < size; k++) {
                    int num = Integer.parseInt(input[k]);
                    line.add(num);
                    set.add(num);
                    if (j == k) {
                        trace += num;
                    }
                }
                
                matrix.add(line);
                if (set.size() < size) {
                    rowDuplicates++;
                }
            }
            
            for (int j = 0; j < size; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    set.add(matrix.get(k).get(j));
                }
                if (set.size() < size) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}