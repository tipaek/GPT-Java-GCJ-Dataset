import java.util.*;

public class Solution {

    private static String outputString = "Case #%d: %d %d %d";

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<List<String>> matrixElements = new ArrayList<>();
        for(int i=0;i<testCases;i++) {
            int size = Integer.parseInt(in.nextLine());
            List<String> elements = new ArrayList<>();
            for(int j=0;j<size;j++) {
                String input = in.nextLine();
                elements.add(input);
            }
            matrixElements.add(elements);
        }

        int count = 1;
        for(List<String> matrix : matrixElements) {
            int len = matrix.size();
            int [][] elementMatrix = new int[len][len];
            fetchMatrix(elementMatrix, matrix);
            computeOutput(count, elementMatrix);
            count++;
        }
    }

    static void computeOutput(int testCase, int [][] elementMatrix) {
        int trace = 0;
        for(int i=0;i<elementMatrix.length;i++) {
            trace += elementMatrix[i][i];
        }

        int repeatedRowElements = 0;
        for(int i=0;i<elementMatrix.length;i++) {
            Set<Integer> rowElements = new HashSet<>();
            for(int j=0;j<elementMatrix[0].length;j++) {
                if(rowElements.contains(elementMatrix[i][j])){
                    repeatedRowElements++;
                    break;
                } else {
                    rowElements.add(elementMatrix[i][j]);
                }
            }
        }

        int repeatedColElements = 0;
        for(int i=0;i<elementMatrix[0].length;i++) {
            Set<Integer> colElements = new HashSet<>();
            for(int j=0;j<elementMatrix.length;j++) {
                if(colElements.contains(elementMatrix[j][i])){
                    repeatedColElements++;
                    break;
                } else {
                    colElements.add(elementMatrix[j][i]);
                }
            }
        }

        System.out.println(String.format(outputString, testCase, trace, repeatedRowElements, repeatedColElements));
    }

    static void fetchMatrix(int [][] elementMatrix, List<String> matrix) {
        for(int i=0;i<matrix.size();i++) {
            String [] values = matrix.get(i).split(" ");
            for(int col=0;col<values.length;col++){
                elementMatrix[i][col] = Integer.parseInt(values[col]);
            }
        }
    }
}