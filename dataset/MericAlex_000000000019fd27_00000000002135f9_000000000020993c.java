import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer maxCases = Integer.valueOf(scanner.nextLine());
        int currentCase = 0;
        while(maxCases != currentCase) {
            ArrayList<Integer> traceList = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> rowMainList = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> colMainList = new ArrayList<ArrayList<Integer>>();
            int k = 0;
            int r = 0;
            int c = 0;
            Integer matrixSize = Integer.valueOf(scanner.nextLine());
            Integer [] [] matrix = new Integer[matrixSize][matrixSize];
            for (int gen = 0; gen < matrixSize; gen++) {
                ArrayList<Integer> rowSubList = new ArrayList<Integer>();
                ArrayList<Integer> colSubList = new ArrayList<Integer>();
                rowMainList.add(rowSubList);
                colMainList.add(colSubList);
            }
            for (int currentRow = 0; currentRow < matrixSize; currentRow++) {
                String line = scanner.nextLine();
                String[] processLine = line.split("\\s+");
                int currentCol = 0;
                for (String value : processLine) {
                    matrix[currentRow] [currentCol] = Integer.valueOf(value);
                    rowMainList.get(currentRow).add(Integer.valueOf(value));
                    colMainList.get(currentCol).add(Integer.valueOf(value));
                    if(currentRow == currentCol) {
                        traceList.add(Integer.valueOf(value));
                    }
                    currentCol++;
                }
            }
            for (Integer kValue : traceList) {
                k = k + kValue;
            }
            for (ArrayList rowList : rowMainList) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (Object rValue : rowList) {
                    Integer rValueInt = Integer.valueOf((Integer) rValue);
                    if (tempList.contains(rValueInt)) {
                        r++;
                        break;
                    } else {
                        tempList.add(rValueInt);
                    }
                }
            }
            for (ArrayList colList : colMainList) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (Object cValue : colList) {
                    Integer cValueInt = Integer.valueOf((Integer) cValue);
                    if (tempList.contains(cValueInt)) {
                        c++;
                        break;
                    } else {
                        tempList.add(cValueInt);
                    }
                }
            }
            System.out.println("Case #" + (currentCase + 1) + ": " + k + " " + r + " " + c);
            currentCase++;
        }
    }
}