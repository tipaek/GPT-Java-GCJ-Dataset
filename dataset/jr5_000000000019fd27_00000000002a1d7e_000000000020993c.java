import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {

    long rowsContainingRepeatedValue = 0;
    long columnsContainingRepeatedValue = 0;
    long trace = 0;

    HashMap rowValues;

    List<Map> columnValueCountList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Vestigium vestigium = new Vestigium();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        vestigium.run(in, System.out);
    }

    public void run(Scanner in, PrintStream out) throws Exception {

        long numberOfTests = in.nextLong();

        for (int t = 1; t <= numberOfTests; t++) {

            processTestSet(in, out, t);

        }
    }

    private void processTestSet(Scanner in, PrintStream out, int t) {

        int matrixSize = in.nextInt();
        trace = 0;
        rowsContainingRepeatedValue = 0;
        columnsContainingRepeatedValue = 0;

        columnValueCountList.clear();
        for (long column = 0; column < matrixSize; column++) {
            columnValueCountList.add(new HashMap<Long, Long>(matrixSize));
        }

        in.nextLine();
        for (long row = 0; row < matrixSize; row++) {

            processRow(in, row, matrixSize);
        }


        analyseTestSet(out, t, matrixSize);
    }

    private void processRow(Scanner in, long row, int matrixSize) {

        String line = in.nextLine();

        System.out.println(String.format("Row %d: %s", row, line));

        String[] values = line.split("\\s+");

        // Calculate trace

        rowValues = new HashMap<Long, Long>(matrixSize);

        for (int column = 0; column < matrixSize; column++) {
            long value = Long.parseLong(values[column]);
            if (column == row) {
                trace += value;
            }
        }

        boolean duplicateFound = false;

        for (int column1 = 0; column1 < matrixSize; column1++) {
            long value = Long.parseLong(values[column1]);
            if (rowValues.containsKey(value)) {
                duplicateFound = true;
                break;
            } else {

                rowValues.put(value, 1L);
            }
        }

        if (duplicateFound) rowsContainingRepeatedValue++;

        for (int column2 = 0; column2 < matrixSize; column2++) {
            long value = Long.parseLong(values[column2]);

            Map columnValues = columnValueCountList.get(column2);

            if (columnValues.containsKey(value)) {
                columnValues.put(value, 2L);
            } else {
                columnValues.put(value, 1L);
            }
        }
    }


    private void analyseTestSet(PrintStream out, long t, int matrixSize) {

        for (long column = 0; column < matrixSize; column++) {
            Map columnValues = columnValueCountList.get((int) column);

            for(long value=1; value<matrixSize+1; value++) {
                if (columnValues.containsKey(value) && columnValues.get(value).equals(2L)) {
                    columnsContainingRepeatedValue++;
                    break;
                }
            }
        }

        out.println(String.format("Case #%d: %d %d %d", t, trace, rowsContainingRepeatedValue, columnsContainingRepeatedValue));

    }
}

