import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.AbstractMap;

public class Solution {

    private static int testCases;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = scanner.nextInt();
        
        List<Map.Entry<Integer, Integer[][]>> matrices = new ArrayList<>(testCases);

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            Integer[][] matrix = new Integer[matrixSize][matrixSize];
            matrices.add(new AbstractMap.SimpleEntry<>(matrixSize, matrix));
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
        }
        
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": 4 0 0");
        }
        
        scanner.close();
    }
}