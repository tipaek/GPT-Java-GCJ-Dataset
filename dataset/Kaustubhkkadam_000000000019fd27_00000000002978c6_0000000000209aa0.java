import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <=testCases ; i++) {
            int matrixSize = in.nextInt();
            int trace = in.nextInt();

            if ((trace%matrixSize) == 0) {

                int[] traceDiagonal = getTraceDiagonal(getNavieMatrix(matrixSize), trace);
                ArrayList<Integer> firstRow = getFirstRow(traceDiagonal, matrixSize);
                ArrayList<ArrayList<Integer>> latinMatrix = getLatinMatrix(firstRow);
                ArrayList<ArrayList<Integer>> finalMatrix = getFinalMatrix(traceDiagonal,latinMatrix);

                printResult(i, true, finalMatrix);

            } else {
                printResult(i, false, null);

            }
        }
    }

    private static void printResult(int caseNumber, boolean result, ArrayList<ArrayList<Integer>> finalMatrix) {

        if(result){
            System.out.println("\nCase #" + caseNumber + ": POSSIBLE");

            for (ArrayList<Integer> row : finalMatrix) {
                for (Integer element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }

        }else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");

        }
    }

    private static ArrayList<Integer> getFirstRow (int[] diag, int size) {

        ArrayList<Integer> possibleInputs = new ArrayList<>();

        for (int i = 0; i < size ; i++) {
            possibleInputs.add(i+1);
        }

        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(diag[0]);

        possibleInputs.remove(new Integer(diag[0]));

        int i = 1;
        for (int j = 0; j < possibleInputs.size() ; j++) {

            if(possibleInputs.get(j) != diag[i]){
                firstRow.add(possibleInputs.get(j));
                possibleInputs.remove(j);
                j = -1;
                i++;
            }

        }
        return firstRow;
    }

    private static int[] getTraceDiagonal(ArrayList<Integer> input, int trace) {
        for (int i = 0; i <= input.size() + 1; i++) {
            int sum = 0;
            for (int k = 0; k < input.size(); k++) {
            sum += input.get(k);
        }
            if (sum > trace) {
                input.set(input.indexOf(Collections.max(input)), Collections.max(input)-1);
            } else if (sum < trace) {
                input.set(input.indexOf(Collections.min(input)), Collections.min(input)+1);
            } else {
                break;
            }
        }
        return  input.stream().mapToInt(i -> i).toArray();
    }

    private static ArrayList<Integer> getNavieMatrix (int size) {
        ArrayList<Integer> o = new ArrayList<>();
        for (int i = 0; i < size; i++) {


                o.add(i+1);
        }
       return o;
    }

    private static ArrayList<ArrayList<Integer>> getLatinMatrix(ArrayList<Integer> si) {
        ArrayList<ArrayList<Integer>> in = new ArrayList<>();
        int temp =0;

        for (int i = 0; i < si.size(); i++) {
            ArrayList<Integer> ins = new ArrayList<>();
            ins.addAll(si);
            temp = si.get(si.size()-1);
            for (int j = si.size()-1; j > 0 ; j--) {
                si.set(j,si.get(j-1));
            }
            si.set(0,temp);


            in.add(ins);

        }
        return in;
    }

    private static ArrayList<ArrayList<Integer>> getFinalMatrix(int[] diagonalArray, ArrayList<ArrayList<Integer>> naiveArray) {
        ArrayList<ArrayList<Integer>> in = new ArrayList<>();
        for (int i = 0; i < naiveArray.size(); i++) {
            int num = diagonalArray[i];
            for (int j = 0; j < naiveArray.size(); j++) {
                if (naiveArray.get(j).get(i) == num) {
                    in.add(naiveArray.get(j));
                    break;
                }
            }
        }
        return in;
    }
}

