import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase=0; testCase < testCases; testCase++) {
            int matrixSize = sc.nextInt();

            int tSum = 0;
            int rCol = 0;
            int rRow = 0;

            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> numbersInRow = new HashSet<>();

                for (int j = 0; j < matrixSize; j++) {
                    int n = sc.nextInt();
                    numbersInRow.add(n);

                    if (i == j) {
                        tSum += n;
                    }

                    if (!colMap.containsKey(j)) {
                        colMap.put(j, new HashSet());
                    }

                    colMap.get(j).add(n);
                }

                if (numbersInRow.size() < matrixSize) {
                    rRow++;
                }
            }

            for (int c = 0; c < matrixSize; c++) {
                Set<Integer> colNumbers = colMap.get(c);

                if (colNumbers.size() < matrixSize) {
                    rCol++;
                }
            }

            System.out.println("Case #" + testCase + ": " + tSum + " " + rRow + " " + rCol); //Case #1: 4 0 0
        }
    }
}