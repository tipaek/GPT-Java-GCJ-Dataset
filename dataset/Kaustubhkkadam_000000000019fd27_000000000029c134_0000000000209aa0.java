import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <=testCases ; i++) {
            int matrixSize = in.nextInt();
            int trace = in.nextInt();



                int[] traceDiagonal = getTraceDiagonal(i, getNavieMatrix(matrixSize), trace);
                if (traceDiagonal != null) {
                    ArrayList<Integer> firstRow = getFirstRow(i, traceDiagonal, matrixSize);


                    if(firstRow != null) {

                      
                        ArrayList<ArrayList<Integer>> latinMatrix = getLatinMatrix(firstRow);


                        ArrayList<ArrayList<Integer>> finalMatrix = getFinalMatrix(i, traceDiagonal, latinMatrix);

                        if(finalMatrix!=null){
                            printResult(i, true, finalMatrix);
                        }



                    }
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

    private static ArrayList<Integer> getFirstRow (int caseNo, int[] diag, int size) {

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

        if(firstRow.size()!=size){
            printResult(caseNo, false, null);
            return  null;
        }
        return firstRow;
    }

    private static int[] getTraceDiagonal(int caseNo, ArrayList<Integer> input, int trace) {
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

        int totalSum = input.stream()
                .mapToInt(a -> a)
                .sum();
        if(totalSum != trace) {
            printResult(caseNo,false,null);
            return null;
        } else {
            return  input.stream().mapToInt(i -> i).toArray();
        }

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

    private static ArrayList<ArrayList<Integer>> getFinalMatrix(int caseNo, int[] diagonalArray, ArrayList<ArrayList<Integer>> naiveArray) {
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

        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(in);
        if(set.size() < in.size()){
            printResult(caseNo, false, null);
            return null;
        }

        return in;
    }
}

