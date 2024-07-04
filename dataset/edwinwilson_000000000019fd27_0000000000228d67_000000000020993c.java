    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int matrixSize = 0;
        String solution = "";

        for(int currentCase = 1; currentCase <= numCases; currentCase++) {
            matrixSize = in.nextInt();
            int nbDuplicateRows = 0;
            HashMap<Integer, HashSet> columns = new HashMap<>();
            HashSet<Integer> duplicateColumns = new HashSet<>();
            int trace = 0;
            solution += "Case #" + currentCase + ": ";

            for(int i = 1; i <= matrixSize; i++) {
                Boolean isDuplicateRow = false;
                HashSet<Integer> currentRow = new HashSet<>();
                // init rows set

                for(int j = 1; j <= matrixSize; j++) {
                    if(i == 1) {
                        columns.put(j, new HashSet<>());
                    }
                    int element = in.nextInt();

                    // check duplicate row
                    if(isDuplicateRow == false) {
                        if(currentRow.contains(element)) {
                            isDuplicateRow = true;
                            nbDuplicateRows++;
                        } else {
                            currentRow.add(element);
                        }
                    }

                    // check duplicate column
                    if(!duplicateColumns.contains(j)) {
                        if(columns.get(j).contains(element)) {
                            duplicateColumns.add(j);
                        } else {
                            columns.get(j).add(element);
                        }
                    }

                    // add to trace
                    if(i == j) {
                        trace += element;
                    }
                }
            }

            solution += trace + " " + nbDuplicateRows + " " + duplicateColumns.size();
            solution += "\n";
        }

        System.out.print(solution);
      }
    }
