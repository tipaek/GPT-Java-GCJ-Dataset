import java.util.*;


public class Solution {

    public static final void main(String... args) {
        new Solution();
    }
    
    
    private final Scanner scanner = new Scanner(System.in);
    
    private final boolean debug = true;
    
    public Solution() {
        vestigium();
    
    }
    
    
    private void vestigium() {
        int testCases = readInteger();
        
        for (int testCase = 0;  testCase < testCases ; testCase++) {
            int size = readInteger();
            debug("Case #" + testCase + " size=" + size);
            List<List<String>> matrix = new ArrayList<List<String>>();
            for (int i = 0 ; i < size ; i++) {
                List<String> row = readLineAsList();
                matrix.add(row);
                debug(row.toString());
            }
            int trace = getTrace(matrix);
            int badRows = countBadRows(matrix);
            int badCols = countBadCols(matrix);
            debug("trace=" + trace + " badrows=" + badRows + " badcols=" + badCols);
        }
        
    }
    
    private int getTrace(List<List<String>> matrix) {
        int trace = 0;
        for (int i = 0 ; i < matrix.size() ; i++) {
            trace += Integer.parseInt(matrix.get(i).get(i));
        }
        return trace;
    }
    
    private int countBadCols(List<List<String>> matrix) {
        int badCols = 0;
        
        for (int i = 0; i < matrix.size() ; i++) {
            List<String> column = new ArrayList<String>();
            for (int j = 0; j < matrix.size() ; j++) {
                column.add(matrix.get(j).get(i));
            }
            
            for (int j = 0; j < matrix.size() ; j++) {
                String value = "" + (j+1);
                if (!column.contains(value)) {
                    badCols++;
                    break;
                }
            }
        }
        return badCols;
    }
    
    private int countBadRows(List<List<String>> matrix) {
        int badRows = 0;
        
        for (int i = 0; i < matrix.size() ; i++) {
            List<String> row = matrix.get(i);
            
            for (int j = 0; j < matrix.size() ; j++) {
                String value = "" + (j+1);
                if (!row.contains(value)) {
                    badRows++;
                    break;
                }
            }
        }
        
        return badRows;
    }
    
    private void debug(String message) {
        if (debug) {
            System.out.println(message);
        }
    }
    
    private void output(int i, String message) {
        System.out.println("Case #" + (i+1) + ": " + message);
    }
    
    private String readLineAsString() {
        return scanner.nextLine();
    }
    
    private List<String> readLineAsList() {
        String[] line = scanner.nextLine().split(" ");
        return new ArrayList<String>(Arrays.asList(line));
    }
    
    private int readInteger() {
        return Integer.parseInt(scanner.nextLine());
    }
    
}