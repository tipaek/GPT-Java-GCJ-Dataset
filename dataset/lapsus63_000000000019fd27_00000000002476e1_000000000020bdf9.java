import java.util.*;


public class Solution {

    public static final void main(String... args) {
        try {
            new Solution();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    
    private final Scanner scanner = new Scanner(System.in);
    
    private final boolean debug = false;
    
    public Solution() {
        // vestigium();
        //nestingDepth();
        parentingPartnering();
    }
    
    private void parentingPartnering() {
        int testCases = readInteger();
        for (int testCase = 0;  testCase < testCases ; testCase++) {
            int n = readInteger();
            String y = "";
            boolean impossible = false;
            List<List<Integer>> cameron = new ArrayList<List<Integer>>();
            List<List<Integer>> jamie = new ArrayList<List<Integer>>();
            for (int i = 1 ; i <= n ; i++) {
                List<String> line = readLineAsList();
                int si = Integer.parseInt(line.get(0));
                int ei = Integer.parseInt(line.get(1));
                List<Integer> period = Arrays.asList(si, ei);
                String target = assignTo(cameron, jamie, period);
                impossible |= "IMPOSSIBLE".equals(target);
                debug("i=" + i + " si=" + si +  " ; ei=" + ei + " => target=" + target);
                debug("     cameron=" + cameron + " jamie=" + jamie);
                y += target;
            }
            debug("");
            
            output(testCase, impossible ? "IMPOSSIBLE" : y);
        }
        
    }
    
    private String assignTo(List<List<Integer>> cameron, List<List<Integer>> jamie, List<Integer> period) {
        
        boolean intersectFound = false;
        for (List<Integer> p : cameron) {
            intersectFound |= intersection(p, period);
            if (intersectFound) break;
        }
        if (!intersectFound) {
            cameron.add(period);
            return "C";
        }
        
        intersectFound = false;
        for (List<Integer> p : jamie) {
            intersectFound |= intersection(p, period);
            if (intersectFound) break;
        }
        if (!intersectFound) {
            jamie.add(period);
            return "J";
        }
        return "IMPOSSIBLE";
    }
    
    private boolean intersection(List<Integer> p1, List<Integer> p2) {
        boolean out = p2.get(1) <= p1.get(0) || p2.get(0) >= p1.get(1);
        return !out;
    }
    
    private void nestingDepth() {
        int testCases = readInteger();
        for (int testCase = 0;  testCase < testCases ; testCase++) {
            String s = readLineAsString();
            
            int depth = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() ; i++) {
                String c = s.substring(i, i+1);
                depth = buildS(sb, c, depth);
            }
            depth = buildS(sb, null, depth);
            
            debug("Case #" + testCase + " : s=" + s + " depth=" + depth + " and S'=" + sb.toString());
            output(testCase, sb.toString());
        }
        
    }
    
    private int buildS(StringBuilder sb, String c, int depth) {
        
        int value = Integer.parseInt(c == null ? "0" : c);
        
        while (value > depth) {
            sb.append("(");
            depth++;
        }
        while (value < depth) {
            sb.append(")");
            depth--;
        }
        
        if (value == depth && c != null) {
            sb.append(c);
            return depth;
        }
        
        return depth;
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
            output(testCase, "" + trace + " " + badRows + " " + badCols);
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