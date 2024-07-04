import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int trace = 0;
            
            ArrayList<TreeSet<Integer>> rows = new ArrayList<>();
            ArrayList<TreeSet<Integer>> columns = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                rows.add(new TreeSet<>());
                columns.add(new TreeSet<>());
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    rows.get(i).add(value);
                    columns.get(j).add(value);
                    
                    if (i == j) {
                        trace += value;
                    }
                }
            }
            
            int rowDuplicates = countDuplicates(rows, n);
            int columnDuplicates = countDuplicates(columns, n);
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
        
        scanner.close();
    }
    
    private static int countDuplicates(ArrayList<TreeSet<Integer>> sets, int size) {
        int duplicates = 0;
        
        for (TreeSet<Integer> set : sets) {
            if (set.size() != size) {
                duplicates++;
            }
        }
        
        return duplicates;
    }
}