import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        if (t >= 1 && t <= 100) {
            for (int x = 0; x < t; x++) {
                int n = in.nextInt();
                
                if (n >= 2 && n <= 50) {
                    int[][] arr = new int[n][n];
                    fillArray(arr, n);
                    
                    int k = in.nextInt();
                    if (k >= n && k <= n * n) {
                        processArray(arr, x + 1, k);
                    }
                }
            }
        }
    }
    
    private static void fillArray(int[][] arr, int n) {
        for (int j = 0; j < n; j++) {
            int sum = j + 1;
            for (int i = 0; i < n; i++) {
                arr[i][j] = sum % n + 1;
                if (sum == n) {
                    sum = 0;
                }
                sum++;
            }
        }
    }
    
    private static void processArray(int[][] arr, int caseNumber, int targetTrace) {
        int trace = 0;
        int swapCounter = arr.length * (arr.length - 1) / 2;
        boolean isPossible = false;
        
        while (swapCounter > 0) {
            trace = calculateTrace(arr);
            
            if (trace == targetTrace) {
                isPossible = true;
                break;
            } else if (arr.length > 2) {
                if (trySwapping(arr, targetTrace)) {
                    isPossible = true;
                    break;
                }
            }
            --swapCounter;
        }
        
        printResult(caseNumber, isPossible, arr);
    }
    
    private static int calculateTrace(int[][] arr) {
        int trace = 0;
        for (int i = 0; i < arr.length; i++) {
            trace += arr[i][i];
        }
        return trace;
    }
    
    private static boolean trySwapping(int[][] arr, int targetTrace) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
                
                if (calculateTrace(arr) == targetTrace) {
                    return true;
                }
                
                // Swap back to original state
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return false;
    }
    
    private static void printResult(int caseNumber, boolean isPossible, int[][] arr) {
        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            for (int[] row : arr) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}