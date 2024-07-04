
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < testCases; i++) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int N = Integer.parseInt(scanner.nextLine().trim());
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] strings = scanner.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(strings[k]);
                }
            }

            checkVestigium(matrix, N, i+1);
        }
        System.exit(0);
    }

    private static void checkVestigium(int[][] matrix, int N, int testCase) {
        Set<Integer>[] rowSetArr = new Set[N];
        Set<Integer>[] colSetArr = new Set[N];
        for (int i = 0; i < N; i++) {
            rowSetArr[i] = new HashSet<>();
            colSetArr[i] = new HashSet<>();
        }

        int diagonalSum = 0, duplicateRows = 0, duplicateCols = 0;
        boolean[] colFoundBool = new boolean[N];

        for (int i = 0; i < N; i++) {
            boolean isDuplicatePresentInThisRow = false;
            for (int j = 0; j < N; j++) {
                //calculate diagonal sum
                if(i == j) {
                    diagonalSum += matrix[i][j];
                }
                if(rowSetArr[i].contains(matrix[i][j]) ) {
                    if(!isDuplicatePresentInThisRow) {
                        isDuplicatePresentInThisRow = true;
                        duplicateRows++;
                    }
                }else {
                    rowSetArr[i].add(matrix[i][j]);
                }

                if(colSetArr[j].contains(matrix[i][j])) {
                    if(!colFoundBool[j]) {
                        colFoundBool[j] = true;
                        duplicateCols++;
                    }
                } else {
                    colSetArr[j].add(matrix[i][j]);
                }

            }
        }

        System.out.println( "Case #"+testCase+": "+diagonalSum + " " + duplicateRows+ " "+ duplicateCols);
    }
}
