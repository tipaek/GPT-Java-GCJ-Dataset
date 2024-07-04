import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int rows = scanner.nextInt();
                int columns = scanner.nextInt();
                int arr[][] = new int[rows][columns];
                double interests[][] = new double[rows][columns];
                int totalInterest = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        arr[i][j] = scanner.nextInt();
                        totalInterest += arr[i][j];
                    }
                }

                if (rows == 1 && columns == 1) {
                    System.out.println("Case #" + (idx+1) + ": " + totalInterest);
                    continue;
                }
                
                boolean isRemaining = true;
                do {
                    interests = calculateInterest(arr, rows, columns);
                    //printMatrix(interests, rows, columns);
                    int numElmiminated = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            if (arr[i][j] != -1) {
                                double averageInterest = interests[i][j];
                                if (Double.compare(arr[i][j], averageInterest) < 0) {
                                    arr[i][j] = -1;
                                    numElmiminated++;
                                }
                            }
                        }
                    }
                    //printMatrix(arr, rows, columns);
                    
                    isRemaining = numElmiminated > 0;
                    if (numElmiminated > 0) {
                        int sum = calculateSum(arr, rows, columns);
                        totalInterest += sum;
                        //System.out.println("Sum = " + sum);
                    }
                    
                } while (isRemaining);
                System.out.println("Case #" + (idx+1) + ": " + totalInterest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static int calculateSum(int[][] arr, int rows, int columns) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] != -1)
                    sum += arr[i][j];
            }
        }
        return sum;
    }

    private static double[][] calculateInterest(int[][] arr, int rows, int columns) {
        double[][] interests = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] == -1) 
                    continue;
                int t = 0;
                int n = 0;
                for (int k = j+1; k < columns; k++) {
                    if (arr[i][k] != -1) {
                        t += arr[i][k];
                        n++;
                        break;
                    }
                }
                for (int k = j-1; k >= 0; k--) {
                    if (arr[i][k] != -1) {
                        t += arr[i][k];
                        n++;
                        break;
                    }
                }
                for (int k = i-1; k >= 0; k--) {
                    if (arr[k][j] != -1){
                        t += arr[k][j];
                        n++;
                        break;
                    }
                }
                for (int k = i+1; k < rows; k++) {
                    if (arr[k][j] != -1) {
                        t += (arr[i+1][j] > 0 ? arr[i+1][j] : 0);
                        n++;
                        break;
                    }
                }
                if (n > 0)
                    interests[i][j] = t / (double) n;
                else 
                    interests[i][j] = 0;
            }
        }
        return interests;
    }
}