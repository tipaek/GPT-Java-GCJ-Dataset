import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author schenevotot
 */
public class Solution {

    private static final boolean DEBUG = false;

    private int trace = 0;
    private int rowReapeted = 0;
    private int colReapeted = 0;
    private List<Set<Integer>> cols = null; 

    public Solution(int size) {
        cols = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            cols.add(new HashSet<>(size));
        }
    }
    
    public String solve() {
        for (Set<Integer> col: cols) {
            if (col.size() < cols.size()) {
                colReapeted ++;
            }
        }
        
       return trace + " " + rowReapeted + " " +colReapeted;
    }

    public void addRow(String row, int rowId) {
        String[] rowValues = row.split(" ");

        List<Integer> rowValuesList = new ArrayList<>(rowValues.length);
        for (int i = 0; i < rowValues.length; i++) {
            int value = Integer.parseInt(rowValues[i]);
            if (i == rowId) {
                trace += value;
            }
            rowValuesList.add(value);
            
            cols.get(i).add(value);
        }

        if (!areAllUnique(rowValuesList)) {
            rowReapeted++;
        }
        
    }

    private static boolean areAllUnique(List<Integer> list) {
        return list.stream().allMatch(new HashSet<>()::add);
    }

    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Solution solver = null;

        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(Objects.requireNonNull(classLoader.getResource("Vestigium-1.in")).getPath()) : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int matrixSize = scanner.nextInt();
                solver = new Solution(matrixSize);
                scanner.nextLine();
                for (int rowId = 0; rowId < matrixSize; rowId++) {
                    String rowStr = scanner.nextLine();
                    solver.addRow(rowStr, rowId);
                }
                String result = solver.solve();
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
       //System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}