import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader inputReader = new InputReader(inputStream);
        int testCases = inputReader.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = inputReader.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            
            for (int row = 0; row < matrixSize; row++) {
                ArrayList<Integer> currentRow = new ArrayList<>();
                for (int col = 0; col < matrixSize; col++) {
                    currentRow.add(inputReader.nextInt());
                }
                matrix.add(currentRow);
            }
            
            int trace = 0;
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix.get(i).get(j);
                    }
                    rowSet.add(matrix.get(i).get(j));
                    colSet.add(matrix.get(j).get(i));
                }
                
                if (rowSet.size() != matrixSize) {
                    rowsWithDuplicates++;
                }
                if (colSet.size() != matrixSize) {
                    colsWithDuplicates++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
    }
    
    static class InputReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        
        public InputReader(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }
        
        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}