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
        //parentingPartnering();
        //esabatad();
        indicium();
    }
    
    private void indicium() {
        int testCases = readInteger();
        for (int testCase = 0;  testCase < testCases ; testCase++) {
            boolean possible = true;
            List<String> data = readLineAsList();
            int size = Integer.parseInt(data.get(0));
            int trace = Integer.parseInt(data.get(1));
            int maxTrace = (int)Math.pow((double)size, 2D);
            possible &= trace > size;
            possible &= trace <= maxTrace;
            possible &= trace - size > 0;
            if (!possible) {
                output(testCase, "IMPOSSIBLE");
                break;
            }
            
            List<List<Integer>> matrix = new ArrayList<List<Integer>>();
            for (int i = 0 ; i < size ; i++) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0 ; j < size ; j++) {
                    row.add(0);
                }
                matrix.add(row);
            }
            int builtTrace = buildTrace(matrix, trace);
            possible &= builtTrace == trace;
            
            
            for (int i = 0 ; i < size ; i++) {
                List<List<Integer>> rowProposals = new ArrayList<List<Integer>>();
                for(int j = 0 ; j < size ; j++) {
                    List<Integer> values = new ArrayList<Integer>();
                    for (int k = 1 ; k <= size ; k++) {
                        values.add(k);
                    }
                    rowProposals.add(values);
                }
                
                clearFromMatrixHoriz(i, matrix, rowProposals);
                clearFromMatrixVert(i, matrix, rowProposals);
                pickProposal(i, rowProposals);
                for (int j = 0 ; j < matrix.size() ; j++) {
                    matrix.get(i).set(j, rowProposals.get(j).get(0));
                }
                for (int j = 0 ; j < size ; j++) {
                    String row = matrix.get(j).toString();
                    row = row.replace("[", "").replace("]", "").replace(",", "").trim();
                    debug(" # " + row);
                }
                
            }
            
            output(testCase, possible ? "POSSIBLE" : "IMPOSSIBLE");
            if (possible) {
                for (int i = 0 ; i < size ; i++) {
                    String row = matrix.get(i).toString();
                    row = row.replace("[", "").replace("]", "").replace(",", "").trim();
                    System.out.println(row);
                }
            }
            
        }
        
    }
    
    private void clearFromMatrixHoriz(int rowIndex, List<List<Integer>> matrix, List<List<Integer>> rowProposals) {
        List<Integer> matrixRow = matrix.get(rowIndex);
        for (int c = 0 ; c < matrixRow.size(); c++) {
            Integer matrixCell = matrixRow.get(c);
            if (matrixCell > 0) {
                for (int mc = 0 ; mc < rowProposals.size() ; mc++) {
                    if (mc == c) {
                        rowProposals.get(mc).clear();
                        rowProposals.get(mc).add(matrixCell);        
                    } else {
                        rowProposals.get(mc).remove(Integer.valueOf(matrixCell));
                    }
                }
                
            }
        }
        debug("   clear Horiz rowProposals(" + rowIndex + ") = " + rowProposals);
    }
    
    private void clearFromMatrixVert(int rowIndex, List<List<Integer>> matrix, List<List<Integer>> rowProposals) {
        for (int i = 0 ; i < matrix.size() ; i++) {
            for (int j = 0 ; j < matrix.size() ; j++) {
                if (i == j && i == rowIndex) continue;
                Integer matrixVal = matrix.get(i).get(j);
                rowProposals.get(j).remove(matrixVal);
            }
        }
        debug("       clear Vert rowProposals(" + rowIndex + ") = " + rowProposals);
    }
    
    private void pickProposal(int rowIndex, List<List<Integer>> rowProposals) {
        boolean picked = true;
        
        while (picked) {
            picked = false;
            for (int i = 0 ; i < rowProposals.size() ; i++) {
                List<Integer> cellProposals = rowProposals.get(i);
                if (cellProposals.size() == 0) {
                    throw new IllegalArgumentException("Could not build latin square");
                } else if (cellProposals.size() == 1) {
                    continue;
                }
                picked = true;
                Integer pickedValue = cellProposals.get(0);
                cellProposals.clear();
                cellProposals.add(pickedValue);
                
                boolean cleanupDone = true;
                while (cleanupDone) {
                    cleanupDone = false;
                    for (int j = 0; j < rowProposals.size(); j++) {
                        if (rowProposals.get(j).size() == 0) {
                            throw new IllegalArgumentException("Could not build latin square");                        
                        } else if (rowProposals.get(j).size() > 1) {
                            continue;
                        }
                        Integer valueToRemove = rowProposals.get(j).get(0);
                        for (int k =0 ; k < rowProposals.size(); k++) {
                            if (k == j) continue;
                            cleanupDone |= rowProposals.get(k).remove(valueToRemove);
                        }
                    }
                }
                
                debug("       '- pickProposal(" + rowIndex + ") = " + rowProposals);
                break;
            }
        }
        
    }

    
    private int buildTrace(List<List<Integer>> matrix, int trace) {
        int value = trace - matrix.size();
        int totalTrace = 0;
        for (int xy = 0 ; xy < matrix.size(); xy++) {
            int remainingRows = matrix.size() - xy - 1;
            while (totalTrace + value + remainingRows > trace) {
                value--;
            }
            matrix.get(xy).set(xy, value);
            totalTrace+=value;
        }
        return totalTrace;
    }
    
    private void esabatad() {
        List<String> line = readLineAsList();
        int testCases = Integer.parseInt(line.get(0));
        int b = Integer.parseInt(line.get(1));
        
        for (int testCase = 0;  testCase < testCases ; testCase++) {
            List<Integer> array = new ArrayList<Integer>();
            for (int i = 0 ; i < b ; i++) {
                array.add(-1);
            }
        
            for (int i = 0 ; i < 150 ; i++) {
                debug("" + i);
                
                int value = readInteger();
                array.set(i % b, value);
                break;
            }
            
            String answer = "";
            for (int i = 0 ; i < b ; i++) {
                answer += array.get(i);
            }
            debug(answer);
            String ok = readLineAsString();
            if ("N".equals(ok)) {
                break;
            }
            break;
        }
        
        
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
            System.out.flush();
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