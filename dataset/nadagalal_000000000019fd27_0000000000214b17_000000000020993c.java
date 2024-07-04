import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberOfTestCases = scanner.nextLine();
        System.out.println(numberOfTestCases);
        for (int i = 0; i < Integer.parseInt(numberOfTestCases); i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[N][N];
            int noOfRepeatedRows = 0;
            int noOfRepeatedCol = 0;
            int trace = 0;

                for (int k = 0; k < N; k++) {
                    //rows
                    String rowNumbers = scanner.nextLine();
                    String[] numbersSplitted = rowNumbers.split(" ");
                    for (int l = 0; l < N; l++) {
                        //col
                        matrix[k][l] = Integer.parseInt(numbersSplitted[l]);
                    }
                }
                for (int k = 0; k < N; k++) {
                    //rows
                    Set<Integer> repeatedInRows = new HashSet();
                    for (int l = 0; l < N; l++) {
                        repeatedInRows.add(matrix[k][l]);
                        if (l == k) {
                            trace = trace + matrix[k][l];
                        }

                    }
                    if (repeatedInRows.size() < N) {
                        noOfRepeatedRows++;
                    }
                }

                for (int col = 0; col < N; col++) {
                    Set<Integer> repeatedInCol = new HashSet();
                    for (int row = 0; row < N; row++) {
                        repeatedInCol.add(matrix[row][col]);
                    }
                    if (repeatedInCol.size() < N) {
                        noOfRepeatedCol++;
                    }
                }
                System.out.println("case #" + (i+1) +":"+ " " + trace + " " + noOfRepeatedRows + " " + noOfRepeatedCol);
            }
        }
        }


